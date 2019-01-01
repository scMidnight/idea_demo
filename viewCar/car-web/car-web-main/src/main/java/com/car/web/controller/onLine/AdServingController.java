package com.car.web.controller.onLine;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/*
线上广告管理--广告投放创建
 */
@Controller
@RequestMapping(value = "/adServing")
public class AdServingController {

    /**
     * @Author SunChang
     * @Date 2018/8/28 18:58
     * @param request
    * @param map
     * @Description 广告投放创建
     */
    @RequestMapping(method = RequestMethod.GET)
    public String adServingGet(HttpServletRequest request, ModelMap map) throws Exception {
        //UserUtil - 获取当前登录用户的工具类
        return "/onLine/adServing/add";
    }
}
