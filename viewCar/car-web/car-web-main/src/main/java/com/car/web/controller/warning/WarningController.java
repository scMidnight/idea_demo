package com.car.web.controller.warning;

import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import person.db.bean.PieBean;
import person.db.bean.PieData;
import person.handler.AreaHandler;
import person.handler.CarSystemHandler;
import person.handler.FileDetailHandler;
import person.handler.FileHandler;
import person.util.JsonUtil;
import person.util.UserUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by SunChang on 2018/9/12
 */
@Controller
public class WarningController {
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
     * @Date 2018/9/12 10:31
     * @param request
    * @param modelMap
     * @Description 监测预警
     */
    @RequestMapping(value = "/car/warning", method = RequestMethod.GET)
    public String carWarningGet(HttpServletRequest request, ModelMap modelMap) {
        modelMap.put("userCode", UserUtil.getName());
        return "/warning/warning";
    }

    /**
     * @Author SunChang
     * @Date 2018/9/12 10:39
     * @param request
     * @Description
     */
    @RequestMapping(value = "/car/warning", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object carWarningPost(HttpServletRequest request) {
        String type = request.getParameter("type");
        String dateVal = request.getParameter("dateVal");
        if(StringUtil.isBlank(type) || StringUtil.isBlank(dateVal)) {
            return JsonUtil.toString("N", "无数据！");
        }
        String[] dates = dateVal.split(" ~ ");
        List<Map<String, Object>> maps = null;
        List<PieData> pieDatas = new ArrayList<PieData>();
        if(type.equals("bigLib")) {
            maps = fileDetailHandler.findForJdbc("SELECT '重复数据' name, count(1) number from tbl_file_detail t where t.`status` = '1' and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ?" +
                    "UNION ALL " +
                    "select '正常数据' name, count(1) number from tbl_file_detail t where t.`status` = '0' and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ?", dates[0], dates[1], dates[0], dates[1]);
        }else if(type.equals("bigLibCount")) {
            maps = fileDetailHandler.findForJdbc("select t.name name,  sum(t.number) number from (select concat(CAST(count(1) as char),'次') name, count(1) number from tbl_file_detail t where t.status = '1' and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ? GROUP BY t.phone HAVING (number <= 7)) t group by t.name" +
                    " union all " +
                    "select '7次以上' name, ifnull(sum(number), 0) number from(" +
                    "select count(1) number from tbl_file_detail t where t.status = '1' and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ? GROUP BY t.phone HAVING(number > 7) ) t", dates[0], dates[1], dates[0], dates[1]);
        }else if(type.equals("carSys")) {
            maps = fileDetailHandler.findForJdbc("select '车系重复数据' name, count(1) number from tbl_file_detail t where t.`status` = '3' and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ?" +
                    " union all " +
                    "select '正常数据' name, count(1) number from tbl_file_detail t where t.`status` = '0' and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ?", dates[0], dates[1], dates[0], dates[1]);
        }else if(type.equals("phone")) {
            maps = fileDetailHandler.findForJdbc("select '号段错误数据' name, count(1) number from tbl_file_detail t where t.`status` = '5' and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ?" +
                    " union all " +
                    "select '正常数据' name, count(1) number from tbl_file_detail t where t.`status` = '0' and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ?", dates[0], dates[1], dates[0], dates[1]);
        }else if(type.equals("black")) {
            maps = fileDetailHandler.findForJdbc("select '黑名单数据' name, count(1) number from tbl_file_detail t where t.`status` = '4' and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ?" +
                    " union all " +
                    "select '正常数据' name, count(1) number from tbl_file_detail t where t.`status` = '0' and date_format(t.UPLOAD_DATE, '%Y-%m-%d') BETWEEN ? and ?", dates[0], dates[1], dates[0], dates[1]);
        }else {
            return JsonUtil.toString("N", "无数据！");
        }
        if(null != maps && maps.size() > 0) {
            for (Map<String, Object> map : maps) {
                PieData pieData = new PieData();
                pieData.setName(map.get("name").toString());
                pieData.setValue(map.get("number").toString());
                pieDatas.add(pieData);
            }
        }else {
            return JsonUtil.toString("N", "无数据！");
        }
        PieBean pieBean = new PieBean(pieDatas, "", "");
        return JsonUtil.beanToJsonString(pieBean);
    }
}
