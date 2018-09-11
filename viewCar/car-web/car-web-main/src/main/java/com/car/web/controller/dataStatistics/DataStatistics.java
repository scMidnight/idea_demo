package com.car.web.controller.dataStatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import person.db.bean.PieBean;
import person.handler.FileDetailHandler;
import person.handler.FileHandler;
import person.security.cache.CacheManager;
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
public class DataStatistics {

    @Autowired
    FileHandler fileHandler;

    @Autowired
    FileDetailHandler fileDetailHandler;

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
     * @Description 车系统计数据
     */
    @RequestMapping(value = "/car/dataStatistics/carSys", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object carSysStatistics(HttpServletRequest request) {
        List<PieBean> pieBeans = new ArrayList<PieBean>();
        List<Map<String, Object>> maps = fileDetailHandler.findForJdbc("select t.car_sys,count(t.car_sys) number from tbl_file_detail t GROUP BY t.car_sys ORDER BY number desc LIMIT 20");
        Map<String, String> carSysMaps = CacheManager.getInstance().getCarMap();
        if(null != maps && maps.size() > 0) {
            for (Map<String, Object> map : maps) {
                String name = map.get("car_sys").toString();
                PieBean pieBean = new PieBean();
                pieBean.setName(carSysMaps.get(name) != null ? carSysMaps.get(name) : name);
                pieBean.setValue(map.get("number").toString());
                pieBeans.add(pieBean);
            }
        }
        return JsonUtil.beanToJsonString(pieBeans);
    }
}
