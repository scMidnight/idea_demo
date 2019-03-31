package person.Thread;

import jodd.util.StringUtil;
import person.db.bean.TblAreaBean;
import person.db.bean.TblCarSystemBean;
import person.db.bean.TblFileDetailBean;
import person.db.bean.TblUserBean;
import person.handler.FileDetailHandler;
import person.handler.UserHandler;
import person.util.CarUtil;
import person.util.ExcelUtil;
import person.util.MobileFromUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by SunChang on 2018/9/7
 */
public class CheckPackageThread implements Callable<List<TblFileDetailBean>> {
    private String fileId;
    private FileDetailHandler fileDetailHandler;
    private List<String> blacks;
    private List<TblAreaBean> areaBeans;
    private List<TblCarSystemBean> carSystemBeans;
    private String excelPath;
    private Date uploadDate;
    private UserHandler userHandler;
    private String userId;

    public CheckPackageThread(String fileId, FileDetailHandler fileDetailHandler, List<String> blacks, List<TblAreaBean> areaBeans, List<TblCarSystemBean> carSystemBeans, String excelPath, Date uploadDate, UserHandler userHandler, String userId) {
        this.fileId = fileId;
        this.fileDetailHandler = fileDetailHandler;
        this.blacks = blacks;
        this.areaBeans = areaBeans;
        this.carSystemBeans = carSystemBeans;
        this.excelPath = excelPath;
        this.uploadDate = uploadDate;
        this.userHandler = userHandler;
        this.userId = userId;
    }

