package com.car.web.controller.car;

import com.car.web.utils.Constants;
import jodd.util.StringUtil;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import person.Thread.CheckPackageThread;
import person.db.bean.*;
import person.db.entity.Page;
import person.handler.FileDetailHandler;
import person.handler.FileHandler;
import person.handler.ShowHandler;
import person.handler.UserHandler;
import person.security.cache.CacheManager;
import person.util.*;
import person.util.webSocket.MyClient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Controller
public class CarListController {

    @Autowired
    FileHandler fileHandler;

    @Autowired
    FileDetailHandler fileDetailHandler;

    @Autowired
    UserHandler userHandler;

    @Autowired
    ShowHandler showHandler;

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
            System.err.println("纳入文件有误：" + e.getMessage());
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
        modelMap.put("userCode", UserUtil.getName());
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
        Page<TblFileBean> pageResult = fileHandler.queryByPageFilter(page,hql + where + " order by t.uploadDate desc", valueMap);
        //List<CarListBean> carListBeans = new ArrayList<CarListBean>();
        //if(null != pageResult.getResult() && !pageResult.getResult().isEmpty()) {
        //    for (TblFileBean fileBean : pageResult.getResult()) {
        //        CarListBean carListBean = new CarListBean();
        //        carListBean.setFileBean(fileBean);
        //        if(fileBean.getStatus().equals("0")) {
        //            carListBean.setFileCount("0");
        //            carListBean.setSumCount("0");
        //            carListBean.setProblemCount("0");
        //            carListBean.setTaskRepeatCount("0");
        //            carListBean.setCarSysRepeatCount("0");
        //            carListBean.setBigLibraryRepeatCount("0");
        //            carListBean.setBlackHitRepeatCount("0");
        //            carListBean.setNumberErrCount("0");
        //            carListBean.setIdFailedCount("0");
        //        }else {
        //            String fileId = fileBean.getId();
        //            carListBean.setFileCount(String.valueOf(fileDetailHandler.queryByHql("FROM TblFileDetail t where t.fileId = ? group by t.fileName", fileId).size()));
        //            carListBean.setSumCount(String.valueOf(fileDetailHandler.queryByHql("FROM TblFileDetail t where t.fileId = ?", fileId).size()));
        //            carListBean.setProblemCount(String.valueOf(fileDetailHandler.queryByHql("from TblFileDetail t where t.fileId = ? and t.status != ?", fileId, "0").size()));
        //            carListBean.setTaskRepeatCount(String.valueOf(fileDetailHandler.queryByHqlOnErrCount(fileId, "2").size()));
        //            carListBean.setCarSysRepeatCount(String.valueOf(fileDetailHandler.queryByHqlOnErrCount(fileId, "3").size()));
        //            carListBean.setBigLibraryRepeatCount(String.valueOf(fileDetailHandler.queryByHqlOnErrCount(fileId, "1").size()));
        //            carListBean.setBlackHitRepeatCount(String.valueOf(fileDetailHandler.queryByHqlOnErrCount(fileId, "4").size()));
        //            carListBean.setNumberErrCount(String.valueOf(fileDetailHandler.queryByHqlOnErrCount(fileId, "5").size()));
        //            carListBean.setIdFailedCount(String.valueOf(fileDetailHandler.queryByHqlOnErrCount(fileId, "6").size()));
        //        }
        //        carListBeans.add(carListBean);
        //    }
        //}
        JsonBean jsonBean = new JsonBean("0", "", String.valueOf(pageResult.getTotalCount()), pageResult.getResult());
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
     * 整理文件
     **/
    @RequestMapping(value = "/car/list/checkPackage", method = RequestMethod.POST)
    @ResponseBody
    public Object carListcheckPackage(String id) {
        try {
            List<String> blacks = TxtUtil.readTxtToList();//黑名单
            List<TblAreaBean> areaBeans = CacheManager.getInstance().getAreaAll();//地区码表
            List<TblCarSystemBean> carSystemBeans = CacheManager.getInstance().getCarSysAll();//车系码表
            TblFileBean fileBean = fileHandler.queryById(id);
            ZipUtil.unZip(fileBean.getFilePath(), fileBean.getFilePath() + "a" + File.separatorChar);//解压原包
            List<String> listStr = getFilePaths(new File(fileBean.getFilePath() + "a" + File.separatorChar));
            List<TblFileDetailBean> fileDetailBeans = new ArrayList<TblFileDetailBean>();
            /*创建可用线程数量的固定线程池*/
            ExecutorService exe =  Executors.newFixedThreadPool(10);
            //存储线程的返回值
            List<Future<List<TblFileDetailBean>>> results = new LinkedList<Future<List<TblFileDetailBean>>>();
            for (String s : listStr) {
                CheckPackageThread checkPackageThread = new CheckPackageThread(fileBean.getId(), fileDetailHandler, blacks, areaBeans, carSystemBeans, s, fileBean.getUploadDate(), userHandler, UserUtil.getUserId());
                Future<List<TblFileDetailBean>> result = exe.submit(checkPackageThread);
                results.add(result);
            }
            exe.shutdown();
            while (true) {
                if(exe.isTerminated()) {
                    System.out.println("=================== all thread end ======================");
                    break;
                }
                System.out.println("=================== wait......... ======================");
                Thread.sleep(500);
            }
            for (Future<List<TblFileDetailBean>> result : results) {
                if(result.get() != null && result.get().size() > 0) {
                    fileDetailBeans.addAll(result.get());
                }
            }
            if(fileDetailBeans!= null && !fileDetailBeans.isEmpty()) {
                for (TblFileDetailBean fileDetailBean : fileDetailBeans) {
                    for (TblFileDetailBean detailBean : fileDetailBeans) {
                        if (fileDetailBean.getId() != detailBean.getId()) {
                            if (fileDetailBean.getCarSys().equals(detailBean.getCarSys()) &&
                                    fileDetailBean.getPhone().equals(detailBean.getPhone())) {//车第重复
                                fileDetailBean.setStatus("3");
                                fileDetailBean.setErrInfo(fileDetailBean.getErrInfo() + "错误，状态：车系重复");
                                break;
                            }
                            if (fileDetailBean.getTaskId().equals(detailBean.getTaskId())) {
                                if (fileDetailBean.getPhone().equals(detailBean.getPhone())) {
                                    fileDetailBean.setStatus("2");
                                    fileDetailBean.setErrInfo(fileDetailBean.getErrInfo() + "错误，状态：任务重复");
                                    break;
                                }
                            }
                            if (fileDetailBean.getPhone().equals(detailBean.getPhone())) {//大库重复
                                fileDetailBean.setStatus("1");
                                fileDetailBean.setErrInfo(fileDetailBean.getErrInfo() + "错误，状态：大库重复");
                                break;
                            }
                        }
                    }
                }
                fileDetailHandler.batchSaveFileDetailBeansAndUpdateFileStatus(fileDetailBeans);
                FileUtils.deleteDirectory(new File(fileBean.getFilePath() + "a" + File.separatorChar));
                return JsonUtil.toString("Y", "操作成功！");
            }else {
                FileUtils.deleteDirectory(new File(fileBean.getFilePath() + "a" + File.separatorChar));
                return JsonUtil.toString("N", "未读取到相关数据！");
            }

        } catch (Exception e) {
            return JsonUtil.toString("N", "失败异常：" + e.getMessage());
        }
    }

