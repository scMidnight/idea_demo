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
import person.db.bean.JsonBean;
import person.db.bean.TblFileBean;
import person.handler.FileHandler;
import person.util.JsonUtil;
import person.util.UpOrDownloadUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
}
