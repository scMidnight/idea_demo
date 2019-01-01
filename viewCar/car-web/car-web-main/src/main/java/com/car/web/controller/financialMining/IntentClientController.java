package com.car.web.controller.financialMining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import person.db.bean.JsonBean;
import person.db.bean.TblIntentClientBean;
import person.db.entity.Page;
import person.handler.IntentClientHandler;
import person.util.ExcelUtil;
import person.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
车金融潜客挖掘-意向客户采集
 */
@Controller
@RequestMapping(value = "/intentClient")
public class IntentClientController {
    @Autowired
    IntentClientHandler intentClientHandler;


    /**
     * @Author SunChang
     * @Date 2018/8/28 18:58
     * @param request
    * @param map
     * @Description 意向客户采集
     */
    @RequestMapping(method = RequestMethod.GET)
    public String intentClientGet(HttpServletRequest request, ModelMap map) throws Exception {
        //UserUtil - 获取当前登录用户的工具类
        return "/financialMining/intentClient/list";
    }
    /**
     * @Author SunChang
     * @Date 2018/11/30 13:45
     * @param page
    * @param request
    * @param map
     * @Description 线下流量/潜客分析
     */
    @RequestMapping(method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object intentClientPost(Page<TblIntentClientBean> page, HttpServletRequest request, ModelMap map) {
        Map<String, Object> maps = new HashMap<>();
        String pageNo = request.getParameter("page");//page是当前页码
        String limit = request.getParameter("limit");//limit是每页数据量
        String hql = "SELECT t FROM TblIntentClient t";
        page.setPageNo(Integer.parseInt(pageNo));
        page.setPageSize(Integer.parseInt(limit));
        Page<TblIntentClientBean> pageResult = intentClientHandler.queryByPageFilter(page,hql, maps);
        JsonBean jsonBean = new JsonBean("0", "", String.valueOf(pageResult.getTotalCount()), pageResult.getResult());
        return JsonUtil.beanToJsonString(jsonBean);
    }

    /**
     * @Author SunChang
     * @Date 2018/11/30 13:19
     * @param files
    * @param request
    * @param response
     * @Description 给展示页面插数据
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object excelInsert(@RequestParam("file") MultipartFile[] files, HttpServletRequest request, HttpServletResponse response) {
        JsonBean jsonBean = null;
        boolean flag = true;
        String ex = "";
        for (MultipartFile file : files) {
            try {
                String fileName = file.getOriginalFilename();
                String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
                List<TblIntentClientBean> intentClientBeans = null;
                intentClientBeans = ExcelUtil.readStreamIntentClient(file.getInputStream(), fileType);
                intentClientHandler.deleteAll();
                intentClientHandler.batchAdd(intentClientBeans);
                flag = true;
            } catch (Exception e) {
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
}