    /**
     * 重新整理文件
     **/
    @RequestMapping(value = "/car/list/checkAgainPackage", method = RequestMethod.POST)
    @ResponseBody
    public Object carListCheckAgainPackage(String id) {
        TblFileBean fileBean = fileHandler.queryById(id);
        List<TblFileDetailBean> fileDetailBeans = fileDetailHandler.findByProperty("fileId", id);
        if(null != fileDetailBeans && fileDetailBeans.size() > 0) {
            fileDetailHandler.batchDel(fileDetailBeans);
        }
        return carListcheckPackage(id);
    }

    /**
     * @Author SunChang
     * @Date 2018/9/8 14:00
     * @param request
    * @param response
     * @Description 导出转id后的包
     */
    @RequestMapping(value = "/car/list/exportPackage", method = RequestMethod.GET)
    public Object carListExportPackage(HttpServletRequest request, HttpServletResponse response) {
        Constants.pubMap.put(UserUtil.getUserId() + "ExportPackage", false);//记录公共变量当前用户导出包是否成功
        TblFileBean fileBean = fileHandler.queryById(request.getParameter("id"));
        String dirPath = fileBean.getFilePath() + "a/";
        if(new File(dirPath).exists()) {
            try {
                FileUtils.deleteDirectory(new File(dirPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String arrs = request.getParameter("arrs");
        ZipUtil.unZip(fileBean.getFilePath(), dirPath);//解压原包
        renameFiles(new File(dirPath));//把原始文件重命名
        String hql = "FROM TblFileDetail t where t.fileId = ?";
        String where = " and t.status not in (";
        String where1 = "";
        if(StringUtil.isNotBlank(arrs) && arrs.length() > 1) {
            String[] arrs1 = arrs.split(",");
            for (int i = 0; i < arrs1.length; i++) {
                String s = arrs1[i];
                if(CarUtil.isInteger(s)) {
                    where1 += "'" + s + "',";
                }
            }
        }
        if(StringUtil.isNotBlank(where1)) {
            where1 = where1.substring(0, where1.length() - 1);
            hql = hql + where + where1 + ")";
        }
        List<String[]> dataList = new ArrayList<String[]>();
        //excel标题
        String [] title = {"姓名", "手机号", "城市ID", "车系ID", "车型ID", "经销商ID"};
        //先查分文件的数据
        List<TblFileDetailBean> fileDetailBeans = fileDetailHandler.queryByHql(hql + " group by t.fileName", fileBean.getId());
        for (TblFileDetailBean fileDetailBean : fileDetailBeans) {
            dataList.add(title);
            //查询单个文件的数据
            List<TblFileDetailBean> fileDetailBeans1 = fileDetailHandler.queryByHql(hql + " and t.fileName = ? order by (t.orderNum+0)", fileBean.getId(), fileDetailBean.getFileName());
            if(null != fileDetailBeans1 && !fileDetailBeans1.isEmpty()) {
                for (TblFileDetailBean tblFileDetailBean : fileDetailBeans1) {
                    String[] temps = {tblFileDetailBean.getName(),tblFileDetailBean.getPhone(),tblFileDetailBean.getArea(), tblFileDetailBean.getCarSys(), "", ""};
                    dataList.add(temps);
                }
                String outPath = newPath(dirPath);
                File file = new File(outPath);
                if(!file.exists()) {
                    file.mkdirs();
                }
                outPath += "ID-" + fileDetailBean.getFileName();
                try {
                    ExcelUtil.write(outPath, dataList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dataList.clear();
            }
        }
        //错误的数据
        List<TblFileDetailBean> errFilDetailBean = fileDetailHandler.queryByHql("FROM TblFileDetail t where t.fileId = ? and t.status != ? order by t.fileName, (t.orderNum+0)", fileBean.getId(), "0");
        String errInfo = "";
        if(null != errFilDetailBean) {
            for (TblFileDetailBean fileDetailBean : errFilDetailBean) {
                errInfo += fileDetailBean.getErrInfo() + "\n";
            }
            try {
                TxtUtil.writeTxt(errInfo, dirPath + "报错文件.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        UpOrDownloadUtil up = new UpOrDownloadUtil();
        String[] zipNames = fileBean.getFileNameBak().split("\\.");
        String zipName = zipNames[0] + "-ok." + zipNames[1];
        File file = new File(dirPath);
        File[] files = file.listFiles();
        try {
            String targetPath = Constants.getRootPath() + "bak/";
            File targetZip = new File(targetPath + zipName);
            FileOutputStream fos1 = new FileOutputStream(targetZip);
            ZipUtil.zipFiles(fos1, "", files);
            up.downLoadCarZip(targetZip, request, response, true);
            FileUtils.deleteDirectory(new File(dirPath));
        //    FileUtils.deleteQuietly(targetZip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Constants.pubMap.put(UserUtil.getUserId() + "ExportPackage", true);
        return JsonUtil.toString("Y", "操作成功！");
    }

    /**
     * @Author SunChang
     * @Date 2018/9/8 14:00
     * @param request
    * @param response
     * @Description 获得下载转id包的结果做前台用户体验
     */
    @RequestMapping(value = "/car/list/exportPackageRes", method = RequestMethod.GET)
    @ResponseBody
    public Object getCarListExportPackageRes(HttpServletRequest request, HttpServletResponse response) {
        boolean res = (boolean) Constants.pubMap.get(UserUtil.getUserId() + "ExportPackage");
        if(res) {
            Constants.pubMap.remove(UserUtil.getUserId() + "ExportPackage");
            return JsonUtil.toString("Y", "操作成功！");
        }else {
            return JsonUtil.toString("N", "无结果");
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
     * @Date 2018/9/7 14:16
     * @param file
     * @Description 重命名文件
     */
    public void renameFiles(File file) {
        File[] fs = file.listFiles();
        for (File f : fs) {
            if(f.isDirectory()) {
                renameFiles(f);
            }
            if(f.isFile()) {
                String filePath = f.getPath();
                FileUtil.renameFile(filePath.substring(0, filePath.lastIndexOf(File.separatorChar) + 1), f.getName(), "原-" + f.getName());
            }
        }
    }

    /**
     * @Author SunChang
     * @Date 2018/9/7 15:31
     * @param path
     * @Description 获取新包的路径
     */
    public static String newPath(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        String p = "";
        for (File file1 : files) {
            if(file1.isDirectory()) {
                p = file1.getPath();
                break;
            }
        }
        if(p.lastIndexOf("/") != -1) {
            String p1 = p.substring(p.lastIndexOf("/") + 1, p.length());
            String[] p1s = p1.split("-");
            String p2 = "/ID-" + p1s[1];
            p2 = p.substring(0, p.lastIndexOf("/")) + p2 + "/";
            return p2;
        }else {
            return path;
        }
        //String[] ps = p.split("\\\\");
        //if(null != ps && ps.length > 1) {
        //    String ret = "";
        //    ps[ps.length - 1] = "ID" + ps[ps.length - 1].substring(2, ps[ps.length - 1].length());
        //    for (int i = 0; i < ps.length; i++) {
        //        ret += ps[i] + File.separatorChar;
        //    }
        //    return ret;
        //}else {
        //    return path;
        //}
    }

    /**
     * @Author SunChang
     * @Date 2018/9/10 15:13
     * @param request
    * @param modelMap
     * @Description 错误信息查看
     */
    @RequestMapping(value = "/car/list/errInfo", method = RequestMethod.GET)
    public String carerrInfoGet(HttpServletRequest request, ModelMap modelMap) {
        modelMap.put("errCode", request.getParameter("err"));
        modelMap.put("fileId", request.getParameter("fileId"));
        return "/car/errInfo";
    }

    /**
     * @Author SunChang
     * @Date 2018/9/10 15:13
     * @param request
    * @param modelMap
     * @Description 错误信息查看
     */
    @RequestMapping(value = "/car/list/errInfo", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String carerrInfoPost(HttpServletRequest request, ModelMap modelMap) {
        String errCode = request.getParameter("errCode");
        String fileId = request.getParameter("fileId");

        if(StringUtil.isNotBlank(errCode)) {
            if(StringUtil.isBlank(errCode) || StringUtil.isBlank(fileId)) {
                JsonBean jsonBean = new JsonBean("0", "", "0", null);
                return JsonUtil.beanToJsonString(jsonBean);
            }
            String hql = "FROM TblFileDetail t where t.fileId = ? and t.status = ?";
            List<TblFileDetailBean> fileDetailBeans = fileDetailHandler.queryByHql(hql, fileId, errCode);
            CarUtil.updateCarSysAndAreaName(fileDetailBeans);
            JsonBean jsonBean = new JsonBean("0", "", String.valueOf(fileDetailBeans.size()), fileDetailBeans);
            return JsonUtil.beanToJsonString(jsonBean);
        }else {
            JsonBean jsonBean = new JsonBean("0", "", "0", null);
            return JsonUtil.beanToJsonString(jsonBean);
        }
    }

    /**
     * @Author SunChang
     * @Date 2018/9/10 15:13
     * @param request
    * @param modelMap
     * @Description 详情
     */
    @RequestMapping(value = "/car/list/info", method = RequestMethod.GET)
    public String carInfoGet(HttpServletRequest request, ModelMap modelMap) {
        modelMap.put("fileId", request.getParameter("fileId"));
        return "/car/info";
    }

    /**
     * @Author SunChang
     * @Date 2018/9/10 15:13
     * @param request
    * @param modelMap
     * @Description 详情
     */
    @RequestMapping(value = "/car/list/info", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String carInfoPost(HttpServletRequest request, ModelMap modelMap) {
        String fileId = request.getParameter("fileId");
        String arrs = request.getParameter("arrs");
        String where = arrs;
        if(StringUtil.isNotBlank(arrs)) {
            if(where.contains("history")) {
                where = arrs.replaceAll("history", "0");
            }else {
                where += ",'0'";
            }
            String hql = "FROM TblFileDetail t where t.fileId = ? and t.status in (" + where + ")";
            List<TblFileDetailBean> fileDetailBeans = fileDetailHandler.queryByHql(hql, fileId);
            LinkedList<TblFileDetailBean> linkedList = new LinkedList<TblFileDetailBean>();
            if (null != fileDetailBeans && fileDetailBeans.size() > 0) {
                for (TblFileDetailBean fileDetailBean : fileDetailBeans) {
                    if (fileDetailBean.getStatus().equals("1")) {//大库重复
                        fileDetailBean.setErrInfo("本包数据");
                        fileDetailBean.setColor("shenlan");
                        linkedList.add(fileDetailBean);
                        if(arrs.contains("history")) {
                            List<TblFileDetailBean> temps = fileDetailHandler.findByProperty("phone", fileDetailBean.getPhone());
                            for (TblFileDetailBean temp : temps) {
                                if(!temp.getFileId().equals(fileDetailBean.getFileId())) {
                                    temp.setStatus("1");
                                    temp.setErrInfo("历史数据");
                                    temp.setColor("qianlan");
                                    linkedList.add(temp);
                                }
                            }
                        }
                    }
                }
                for (TblFileDetailBean fileDetailBean : fileDetailBeans) {
                    if (fileDetailBean.getStatus().equals("2")) {//任务重复
                        fileDetailBean.setErrInfo("任务重复");
                        fileDetailBean.setColor("hong");
                        linkedList.add(fileDetailBean);
                    }
                }
                for (TblFileDetailBean fileDetailBean : fileDetailBeans) {
                    if(fileDetailBean.getStatus().equals("3")) {//车系重复
                        fileDetailBean.setErrInfo("本包数据");
                        fileDetailBean.setColor("shenhuang");
                        linkedList.add(fileDetailBean);
                        if(arrs.contains("history")) {
                            List<TblFileDetailBean> temps = fileDetailHandler.findByProperty("carSys", fileDetailBean.getCarSys());
                            for (TblFileDetailBean temp : temps) {
                                if(!temp.getFileId().equals(fileDetailBean.getFileId()) && fileDetailBean.getPhone().equals(temp.getPhone())) {
                                    temp.setStatus("3");
                                    temp.setErrInfo("历史数据");
                                    temp.setColor("qianhuang");
                                    linkedList.add(temp);
                                }
                            }
                        }
                    }
                }
                for (TblFileDetailBean fileDetailBean : fileDetailBeans) {
                    if(fileDetailBean.getStatus().equals("5")) {//号段错误
                        fileDetailBean.setErrInfo("号段错误");
                        fileDetailBean.setColor("zise");
                        linkedList.add(fileDetailBean);
                    }
                }
                for (TblFileDetailBean fileDetailBean : fileDetailBeans) {
                    if(fileDetailBean.getStatus().equals("4")) {//黑名单命中
                        fileDetailBean.setErrInfo("黑名单命中");
                        fileDetailBean.setColor("heise");
                        linkedList.add(fileDetailBean);
                    }
                }
                for (TblFileDetailBean fileDetailBean : fileDetailBeans) {
                    if(fileDetailBean.getStatus().equals("6")) {//ID转失败
                        fileDetailBean.setErrInfo("ID转失败");
                        fileDetailBean.setColor("huise");
                        linkedList.add(fileDetailBean);
                    }
                }
                for (TblFileDetailBean fileDetailBean : fileDetailBeans) {
                    if(fileDetailBean.getStatus().equals("0")) {
                        fileDetailBean.setErrInfo("-");
                        linkedList.add(fileDetailBean);
                    }
                }
            }
            CarUtil.updateCarSysAndAreaName(linkedList);
            JsonBean jsonBean = new JsonBean("0", "", String.valueOf(linkedList.size()), linkedList);
            return JsonUtil.beanToJsonString(jsonBean);
        }else {
            String hql = "FROM TblFileDetail t where t.fileId = ? and t.status = ?";
            List<TblFileDetailBean> fileDetailBeans = fileDetailHandler.queryByHql(hql, fileId, "0");
            CarUtil.updateCarSysAndAreaName(fileDetailBeans);
            JsonBean jsonBean = new JsonBean("0", "", String.valueOf(fileDetailBeans.size()), fileDetailBeans);
            return JsonUtil.beanToJsonString(jsonBean);
        }
    }

    /**
     * @Author SunChang
     * @Date 2018/9/10 15:13
     * @param request
    * @param modelMap
     * @Description 时间范围内的包全部重新整理
     */
    @RequestMapping(value = "/car/list/checkAgain", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object carCheckAgainPost(HttpServletRequest request, ModelMap modelMap) throws IOException {
        String dateStr = request.getParameter("dateStr");
        String[] dates = dateStr.split(" ~ ");
        List<TblFileBean> fileBeans = fileHandler.queryByHql("FROM TblFile t where date_format(t.uploadDate, '%Y-%m-%d') BETWEEN ? and ?", dates[0], dates[1]);
        Constants.pubMap.put(UserUtil.getUserId() + "batchCheckAgain", true);
        boolean isContinue = (boolean) Constants.pubMap.get(UserUtil.getUserId() + "batchCheckAgain");
        MyClient client = new MyClient();
        //String uri = "ws://localhost:8080/websocket/houtai";
        String uri = "ws://101.200.63.2:8081/websocket/houtai";
        client.start(uri);
        if(null != fileBeans && fileBeans.size() > 0) {
            for (int i = 0; i < fileBeans.size(); i++) {
                isContinue = (boolean) Constants.pubMap.get(UserUtil.getUserId() + "batchCheckAgain");
                if (isContinue) {
                    try {
                        carListCheckAgainPackage(fileBeans.get(i).getId());
                        JSONObject jo = new JSONObject();
                        jo.put("message", Math.round(((double) (i + 1) / fileBeans.size()) * 100) + "%");
                        //jo.put("message", i + "/50");
                        jo.put("To", UserUtil.getName());
                        client.sendMessage(jo.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
            client.closeSocket();
        }else {
            client.closeSocket();
            return JsonUtil.toString("Y", "当前时间范围内暂无数据！");
        }
        if(isContinue) {
            return JsonUtil.toString("Y", "重新整理完成！");
        }else {
            return JsonUtil.toString("Y", "取消成功！");
        }
    }

    /**
     * @Author SunChang
     * @Date 2018/9/8 14:00
     * @param request
    * @param response
     * @Description 取消批量重新整理
     */
    @RequestMapping(value = "/car/list/checkAgain/cancel", method = RequestMethod.GET)
    @ResponseBody
    public Object carCheckAgainGetCancel(HttpServletRequest request, HttpServletResponse response) {
        Constants.pubMap.put(UserUtil.getUserId() + "batchCheckAgain", false);
        return JsonUtil.toString("Y", "操作成功！");
    }

    /**
     * @Author SunChang
     * @Date 2018/11/30 13:19
     * @param files
    * @param request
    * @param response
     * @Description 给展示页面插数据
     */
    @RequestMapping(value = "/car/list/insert", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object excelInsert(@RequestParam("file") MultipartFile[] files, HttpServletRequest request, HttpServletResponse response) {
        JsonBean jsonBean = null;
        boolean flag = true;
        String ex = "";
        for (MultipartFile file : files) {
            try {
                String fileName = file.getOriginalFilename();
                String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
                List<TblShowBean> tblShowBeans = ExcelUtil.readStream(file.getInputStream(), fileType);
                showHandler.deleteAll();
                showHandler.batchAdd(tblShowBeans);
                flag = true;
            } catch (IOException e) {
                flag = false;
                ex = e.getMessage();
                e.printStackTrace();
            }
        }
        if(flag) {
            jsonBean = new JsonBean("0", "", "0", null);
        }else  {
            jsonBean = new JsonBean("-1", ex, "0", null);
        }
        return JsonUtil.beanToJsonString(jsonBean);
    }

    /**
     * @Author SunChang
     * @Date 2018/11/30 13:45
     * @param page
    * @param request
    * @param map
     * @Description excel入库数据列表查询
     */
    @RequestMapping(value = "/car/list/insert/list", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object excelListPost(Page<TblShowBean> page, HttpServletRequest request, ModelMap map) {
        String pageNo = request.getParameter("page");//page是当前页码
        String limit = request.getParameter("limit");//limit是每页数据量
        String hql = "SELECT t FROM TblShow t";
        page.setPageNo(Integer.parseInt(pageNo));
        page.setPageSize(Integer.parseInt(limit));
        Page<TblShowBean> pageResult = showHandler.queryByPageFilter(page,hql, null);
        JsonBean jsonBean = new JsonBean("0", "", String.valueOf(pageResult.getTotalCount()), pageResult.getResult());
        return JsonUtil.beanToJsonString(jsonBean);
    }

    public static void main(String[] args) {
        String path = "/usr/local/uploader/bak/7848520180918132617325a/原标-浔阳0822";
        //String path2 = path.substring(0, path.lastIndexOf("/"));
        //path2 += path.substring(path.lastIndexOf("/"), path.length());
        String path2 = path.substring(path.lastIndexOf("/") + 1, path.length());
        String[] temps = path2.split("-");
        String a = "/ID-" + temps[1];
        a = path.substring(0, path.lastIndexOf("/")) + a;
        System.out.println(a);
    }

}
