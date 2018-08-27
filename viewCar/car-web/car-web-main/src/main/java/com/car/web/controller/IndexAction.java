package com.car.web.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
        String hql = "SELECT t FROM TblCarSystem t WHERE t.isDel = '0' ";
        Map<String,Object> valueMap = new HashMap<String, Object>();
        String where = "";
        page.setPageNo(Integer.parseInt(pageNo));
        page.setPageSize(Integer.parseInt(limit));
        Page<TblCarSystemBean> pageResult = carSystemHandler.queryByPageFilter(page,hql + where, valueMap);
        TableJsonBean tableJsonBean = new TableJsonBean("0", "", String.valueOf(pageResult.getTotalCount()), pageResult.getResult());
        //String parent = "{\"code\" : 0,\"msg\":\"\",\"count\":1,\"data\":";
        //String data = "[{\"id\": \"10001\",\"username\": \"杜甫\",\"email\": \"xianxin@layui.com\",\"sex\": \"男\",\"city\": \"浙江杭州\",\"sign\": \"人生恰似一场修行\",\"experience\": \"116\",\"ip\": \"192.168.0.8\",\"logins\": \"108\",\"joinTime\": \"2016-10-14\"},{\"id\": \"10002\",\"username\": \"李白\",\"email\": \"xianxin@layui.com\",\"sex\": \"男\",\"city\": \"浙江杭州\",\"sign\": \"人生恰似一场修行\",\"experience\": \"12\",\"ip\": \"192.168.0.8\",\"logins\": \"106\",\"joinTime\": \"2016-10-14\",\"LAY_CHECKED\": true},{\"id\": \"10003\",\"username\": \"王勃\",\"email\": \"xianxin@layui.com\",\"sex\": \"男\",\"city\": \"浙江杭州\",\"sign\": \"人生恰似一场修行\",\"experience\": \"65\",\"ip\": \"192.168.0.8\",\"logins\": \"106\",\"joinTime\": \"2016-10-14\" }, {\"id\": \"10004\",\"username\": \"贤心\",\"email\": \"xianxin@layui.com\",\"sex\": \"男\",\"city\": \"浙江杭州\",\"sign\": \"人生恰似一场修行\",\"experience\": \"666\",\"ip\": \"192.168.0.8\",\"logins\": \"106\",\"joinTime\": \"2016-10-14\"}, {\"id\": \"10005\",\"username\": \"贤心\",\"email\": \"xianxin@layui.com\",\"sex\": \"男\",\"city\": \"浙江杭州\",\"sign\": \"人生恰似一场修行\",\"experience\": \"86\",\"ip\": \"192.168.0.8\",\"logins\": \"106\",\"joinTime\": \"2016-10-14\" }, {\"id\": \"10006\",\"username\": \"贤心\",\"email\": \"xianxin@layui.com\",\"sex\": \"男\",\"city\": \"浙江杭州\",\"sign\": \"人生恰似一场修行\",\"experience\": \"12\",\"ip\": \"192.168.0.8\",\"logins\": \"106\",\"joinTime\": \"2016-10-14\"}, {\"id\": \"10007\",\"username\": \"贤心\",\"email\": \"xianxin@layui.com\",\"sex\": \"男\",\"city\": \"浙江杭州\",\"sign\": \"人生恰似一场修行\",\"experience\": \"16\",\"ip\": \"192.168.0.8\",\"logins\": \"106\",\"joinTime\": \"2016-10-14\"}, {\"id\": \"10008\",\"username\": \"贤心\",\"email\": \"xianxin@layui.com\",\"sex\": \"男\",\"city\": \"浙江杭州\",\"sign\": \"人生恰似一场修行\",\"experience\": \"106\",\"ip\": \"192.168.0.8\",\"logins\": \"106\",\"joinTime\": \"2016-10-14\"}]}";
        //String end = parent + data;
        //JsonObject obj = new JsonParser().parse(end).getAsJsonObject();
        //return obj.toString();
        return JsonUtil.beanToJsonString(tableJsonBean);
    }
}