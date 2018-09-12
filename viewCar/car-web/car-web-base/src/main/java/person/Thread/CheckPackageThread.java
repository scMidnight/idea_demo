package person.Thread;

import jodd.util.StringUtil;
import person.db.bean.TblAreaBean;
import person.db.bean.TblCarSystemBean;
import person.db.bean.TblFileDetailBean;
import person.handler.FileDetailHandler;
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

    public CheckPackageThread(String fileId, FileDetailHandler fileDetailHandler, List<String> blacks, List<TblAreaBean> areaBeans, List<TblCarSystemBean> carSystemBeans, String excelPath, Date uploadDate) {
        this.fileId = fileId;
        this.fileDetailHandler = fileDetailHandler;
        this.blacks = blacks;
        this.areaBeans = areaBeans;
        this.carSystemBeans = carSystemBeans;
        this.excelPath = excelPath;
        this.uploadDate = uploadDate;
    }

    @Override
    public List<TblFileDetailBean> call() throws Exception {
        List<TblFileDetailBean> fileDetailBeans1 = new ArrayList<TblFileDetailBean>();
        try {
            LinkedList<String> list = ExcelUtil.read(excelPath);
            for (int i = 0; i < list.size()-1; i++) {
                if(i != 0) {
                    String[] vals = list.get(i).split("\t");
                    TblFileDetailBean fileDetailBean = CarUtil.getFileDetailBean(vals);
                    fileDetailBean.setFileName(list.getLast());
                    fileDetailBean.setFileId(fileId);
                    fileDetailBean.setUploadDate(uploadDate);
                    if (StringUtil.isBlank(vals[0])
                            || StringUtil.isBlank(vals[1])
                            || StringUtil.isBlank(vals[2])
                            || StringUtil.isBlank(vals[3])
                            || StringUtil.isBlank(vals[6])) {
                        fileDetailBean.setStatus("6");
                        fileDetailBean.setErrInfo(list.getLast() + " 第" + (i+1) + "行错误，状态：ID转失败");
                        fileDetailBeans1.add(fileDetailBean);
                        continue;
                    }
                    String mobileFrom = MobileFromUtil.getMobileFrom(vals[1]);//得到归属地
                    String cityId = CarUtil.checkCityId(areaBeans, vals[2], mobileFrom);//判断城市ID
                    if (StringUtil.isNotBlank(cityId)) {
                        fileDetailBean.setArea(cityId);
                    }else {
                        fileDetailBean.setStatus("5");//号段错误
                        fileDetailBean.setErrInfo(list.getLast() + " 第" + (i+1) + "行错误，状态：号段错误，文件中是" + vals[2] + "，根据号码查询后为：" + mobileFrom);
                        fileDetailBeans1.add(fileDetailBean);
                        continue;
                    }
                    if(CarUtil.isBlack(blacks, fileDetailBean.getPhone())) {
                        fileDetailBean.setStatus("4");//黑名单命中
                        fileDetailBean.setErrInfo(list.getLast() + " 第" + (i+1) + "行错误，状态：黑名单命中");
                        fileDetailBeans1.add(fileDetailBean);
                        continue;
                    }
                    String carSysId = CarUtil.getCarSysId(carSystemBeans, vals[3]);
                    fileDetailBean.setCarSys(carSysId);
                    if(CarUtil.checkCarSys(carSysId, fileDetailBean.getPhone(), fileDetailHandler)) {
                        fileDetailBean.setStatus("3");//车系重复
                        fileDetailBean.setErrInfo(list.getLast() + " 第" + (i+1) + "行错误，状态：车系重复");
                        fileDetailBeans1.add(fileDetailBean);
                        continue;
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
                        continue;
                    }
                    fileDetailBean.setErrInfo(list.getLast() + " 第" + (i+1) + "行");
                    fileDetailBeans1.add(fileDetailBean);
                }
            }
        } catch (IOException e) {
            System.out.println("有异常：" + e.getMessage());
        }
        return fileDetailBeans1;
    }

}
