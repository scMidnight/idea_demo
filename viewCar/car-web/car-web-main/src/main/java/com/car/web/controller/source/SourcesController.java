package com.car.web.controller.source;

import jodd.util.StringUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import person.db.bean.JsonBean;
import person.db.bean.SourcesBean;
import person.db.entity.Page;
import person.handler.SourcesHandler;
import person.util.IdUtils;
import person.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/car/sources")
public class SourcesController {
    @Autowired
    SourcesHandler sourcesHandler;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listGet(HttpServletRequest request, ModelMap modelMap) {
        return "/source/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object listPost(Page<SourcesBean> page, HttpServletRequest request, ModelMap map) {
        String pageNo = request.getParameter("page");//page是当前页码
        String limit = request.getParameter("limit");//limit是每页数据量
        String hql = "SELECT t FROM Sources t WHERE t.isDel = '0' ";
        Map<String,Object> valueMap = new HashMap<String, Object>();
        String where = "";
        String orderBy = " order by t.insertDate desc";
        page.setPageNo(Integer.parseInt(pageNo));
        page.setPageSize(Integer.parseInt(limit));
        Page<SourcesBean> pageResult = sourcesHandler.queryByPageFilter(page,hql + where + orderBy, valueMap);
        JsonBean jsonBean = new JsonBean("0", "", String.valueOf(pageResult.getTotalCount()), pageResult.getResult());
        return JsonUtil.beanToJsonString(jsonBean);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addGet(HttpServletRequest request, ModelMap map) throws Exception {
        //UserUtil - 获取当前登录用户的工具类
        map.put("type", request.getParameter("type"));
        String id = request.getParameter("id");
        if(StringUtil.isNotBlank(id)) {
            map.put("id", id);
            map.put("sourceTag", sourcesHandler.getBean(id).getSourceTag());
        }
        return "/source/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object addPost(@RequestBody JSONObject data, HttpServletRequest request) throws Exception {
        //UserUtil - 获取当前登录用户的工具类
        String type = data.getString("type");
        String sourceTag = data.getString("sourceTag");
        String id = data.getString("id");
        try {
            if(type.equals("add")) {
                SourcesBean sourcesBean = new SourcesBean();
                sourcesBean.setId(IdUtils.randomString());
                sourcesBean.setIsDel("0");
                sourcesBean.setInsertDate(new Date());
                sourcesBean.setSourceTag(sourceTag);
                sourcesHandler.addSource(sourcesBean);
                return JsonUtil.toString("Y", "保存成功！");
            }else {
                SourcesBean sourcesBean = sourcesHandler.getBean(id);
                sourcesBean.setSourceTag(sourceTag);
                sourcesHandler.addSource(sourcesBean);
                return JsonUtil.toString("Y", "修改成功！");
            }
        } catch (Exception e) {
            return JsonUtil.toString("N", "失败异常：" + e.getMessage());
        }
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public Object delPost(String id) {
        try {
            sourcesHandler.removeSource(id);
            return JsonUtil.toString("Y", "操作成功！");
        } catch (Exception e) {
            return JsonUtil.toString("N", "失败异常：" + e.getMessage());
        }
    }
}
