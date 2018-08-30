package com.car.web.controller.blackList;

import com.car.web.utils.TxtUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by SunChang on 2018/8/30
 */
@Controller
public class BlackListController {


    /**
     * @Author SunChang
     * @Date 2018/8/30 16:21
     * @param request
    * @param modelMap
     * @Description 黑名单列表
     */
    @RequestMapping(value = "/blackList", method = RequestMethod.GET)
    public String blackListGet(HttpServletRequest request, ModelMap modelMap) {
        try {
            modelMap.put("conten", TxtUtil.readTxt());
        } catch (IOException e) {
            System.err.println("解析错误:" + e.getMessage());
        }
        return "/blackList/list";
    }


}
