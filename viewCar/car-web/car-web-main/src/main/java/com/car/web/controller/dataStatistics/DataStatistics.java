package com.car.web.controller.dataStatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import person.handler.FileDetailHandler;
import person.handler.FileHandler;
import person.util.UserUtil;

import javax.servlet.http.HttpServletRequest;

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
}
