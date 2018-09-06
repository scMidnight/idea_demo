package com.car.web.controller.car;

import com.car.web.utils.Constants;
import com.car.web.utils.TxtUtil;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import person.db.bean.*;
import person.db.entity.Page;
import person.handler.FileDetailHandler;
import person.handler.FileHandler;
import person.security.cache.CacheManager;
import person.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class CarListController {

    @Autowired
    FileHandler fileHandler;

    @Autowired
    FileDetailHandler fileDetailHandler;

    /**
     * @Author SunChang
     * @Date 2018/8/30 16:21
     * @param request
    * @param modelMap
     * @Description 上传文件
     */
    @RequestMapping(value = "/car/uploader", method = RequestMethod.GET)
    public String carUploaderGet(HttpServletRequest request, ModelMap modelMap) {
        return "/car/uploader";
    }

    /**
     * @Author SunChang
     * @Date 2018/8/30 16:21
     * @param request
    * @param modelMap
     * @Description 上传文件
     */
    @RequestMapping(value = "/car/uploader", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object carUploaderPost(@RequestParam("file") MultipartFile[] files, HttpServletRequest request, HttpServletResponse response) {
        String rootPath = Constants.getRootPath() + "bak/";
        UpOrDownloadUtil upUtil = new UpOrDownloadUtil();//上传附件工具类
        JsonBean jsonBean = null;
        try {
            List<TblFileBean> fileBeans = upUtil.uploadFile(files, request, rootPath);
            jsonBean = new JsonBean("0", "", "0", null);
            fileHandler.batchAddAttachment(fileBeans);
        } catch (Exception e) {
            jsonBean = new JsonBean("-1", e.getMessage(), "0", null);
            System.err.println("上传文件有误：" + e.getMessage());
        }
        return JsonUtil.beanToJsonString(jsonBean);
    }

    /**
     * @Author SunChang
     * @Date 2018/8/30 16:21
     * @param request
    * @param modelMap
     * @Description 文件列表
     */
    @RequestMapping(value = "/car/list", method = RequestMethod.GET)
    public String carListGet(HttpServletRequest request, ModelMap modelMap) {
        return "/car/list";
    }

    /**
     * @Author SunChang
     * @Date 2018/8/30 16:21
     * @param request
    * @param modelMap
     * @Description 文件列表
     */
    @RequestMapping(value = "/car/list", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String carListPost(Page<TblFileBean> page, HttpServletRequest request) {
        String pageNo = request.getParameter("page");//page是当前页码
        String limit = request.getParameter("limit");//limit是每页数据量
        String hql = "SELECT t FROM TblFile t WHERE 1 = 1";
        Map<String,Object> valueMap = new HashMap<String, Object>();
        String where = "";
        page.setPageNo(Integer.parseInt(pageNo));
        page.setPageSize(Integer.parseInt(limit));
        Page<TblFileBean> pageResult = fileHandler.queryByPageFilter(page,hql + where, valueMap);
        List<CarListBean> carListBeans = new ArrayList<CarListBean>();
        if(null != pageResult.getResult() && !pageResult.getResult().isEmpty()) {
            for (TblFileBean fileBean : pageResult.getResult()) {
                CarListBean carListBean = new CarListBean();
                if(fileBean.getStatus().equals("0")) {
                    carListBean.setFileBean(fileBean);
                    carListBean.setFileCount("0");
                    carListBean.setSumCount("0");
                    carListBean.setProblemCount("0");
                    carListBean.setTaskRepeatCount("0");
                    carListBean.setCarSysRepeatCount("0");
                    carListBean.setBigLibraryRepeatCount("0");
                    carListBean.setBlackHitRepeatCount("0");
                    carListBean.setNumberErrCount("0");
                    carListBean.setIdFailedCount("0");
                }else {

                }
                carListBeans.add(carListBean);
            }
        }
        JsonBean jsonBean = new JsonBean("0", "", String.valueOf(pageResult.getTotalCount()), carListBeans);
        return JsonUtil.beanToJsonString(jsonBean);
    }

    /**
     * 列表信息删除
     **/
    @RequestMapping(value = "/car/list/del", method = RequestMethod.POST)
    @ResponseBody
    public Object carListDel(String id) {
        try {
            TblFileBean fileBean = fileHandler.queryById(id);
            FileUtil.delFile(fileBean.getFilePath());
            fileDetailHandler.deleteAllAndFile("fileId", id);
            return JsonUtil.toString("Y", "操作成功！");
        } catch (Exception e) {
            return JsonUtil.toString("N", "失败异常：" + e.getMessage());
        }
    }

    /**
     * 列表信息删除
     **/
    @RequestMapping(value = "/car/list/checkPackage", method = RequestMethod.POST)
    @ResponseBody
    public Object carListcheckPackage(String id) {
        try {
            List<String> blacks = TxtUtil.readTxtToList();//黑名单
            List<TblAreaBean> areaBeans = CacheManager.getInstance().getAreaAll();//地区码表
            List<TblCarSystemBean> carSystemBeans = CacheManager.getInstance().getCarSysAll();//车系码表
            TblFileBean fileBean = fileHandler.queryById(id);
            ZipUtil.unZip(fileBean.getFilePath(), fileBean.getFilePath() + "a" + File.separatorChar);
            List<String> listStr = getFilePaths(new File(fileBean.getFilePath() + "a" + File.separatorChar));
            List<TblFileDetailBean> fileDetailBeans = new ArrayList<TblFileDetailBean>();
            for (String s : listStr) {//循环文件
                LinkedList<String> list = ExcelUtil.read(s);
                for (int i = 0; i < list.size()-1; i++) {
                    if(i >= 1) {
                        String[] vals = list.get(i).split("\t");
                        TblFileDetailBean fileDetailBean = getFileDetailBean(vals);
                        fileDetailBean.setFileName(list.getLast());
                        if (StringUtil.isBlank(vals[0])
                                || StringUtil.isBlank(vals[1])
                                || StringUtil.isBlank(vals[2])
                                || StringUtil.isBlank(vals[3])
                                || StringUtil.isBlank(vals[6])) {
                            fileDetailBean.setStatus("6");
                            fileDetailBean.setErrInfo(list.getLast() + " 第" + (i+1) + "行错误，状态：ID转失败");
                            fileDetailBeans.add(fileDetailBean);
                            continue;
                        }
                        String mobileFrom = MobileFromUtil.getMobileFrom(vals[1]);//得到归属地
                        String cityId = checkCityId(areaBeans, vals[2], mobileFrom);//判断城市ID
                        if (StringUtil.isNotBlank(cityId)) {
                            fileDetailBean.setArea(cityId);
                        }else {
                            fileDetailBean.setStatus("5");//号段错误
                            fileDetailBean.setErrInfo(list.getLast() + " 第" + (i+1) + "行错误，状态：号段错误，文件中是" + vals[2] + "，根据号码查询后为：" + mobileFrom);
                            fileDetailBeans.add(fileDetailBean);
                            continue;
                        }
                        if(isBlack(blacks, fileDetailBean.getPhone())) {
                            fileDetailBean.setStatus("4");//黑名单命中
                            fileDetailBean.setErrInfo(list.getLast() + " 第" + (i+1) + "行错误，状态：黑名单命中");
                            fileDetailBeans.add(fileDetailBean);
                            continue;
                        }
                        String carSysId = getCarSysId(carSystemBeans, vals[3]);
                        fileDetailBean.setCarSys(carSysId);
                        if(checkCarSys(carSysId, fileDetailBean.getPhone())) {
                            fileDetailBean.setStatus("3");//车系重复
                            fileDetailBean.setErrInfo(list.getLast() + " 第" + (i+1) + "行错误，状态：车系重复");
                            fileDetailBeans.add(fileDetailBean);
                            continue;
                        }
                        if(checkTask(fileDetailBean.getTaskId(), fileDetailBean.getPhone())) {
                            fileDetailBean.setStatus("2");//任务重复
                            fileDetailBean.setErrInfo(list.getLast() + " 第" + (i+1) + "行错误，状态：任务重复");
                            fileDetailBeans.add(fileDetailBean);
                            continue;
                        }
                        if(checkBigLib(fileDetailBean.getPhone())) {
                            fileDetailBean.setStatus("1");//大库重复
                            fileDetailBeans.add(fileDetailBean);
                        }
                    }
                }
            }
            System.out.println(fileDetailBeans);
            return JsonUtil.toString("Y", "操作成功！");
        } catch (Exception e) {
            return JsonUtil.toString("N", "失败异常：" + e.getMessage());
        }
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 16:35
     * @param file
     * @Description 得到所有的excel
     */
    public List<String> getFilePaths(File file) {
        List<String> list = new ArrayList<String>();
        File[] fs = file.listFiles();
        for (File f : fs) {
            if(f.isDirectory()) {
                list = getFilePaths(f);
            }
            if(f.isFile()) {
                list.add(f.getPath());
            }
        }
        return list;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 18:57
     * @param strs
     * @Description 对filedetailBean赋初值
     */
    public TblFileDetailBean getFileDetailBean(String[] strs) {
        TblFileDetailBean fileDetailBean = new TblFileDetailBean();
        fileDetailBean.setId(IdUtils.randomString());
        fileDetailBean.setName(strs[0]);
        fileDetailBean.setPhone(strs[1]);
        fileDetailBean.setArea(strs[2]);
        fileDetailBean.setCarSys(strs[3]);
        fileDetailBean.setTaskId(strs[6]);
        fileDetailBean.setStatus("0");
        return fileDetailBean;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 19:52
     * @param areaBeans
    * @param cityName
    * @param mobileFrom
     * @Description 通过号码归属地与提供的城市名比对，得出城市ID
     */
    public String checkCityId(List<TblAreaBean> areaBeans, String cityName, String mobileFrom) {
        String id = "";
        for (TblAreaBean areaBean : areaBeans) {
            if(areaBean.getCityName().contains(cityName) && areaBean.getCityName().contains(mobileFrom)) {
                id = areaBean.getId();
                break;
            }
        }
        return id;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 20:08
     * @param blacks
    * @param phone
     * @Description 检测号码是否在黑名单中
     */
    public boolean isBlack(List<String> blacks, String phone) {
        boolean isBlack = false;
        for (String black : blacks) {
            if(black.equals(phone)) {
                isBlack = true;
                break;
            }
        }
        return isBlack;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 20:15
     * @param carSystemBeans
    * @param carSysName
     * @Description 根据车系名称获取车系ID
     */
    public String getCarSysId(List<TblCarSystemBean> carSystemBeans, String carSysName) {
        String carSysId = "";
        for (TblCarSystemBean carSystemBean : carSystemBeans) {
            if(carSystemBean.getCarSysName().contains(carSysName)) {
                carSysId = carSystemBean.getCarSysId();
                break;
            }
        }
        return carSysId;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 20:24
     * @param carSysId
    * @param taskId
     * @Description 检测库中相同车系数据中手机号也是相同 的数据为车系重复数据
     */
    public boolean checkCarSys(String carSysId, String phone) {
        boolean isCarSys = false;
        List<TblFileDetailBean> fileDetailBeans = fileDetailHandler.findByProperty("carSys", carSysId);
        for (TblFileDetailBean fileDetailBean : fileDetailBeans) {
            if(fileDetailBean.getPhone().equals(phone)) {
                isCarSys = true;
                break;
            }
        }
        return isCarSys;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 20:29
     * @param taskId
    * @param phone
     * @Description 检测库中相同任务ID号中重复的手机号数据
     */
    public boolean checkTask(String taskId, String phone) {
        boolean isTask = false;
        List<TblFileDetailBean> fileDetailBeans = fileDetailHandler.findByProperty("taskId", taskId);
        for (TblFileDetailBean fileDetailBean : fileDetailBeans) {
            if(fileDetailBean.getPhone().equals(phone)) {
                isTask = true;
                break;
            }
        }
        return isTask;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 20:38
     * @param phone
     * @Description 检测库中手机号重复的数据为大库重复
     */
    public boolean checkBigLib(String phone) {
        boolean isBigLib = false;
        List<TblFileDetailBean> fileDetailBeans = fileDetailHandler.findByProperty("phone", phone);
        if(null != fileDetailBeans && !fileDetailBeans.isEmpty()) {
            isBigLib = true;
        }
        return isBigLib;
    }
}
