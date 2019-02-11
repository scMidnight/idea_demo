package com.car.web.controller.onLine;

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
import person.handler.FlowAnalysisHandler;
import person.util.ExcelUtil;
import person.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
线上广告管理--友道汽车流量分析
 */
@Controller
public class FlowAnalysisController {

    @Autowired
    FlowAnalysisHandler flowAnalysisHandler;

    /**
     * @Author SunChang
     * @Date 2018/8/30 16:21
     * @param request
    * @param modelMap
     * @Description 友道汽车流量分析
     */
    @RequestMapping(value = "/flowAnalysis/list", method = RequestMethod.GET)
    public String flowAnalysisListGet(HttpServletRequest request, ModelMap modelMap) {
        return "/onLine/flowAnalysis/list";
    }

    /**
     * @Author SunChang
     * @Date 2018/11/30 13:45
     * @param page
    * @param request
    * @param map
     * @Description excel友道汽车流量分析列表查询
     */
    @RequestMapping(value = "/flowAnalysis/list", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object flowAnalysisListPost(Page<TblFlowAnalysisBean> page, HttpServletRequest request, ModelMap map) {
        Map<String, Object> maps = new HashMap<>();
        String pageNo = request.getParameter("page");//page是当前页码
        String limit = request.getParameter("limit");//limit是每页数据量
        String dateStr = request.getParameter("dateStr");
        String dateType = request.getParameter("dateType");
        String field = request.getParameter("field");
        String order = request.getParameter("order");
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
        String hql = "SELECT t FROM TblFlowAnalysis t";
        String orderSql = " order by t.insertDate desc";
        if(StringUtil.isNotBlank(field) && StringUtil.isNotBlank(order)) {
            orderSql = " order by t." + field + " " + order;
        }
        page.setPageNo(Integer.parseInt(pageNo));
        page.setPageSize(Integer.parseInt(limit));
        Page<TblFlowAnalysisBean> pageResult = flowAnalysisHandler.queryByPageFilter(page,hql + where + orderSql, maps);
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
    @RequestMapping(value = "/flowAnalysis/list/insert", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object excelInsert(@RequestParam("file") MultipartFile[] files, HttpServletRequest request, HttpServletResponse response) {
        JsonBean jsonBean = null;
        boolean flag = true;
        String ex = "";
        for (MultipartFile file : files) {
            try {
                String fileName = file.getOriginalFilename();
                String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
                List<TblFlowAnalysisBean> flowAnalysisBeans = null;
                flowAnalysisBeans = ExcelUtil.readStreamFlowAnalysis(file.getInputStream(), fileType);
                flowAnalysisHandler.deleteAll();
                flowAnalysisHandler.batchAdd(flowAnalysisBeans);
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
     * @Description 汽车流量分析图表数据
     */
    @RequestMapping(value = "/flowAnalysis/list/chart", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object flowanalysisChart(HttpServletRequest request) {
        List<Map<String, Object>> maps = null;
        String dateVal = request.getParameter("dateVal");
        String dateType = request.getParameter("dateType");
        String[] dates = null;
        String sql = "SELECT cast(sum(t.exposure_num) as char) exposure_num, cast(sum(t.click_num) as char) click_num,";
        String from = " from tbl_flow_analysis t";
        String where = " WHERE 1=1";
        String orderBy = " group by t.insert_date order by t.insert_date asc";
        if(StringUtil.isNotBlank(dateVal)) {
            dates = dateVal.split( " ~ ");
            if(dateType.equals("day")) {
                where += " AND date_format(t.insert_date, '%Y-%m-%d') >= ?";
                where += " AND date_format(t.insert_date, '%Y-%m-%d') <= ?";
                maps = flowAnalysisHandler.findForJdbc(sql + "t.insert_date date" + from + where + orderBy, dates[0], dates[1]);
            }else if(dateType.equals("month")) {
                where += " AND t.insert_month >= ?";
                where += " AND t.insert_month <= ?";
                orderBy = " group by insert_month order by t.insert_month asc";
                maps = flowAnalysisHandler.findForJdbc(sql + "t.insert_month date" + from + where + orderBy, dates[0], dates[1]);
            }
        }else {
            maps = flowAnalysisHandler.findForJdbc(sql + "t.insert_date date" + from + orderBy);
        }
        if(null != maps && !maps.isEmpty()) {
            List<String> xAxis = new ArrayList<>();
            List<String> exposureDatas = new ArrayList<>();
            List<String> clickDatas = new ArrayList<>();
            for (Map<String, Object> map : maps) {
                exposureDatas.add(map.get("exposure_num").toString());
                clickDatas.add(map.get("click_num").toString());
                xAxis.add(map.get("date").toString());
            }
            FlowAnalysisChartValue exposure = new FlowAnalysisChartValue("曝光", "line", "量", exposureDatas);
            FlowAnalysisChartValue click = new FlowAnalysisChartValue("点击", "line", "量", clickDatas);
            List<FlowAnalysisChartValue> series = new ArrayList<>();
            series.add(exposure);
            series.add(click);
            FlowAnalysisChart flowAnalysisChart = new FlowAnalysisChart(xAxis, series);
            return JsonUtil.beanToJsonString(flowAnalysisChart);
        }else {
            return JsonUtil.toString("N", "无数据！");
        }
    }
}
