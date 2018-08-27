package com.car.web.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import person.db.bean.TableJsonBean;
import person.db.bean.TblCarSystemBean;
import person.db.entity.Page;
import person.handler.CarSystemHandler;
import person.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SunChang on 2018/8/25
 */
@Controller
public class IndexAction {

    @Autowired
    CarSystemHandler carSystemHandler;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, ModelMap modelMap) {
        return "/index";
    }

    @RequestMapping(value = "/data", produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object list(Page<TblCarSystemBean> page, HttpServletRequest request, ModelMap map) {
        String pageNo = request.getParameter("page");//page是当前页码
        String limit = request.getParameter("limit");//limit是每页数据量
        String key = request.getParameter("key");//得到前台选中的值
        String hql = "SELECT t FROM TblCarSystem t WHERE t.isDel = '0' ";
        Map<String,Object> valueMap = new HashMap<String, Object>();
        String where = "";
        if(StringUtil.isNotBlank(key)) {
            String val = request.getParameter("selectedVal");
            where = " AND t." + key + " like '%" + val + "%'";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        page.setPageSize(Integer.parseInt(limit));
        Page<TblCarSystemBean> pageResult = carSystemHandler.queryByPageFilter(page,hql + where, valueMap);
        TableJsonBean tableJsonBean = new TableJsonBean("0", "", String.valueOf(pageResult.getTotalCount()), pageResult.getResult());
        return JsonUtil.beanToJsonString(tableJsonBean);
    }
}