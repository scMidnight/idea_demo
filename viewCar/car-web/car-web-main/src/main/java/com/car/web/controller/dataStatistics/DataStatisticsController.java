package com.car.web.controller.dataStatistics;

import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import person.db.bean.*;
import person.handler.AreaHandler;
import person.handler.CarSystemHandler;
import person.handler.FileDetailHandler;
import person.handler.FileHandler;
import person.security.cache.CacheManager;
import person.util.CarUtil;
import person.util.JsonUtil;
import person.util.UserUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by SunChang on 2018/9/10
 */
@Controller
public class DataStatisticsController {

    @Autowired
    FileHandler fileHandler;

    @Autowired
    FileDetailHandler fileDetailHandler;

    @Autowired
    CarSystemHandler carSystemHandler;

    @Autowired
    AreaHandler areaHandler;

    /**
     * @Author SunChang
     * @Date 2018/9/10 19:07
     * @param request
    * @param modelMap
     * @Description 数据统计页
     */
    @RequestMapping(value = "/car/dataStatistics", method = RequestMethod.GET)
    public String carDataStatisticsGet(HttpServletRequest request, ModelMap modelMap) {
        modelMap.put("userCode", UserUtil.getName());
        return "/dataStatistics/statistics";
    }

    /**
     * @Author SunChang
     * @Date 2018/9/10 19:07
     * @param request
    * @param modelMap
     * @Description 数据统计页
     */
    @RequestMapping(value = "/car/dataStatistics/carSys", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object carSysStatisticsPost(HttpServletRequest request) {
        List<Map<String, Object>> maps = null;
        String dateVal = request.getParameter("dateVal");
        String[] dates = dateVal.split(" ~ ");
        String type = request.getParameter("type");
        List<PieData> pieDatas = new ArrayList<PieData>();
        if(type.equals("carSys")) {
            maps = fileDetailHandler.findForJdbc("select t.car_sys name,count(t.car_sys) number from tbl_file_detail t where t.status='0' and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ? GROUP BY t.car_sys ORDER BY number desc LIMIT 20", dates[0], dates[1]);
        }else if(type.equals("city")) {
            maps = fileDetailHandler.findForJdbc("select t.area name,count(t.area) number from tbl_file_detail t where t.status='0' and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ? GROUP BY t.area ORDER BY number desc LIMIT 20", dates[0], dates[1]);
        }else if(type.equals("prov")) {
            maps = fileDetailHandler.findForJdbc("select t1.prov_name name, count(t1.prov_name) number from tbl_file_detail t,tbl_area t1 where t.status='0' and t.area = t1.area_code and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ? GROUP BY t1.prov_name ORDER BY number desc LIMIT 20", dates[0], dates[1]);
        }else {
            return JsonUtil.toString("N", "无数据！");
        }
        Map<String, String> carSysMaps = CacheManager.getInstance().getCarMap();
        Map<String, String> areaMaps = CacheManager.getInstance().getAreaMap();
        if(null != maps && maps.size() > 0) {
            for (Map<String, Object> map : maps) {
                String name = map.get("name").toString();
                PieData pieData = new PieData();
                if(type.equals("carSys")) {
                    String temp = carSysMaps.get(name) != null ? carSysMaps.get(name) : name;
                    pieData.setName(temp);
                }
                if(type.equals("city")) {
                    String temp = areaMaps.get(name) != null ? areaMaps.get(name) : name;
                    pieData.setName(temp);
                }
                if(type.equals("prov")) {
                    pieData.setName(name);
                }
                pieData.setValue(map.get("number").toString());
                pieDatas.add(pieData);
            }
        }else {
            return JsonUtil.toString("N", "无数据！");
        }
        PieBean pieBean = new PieBean(pieDatas, "", "");
        return JsonUtil.beanToJsonString(pieBean);
    }

    /**
     * @Author SunChang
     * @Date 2018/9/11 18:40
     * @param request
    * @param modelMap
     * @Description 点击详情查看进入的页面
     */
    @RequestMapping(value = "/car/dataStatistics/info", method = RequestMethod.GET)
    public String carDataStatisticsInfoGet(HttpServletRequest request, ModelMap modelMap) {
        String type = request.getParameter("choice");
        String dateVal = request.getParameter("dateVal");
        modelMap.put("userCode", UserUtil.getName());
        modelMap.put("type", type);
        modelMap.put("dateVal", dateVal);
        return "/dataStatistics/info";
    }

    /**
     * @Author SunChang
     * @Date 2018/9/11 18:40
     * @param request
    * @param modelMap
     * @Description 点击详情查看进入的页面
     */
    @RequestMapping(value = "/car/dataStatistics/info", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object carDataStatisticsInfoPost(HttpServletRequest request, ModelMap modelMap) {
        List<Map<String, Object>> maps = null;
        String type = request.getParameter("type");
        String dateVal = request.getParameter("dateVal");
        if(StringUtil.isBlank(dateVal)) {
            JsonBean jsonBean = new JsonBean("0", "", "0", null);
            return JsonUtil.beanToJsonString(jsonBean);
        }
        String[] dates = dateVal.split(" ~ ");
        List<StatisticsBean> statisticsBeans = new ArrayList<StatisticsBean>();
        Map<String, String> areaMaps = CacheManager.getInstance().getAreaMap();
        if(StringUtil.isBlank(type)) {
            JsonBean jsonBean = new JsonBean("0", "", "0", null);
            return JsonUtil.beanToJsonString(jsonBean);
        }
        if(type.equals("carSys")) {
            Map<String, TblCarSystemBean> carSysMaps = CacheManager.getInstance().getCarMapBean();
            Map<String, TblCarSystemBean> carSysMapNames = CacheManager.getInstance().getCarMapBeanName();
            maps = fileDetailHandler.findForJdbc("select t.car_sys name,count(t.car_sys) number from tbl_file_detail t where t.status='0' and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ? GROUP BY t.car_sys ORDER BY number desc LIMIT 20", dates[0], dates[1]);
            if(null != maps && maps.size() > 0) {
                for (Map<String, Object> map : maps) {
                    StatisticsBean statisticsBean = new StatisticsBean();
                    String name = map.get("name") == null ? "" : map.get("name").toString();
                    statisticsBean.setId(name);
                    if (CarUtil.isInteger(name)) {
                        statisticsBean.setCarSys(carSysMaps.get(name).getCarSysName());
                        statisticsBean.setTradeName(carSysMaps.get(name).getTradeName());
                    } else {
                        statisticsBean.setCarSys(name);
                        statisticsBean.setTradeName(carSysMapNames.get(name) != null ? carSysMapNames.get(name).getTradeName() : "无");
                    }
                    statisticsBean.setSum(map.get("number").toString());
                    statisticsBeans.add(statisticsBean);
                }
            }
        }else if(type.equals("city")) {
            maps = fileDetailHandler.findForJdbc("select t.area name,count(t.area) number from tbl_file_detail t where t.status='0' and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ? GROUP BY t.area ORDER BY number desc LIMIT 20", dates[0], dates[1]);
            if(null != maps && maps.size() > 0) {
                for (Map<String, Object> map : maps) {
                    StatisticsBean statisticsBean = new StatisticsBean();
                    String name = map.get("name").toString();
                    statisticsBean.setId(name);
                    statisticsBean.setCity(areaMaps.get(name).toString());
                    statisticsBean.setSum(map.get("number").toString());
                    statisticsBeans.add(statisticsBean);
                }
            }
        }else if(type.equals("prov")) {
            maps = fileDetailHandler.findForJdbc("select t1.prov_name name, count(t1.prov_name) number from tbl_file_detail t,tbl_area t1 where t.status='0' and t.area = t1.area_code and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ? GROUP BY t1.prov_name ORDER BY number desc LIMIT 20", dates[0], dates[1]);
            if(null != maps && maps.size() > 0) {
                for (Map<String, Object> map : maps) {
                    StatisticsBean statisticsBean = new StatisticsBean();
                    statisticsBean.setId(map.get("name").toString());
                    statisticsBean.setProv(map.get("name").toString());
                    statisticsBean.setSum(map.get("number").toString());
                    statisticsBeans.add(statisticsBean);
                }
            }
        }else {
            JsonBean jsonBean = new JsonBean("0", "", "0", null);
            return JsonUtil.beanToJsonString(jsonBean);
        }
        JsonBean jsonBean = new JsonBean("0", "", String.valueOf(statisticsBeans.size()), statisticsBeans);
        return JsonUtil.beanToJsonString(jsonBean);
    }

    /**
     * @Author SunChang
     * @Date 2018/9/10 19:07
     * @param request
    * @param modelMap
     * @Description 从详情页点击进入的图表页
     */
    @RequestMapping(value = "/car/dataStatistics/infoChart", method = RequestMethod.GET)
    public String infoChartGet(HttpServletRequest request, ModelMap modelMap) {
        String type = request.getParameter("type");
        String dateVal = request.getParameter("dateVal");
        String id = request.getParameter("id");
        modelMap.put("userCode", UserUtil.getName());
        modelMap.put("type", type);
        modelMap.put("dateVal", dateVal);
        modelMap.put("id", id);
        if(type.equals("city")) {
            String cityName = areaHandler.findByProperty("areaCode", id).get(0).getCityName();
            modelMap.put("cityName", cityName);
            return "/dataStatistics/cityChart";
        }
        if(type.equals("prov")) {
            modelMap.put("provName", id);
            return "/dataStatistics/provChart";
        }
        String carSysName = carSystemHandler.findByProperty("carSysId",id).get(0).getCarSysName();
        modelMap.put("carSysName", carSysName);
        return "/dataStatistics/chart";
    }

    /**
     * @Author SunChang
     * @Date 2018/9/10 19:07
     * @param request
    * @param modelMap
     * @Description 从详情页点击进入的图表页
     */
    @RequestMapping(value = "/car/dataStatistics/infoChart", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object infoChartPost(HttpServletRequest request, ModelMap modelMap) {
        String type = request.getParameter("type");
        String dateVal = request.getParameter("dateVal");
        String id = request.getParameter("id");
        if(StringUtil.isBlank(dateVal) || StringUtil.isBlank(type) || StringUtil.isBlank(id)) {
            JsonBean jsonBean = new JsonBean("0", "", "0", null);
            return JsonUtil.beanToJsonString(jsonBean);
        }
        List<PieData> pieDatas = new ArrayList<PieData>();
        List<Map<String, Object>> maps = null;
        String[] dates = dateVal.split(" ~ ");
        if(type.equals("prov")) {
            maps = fileDetailHandler.findForJdbc("select t1.prov_name name, count(t1.prov_name) number from tbl_file_detail t,tbl_area t1 where t.car_sys = ? and t.status='0' and t.area = t1.area_code and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ? GROUP BY t1.prov_name ORDER BY number desc LIMIT 20", id, dates[0], dates[1]);
        }else if(type.equals("city")) {
            maps = fileDetailHandler.findForJdbc("select t.area name,count(t.area) number from tbl_file_detail t where t.car_sys=? and t.status='0' and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ? GROUP BY t.area ORDER BY number desc LIMIT 20", id, dates[0], dates[1]);
        }else if(type.equals("cityCarSys")) {
            maps = fileDetailHandler.findForJdbc("select t.car_sys name,count(t.car_sys) number from tbl_file_detail t where t.area = ? and t.status='0' and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ? GROUP BY t.car_sys ORDER BY number desc LIMIT 20", id, dates[0], dates[1]);
        }else if(type.equals("provCarSys")) {
            maps = fileDetailHandler.findForJdbc("select t.car_sys name,count(t.car_sys) number from tbl_file_detail t, tbl_area t1 where t.area = t1.area_code and t1.prov_name = ? and t.status='0' and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ? GROUP BY t.car_sys ORDER BY number desc LIMIT 20", id, dates[0], dates[1]);
        }
        Map<String, String> carSysMaps = CacheManager.getInstance().getCarMap();
        Map<String, String> areaMaps = CacheManager.getInstance().getAreaMap();
        if(null != maps && maps.size() > 0) {
            for (Map<String, Object> map : maps) {
                String name = map.get("name").toString();
                PieData pieData = new PieData();
                if(type.equals("prov")) {
                    pieData.setName(name);
                }
                if(type.equals("city")) {
                    pieData.setName(areaMaps.get(name));
                }
                if(type.equals("cityCarSys") || type.equals("provCarSys")) {
                    pieData.setName(carSysMaps.get(name));
                }
                pieData.setValue(map.get("number").toString());
                pieDatas.add(pieData);
            }
        }else {
            return JsonUtil.toString("N", "无数据！");
        }
        PieBean pieBean = new PieBean(pieDatas, "", "");
        return JsonUtil.beanToJsonString(pieBean);
    }

    public static void main(String[] args) {
        String a = "[";
        for (int i = 0; i < 6; i++) {
            a += "'" + i + "',";
        }
        a = a.substring(0, a.length() - 1);
        a += "]";
        System.out.println(a);
    }
}
