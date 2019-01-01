package com.car.web.controller.offLine;

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
import person.handler.OfflineFilterHandler;
import person.util.ExcelUtil;
import person.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
线下潜客筛选-线下流量分析
 */
@Controller
@RequestMapping(value="/offLine")
public class OffLineController {

    @Autowired
    OfflineFilterHandler offlineFilterHandler;

    /**
     * @Author SunChang
     * @Date 2018/8/30 16:21
     * @param request
    * @param modelMap
     * @Description 线下流量/潜客分析
     */
    @RequestMapping(method = RequestMethod.GET)
    public String offClientGet(HttpServletRequest request, ModelMap modelMap) {
        return "/offLine/offClientAnalysis/list";
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
    public Object adProManagePost(Page<TblOfflineFilterBean> page, HttpServletRequest request, ModelMap map) {
        Map<String, Object> maps = new HashMap<>();
        String pageNo = request.getParameter("page");//page是当前页码
        String limit = request.getParameter("limit");//limit是每页数据量
        String dateStr = request.getParameter("dateStr");
        String dateType = request.getParameter("dateType");
        String[] dates = null;
        String where = " WHERE 1=1";
        if(StringUtil.isNotBlank(dateStr)) {
            dates = dateStr.split(" ~ ");
            maps.put("beginDate", dates[0]);
            maps.put("endDate", dates[1]);
            if(dateType.equals("day")) {
                where += " AND date_format(t.insertDate, '%Y-%m-%d') >= :beginDate";
                where += " AND date_format(t.insertDate, '%Y-%m-%d') <= :endDate";
            }else if(dateType.equals("month")) {
                where += " AND t.insertMonth >= :beginDate";
                where += " AND t.insertMonth <= :endDate";
            }
        }
        String hql = "SELECT t FROM TblOfflineFilter t";
        page.setPageNo(Integer.parseInt(pageNo));
        page.setPageSize(Integer.parseInt(limit));
        Page<TblOfflineFilterBean> pageResult = offlineFilterHandler.queryByPageFilter(page,hql + where, maps);
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
                List<TblOfflineFilterBean> offlineFilterBeans = null;
                offlineFilterBeans = ExcelUtil.readStreamOffLine(file.getInputStream(), fileType);
                offlineFilterHandler.deleteAll();
                offlineFilterHandler.batchAdd(offlineFilterBeans);
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
     * @Author SunChang
     * @Date 2018/9/10 19:07
     * @param request
    * @param modelMap
     * @Description 线下潜客分析图表数据
     */
    @RequestMapping(value = "/chart", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object flowanalysisChart(HttpServletRequest request) {
        List<Map<String, Object>> maps = null;
        String dateVal = request.getParameter("dateVal");
        String dateType = request.getParameter("dateType");
        String[] dates = null;
        String sql = "SELECT cast(sum(t.offline_flow) as char) offline_flow,";
        String from = " from tbl_offline_filter t";
        String where = " WHERE 1=1";
        String orderBy = " group by t.insert_date order by t.insert_date asc";
        if(StringUtil.isNotBlank(dateVal)) {
            dates = dateVal.split( " ~ ");
            if(dateType.equals("day")) {
                where += " AND date_format(t.insert_date, '%Y-%m-%d') >= ?";
                where += " AND date_format(t.insert_date, '%Y-%m-%d') <= ?";
                maps = offlineFilterHandler.findForJdbc(sql + "t.insert_date date" + from + where + orderBy, dates[0], dates[1]);
            }else if(dateType.equals("month")) {
                where += " AND t.insert_month >= ?";
                where += " AND t.insert_month <= ?";
                orderBy = " group by insert_month order by t.insert_month asc";
                maps = offlineFilterHandler.findForJdbc(sql + "t.insert_month date" + from + where + orderBy, dates[0], dates[1]);
            }
        }else {
            maps = offlineFilterHandler.findForJdbc(sql + "t.insert_date date" + from + orderBy);
        }
        if(null != maps && !maps.isEmpty()) {
            List<String> xAxis = new ArrayList<>();
            List<String> offlineFlow = new ArrayList<>();
            for (Map<String, Object> map : maps) {
                offlineFlow.add(map.get("offline_flow").toString());
                xAxis.add(map.get("date").toString());
            }
            FlowAnalysisChartValue exposure = new FlowAnalysisChartValue("线下流量", "line", "量", offlineFlow);
            List<FlowAnalysisChartValue> series = new ArrayList<>();
            series.add(exposure);
            FlowAnalysisChart flowAnalysisChart = new FlowAnalysisChart(xAxis, series);
            return JsonUtil.beanToJsonString(flowAnalysisChart);
        }else {
            return JsonUtil.toString("N", "无数据！");
        }
    }

}
