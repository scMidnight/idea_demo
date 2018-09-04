package com.car.web.controller.car;

import com.car.web.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import person.db.bean.CarListBean;
import person.db.bean.JsonBean;
import person.db.bean.TblCarSystemBean;
import person.db.bean.TblFileBean;
import person.db.entity.Page;
import person.handler.FileHandler;
import person.util.JsonUtil;
import person.util.UpOrDownloadUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CarListController {

    @Autowired
    FileHandler fileHandler;

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
        if(!pageResult.getResult().isEmpty()) {
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
}
