package com.car.web.controller.onLine;

import com.google.gson.Gson;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import person.db.bean.JsonBean;
import person.db.bean.TblAdProManageBean;
import person.db.bean.TblCarSystemBean;
import person.db.entity.Page;
import person.handler.AdProManHandler;
import person.security.cache.TblCarSysCache;
import person.util.ExcelUtil;
import person.util.IdUtils;
import person.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
线上广告管理--广告项目管理
 */
@Controller
@RequestMapping(value = "/adProManage")
public class AdProManageController {

    @Autowired
    AdProManHandler adProManHandler;

    /**
     * @Author SunChang
     * @Date 2018/8/30 16:21
     * @param request
    * @param modelMap
     * @Description 广告项目管理
     */
    @RequestMapping(method = RequestMethod.GET)
    public String adProManageGet(HttpServletRequest request, ModelMap modelMap) {
        return "/onLine/adProManage/list";
    }

    /**
     * @Author SunChang
     * @Date 2018/11/30 13:45
     * @param page
    * @param request
    * @param map
     * @Description 广告项目管理
     */
    @RequestMapping(method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object adProManagePost(Page<TblAdProManageBean> page, HttpServletRequest request, ModelMap map) {
        Map<String, Object> maps = new HashMap<>();
        String hql = "SELECT t FROM TblAdProManage t";
        String where = " WHERE 1 = 1";
        String pageNo = request.getParameter("page");//page是当前页码
        String limit = request.getParameter("limit");//limit是每页数据量
        String proName = request.getParameter("proName");
        String status = request.getParameter("status");
        String carSysType = request.getParameter("carSysType");
        String field = request.getParameter("field");
        String order = request.getParameter("order");
        if(StringUtil.isNotBlank(proName)) {
            maps.put("proName", "%" + proName + "%");
            where += " AND t.proName like :proName";
        }
        if(StringUtil.isNotBlank(status)) {
            maps.put("status", status);
            where += " AND t.status = :status";
        }
        if(StringUtil.isNotBlank(carSysType)) {
            maps.put("carSysType", "%" + carSysType + "%");
            where += " AND t.carSysName like :carSysType";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        page.setPageSize(Integer.parseInt(limit));
        String orderBy = " order by t.insertDate desc";
        if(StringUtil.isNotBlank(field) && StringUtil.isNotBlank(order)) {
            orderBy = " order by t." + field + " " + order;
        }
        Page<TblAdProManageBean> pageResult = null;
        String errMsg = "";
        try {
            pageResult = adProManHandler.queryByPageFilter(page,hql + where + orderBy, maps);
        } catch (Exception e) {
            errMsg = e.getMessage();
            e.printStackTrace();
        }
        JsonBean jsonBean = new JsonBean("0", errMsg, String.valueOf(pageResult.getTotalCount()), pageResult.getResult());
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
                List<TblAdProManageBean> adProManageBeans = null;
                adProManageBeans = ExcelUtil.readStreamAdProManage(file.getInputStream(), fileType);
                adProManHandler.deleteAll();
                adProManHandler.batchAdd(adProManageBeans);
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

    /**
     * 列表信息删除
     **/
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public Object del(String id) {
        try {
            adProManHandler.deleteWhere("id", id);
            return JsonUtil.toString("Y", "操作成功！");
        } catch (Exception e) {
            return JsonUtil.toString("N", "失败异常：" + e.getMessage());
        }
    }
    /**
     * 列表信息暂停
     **/
    @RequestMapping(value = "/stop", method = RequestMethod.POST)
    @ResponseBody
    public Object stop(String id) {
        try {
            TblAdProManageBean adProManageBean = adProManHandler.queryById(id);
            adProManageBean.setStatus("1");
            adProManHandler.updateAdProMan(adProManageBean);
            return JsonUtil.toString("Y", "操作成功！");
        } catch (Exception e) {
            return JsonUtil.toString("N", "失败异常：" + e.getMessage());
        }
    }
    /**
     * 列表信息开启
     **/
    @RequestMapping(value = "/open", method = RequestMethod.POST)
    @ResponseBody
    public Object open(String id) {
        try {
            TblAdProManageBean adProManageBean = adProManHandler.queryById(id);
            adProManageBean.setStatus("0");
            adProManHandler.updateAdProMan(adProManageBean);
            return JsonUtil.toString("Y", "操作成功！");
        } catch (Exception e) {
            return JsonUtil.toString("N", "失败异常：" + e.getMessage());
        }
    }

    /**
     * @Author SunChang
     * @Date 2018/8/28 18:58
     * @param obj
    * @param map
     * @Description 修改信息
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Object edit(String obj) {
        Gson gson = new Gson();
        TblAdProManageBean adProManageBean = gson.fromJson(obj, TblAdProManageBean.class);
        System.out.println(adProManageBean);
        try {
            adProManHandler.updateAdProMan(adProManageBean);
            return JsonUtil.toString("Y", "操作成功！");
        } catch (Exception e) {
            return JsonUtil.toString("N", "失败异常：" + e.getMessage());
        }
    }
}