    @Override
    public List<TblFileDetailBean> call() throws Exception {
        List<TblFileDetailBean> fileDetailBeans1 = new ArrayList<TblFileDetailBean>();
        TblUserBean userBean = userHandler.loadByUserId(userId);
        try {
            System.out.println("读取文件内容");
            LinkedList<String> list = ExcelUtil.read(excelPath);
            for (int i = 0; i < list.size(); i++) {
                if(i != 0) {
                    String[] vals = list.get(i).split("\t");
                    if(vals == null || vals.length == 1) {
                        continue;
                    }
                    TblFileDetailBean fileDetailBean = CarUtil.getFileDetailBean(vals);
                    fileDetailBean.setFileName(list.getLast());
                    fileDetailBean.setFileId(fileId);
                    fileDetailBean.setUploadDate(uploadDate);
                    fileDetailBean.setOrderNum(String.valueOf(i+1));
                    if (StringUtil.isBlank(vals[0])
                            || StringUtil.isBlank(vals[1])
                            || StringUtil.isBlank(vals[2])
                            || StringUtil.isBlank(vals[3])) {
                        fileDetailBean.setStatus("6");
                        fileDetailBean.setErrInfo(list.getLast() + " 第" + (i+1) + "行错误，状态：ID转失败，字段为空");
                        fileDetailBeans1.add(fileDetailBean);
                        continue;
                    }
                    if(CarUtil.isBlack(blacks, fileDetailBean.getPhone())) {
                        if(userBean.getIsBlack().equals("1")) {
                            fileDetailBean.setStatus("4");//黑名单命中
                            fileDetailBean.setErrInfo(list.getLast() + " 第" + (i + 1) + "行错误，状态：黑名单命中");
                            fileDetailBeans1.add(fileDetailBean);
                            continue;
                        }
                    }
                    //获取车系对应ID，如果没有就视为转id失败
                    TblCarSystemBean carSystemBean = CarUtil.getCarSysId(carSystemBeans, vals[3]);
                    if(carSystemBean != null) {
                        fileDetailBean.setCarSys(carSystemBean.getCarSysId());
                        fileDetailBean.setBrand(carSystemBean.getBrandId());
                        fileDetailBean.setTrade(carSystemBean.getTradeId());
                    }else {
                        fileDetailBean.setStatus("6");
                        fileDetailBean.setErrInfo(list.getLast() + " 第" + (i+1) + "行车系转换错误，状态：ID转失败");
                        fileDetailBeans1.add(fileDetailBean);
                        continue;
                    }
                    String cityId = CarUtil.getCityId(areaBeans, vals[2]);
                    if (StringUtil.isNotBlank(cityId)) {
                        fileDetailBean.setArea(cityId);
                    }else {
                        fileDetailBean.setStatus("6");//城市转id失败
                        fileDetailBean.setErrInfo(list.getLast() + " 第" + (i + 1) + "行城市转id错误，状态：ID转失败");
                        fileDetailBeans1.add(fileDetailBean);
                        continue;
                    }
                    if(CarUtil.check4(fileDetailBean, fileDetailHandler)) {//检查手机号后4位连号3+三个以上+品牌相同30天内数据
                        fileDetailBean.setIsLian("1");
                    }
                    if(CarUtil.check6(fileDetailBean, fileDetailHandler)) {//检查手机号前6位相同+三个以上+品牌相同+30天内数据
                        fileDetailBean.setIsChong("1");
                    }
                    if(userBean.getIsPhone().equals("1")) {
                        String mobileFrom = MobileFromUtil.getMobileFrom(vals[1]);//得到归属地
                        //String mobileFrom = MobileFromUtil.getMobileFromBd(vals[1]);//得到归属地
                        if(!CarUtil.checkFromPhone(vals[2], mobileFrom)) {
                            fileDetailBean.setStatus("5");//号段错误或者城市转id失败
                            fileDetailBean.setErrInfo(list.getLast() + " 第" + (i + 1) + "行错误，状态：号段错误，文件中是" + vals[2] + "，根据号码查询后为：" + mobileFrom);
                        }
                    }
                    if (CarUtil.checkCarSys(carSystemBean.getCarSysId(), fileDetailBean.getPhone(), fileDetailHandler)) {
                        fileDetailBean.setStatus("3");//车系重复
                        fileDetailBean.setErrInfo(list.getLast() + " 第" + (i + 1) + "行错误，状态：车系重复");
                        fileDetailBeans1.add(fileDetailBean);
                        continue;
                    }
                    if(userBean.getisBrand().equals("1")) {//品牌
                        if(CarUtil.checkBrand(fileDetailBean, fileDetailHandler)) {
                            fileDetailBean.setStatus("7");
                            fileDetailBean.setErrInfo(list.getLast() + " 第" + (i+1) + "行品牌重复，状态：品牌重复");
                            fileDetailBeans1.add(fileDetailBean);
                            continue;
                        }
                    }
                    if(userBean.getIsTrade().equals("1")) {//厂商
                        if(CarUtil.checkTrade(fileDetailBean, fileDetailHandler)) {
                            fileDetailBean.setStatus("8");
                            fileDetailBean.setErrInfo(list.getLast() + " 第" + (i+1) + "行厂商重复，状态：厂商重复");
                            fileDetailBeans1.add(fileDetailBean);
                            continue;
                        }
                    }
                    if(CarUtil.checkTask(fileDetailBean.getTaskId(), fileDetailBean.getPhone(), fileDetailHandler)) {
                        fileDetailBean.setStatus("2");//任务重复
                        fileDetailBean.setErrInfo(list.getLast() + " 第" + (i+1) + "行错误，状态：任务重复");
                        fileDetailBeans1.add(fileDetailBean);
                        continue;
                    }
                    if(CarUtil.checkBigLib(fileDetailBean.getPhone(), fileDetailHandler)) {
                        fileDetailBean.setStatus("1");//大库重复
                        fileDetailBean.setErrInfo(list.getLast() + " 第" + (i+1) + "行错误，状态：大库重复");
                        fileDetailBeans1.add(fileDetailBean);
                        continue;
                    }
                    if(!fileDetailBean.getStatus().equals("5")) {//如果不是号段错误
                        fileDetailBean.setErrInfo(list.getLast() + " 第" + (i+1) + "行");
                        fileDetailBeans1.add(fileDetailBean);
                    }else {
                        fileDetailBeans1.add(fileDetailBean);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("有异常：" + e.getMessage());
        }
        return fileDetailBeans1;
    }

}
