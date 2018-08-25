package com.car.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SunChang on 2018/8/24
 */
@Controller
public class LoginAction {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, ModelMap modelMap) {
        modelMap.put("username", "adminSuper");
        modelMap.put("pwd", "123456");
        return "/login";
    }

    @RequestMapping(value = "/loginFail", method = RequestMethod.GET)
    public String loginFail(HttpServletRequest request, ModelMap modelMap) {
        if(request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION") != null) {
            modelMap.addAttribute("error", "true");
        }
        return "/login";
    }
}
