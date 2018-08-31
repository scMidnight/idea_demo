package com.car.web.controller.blackList;

import com.car.web.utils.TxtUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import person.util.MessageBean;
import person.util.UserUtil;

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
            StringBuilder sb = TxtUtil.readTxt();
            modelMap.put("conten", sb.toString());
            modelMap.put("lineNum", TxtUtil.lineNum(sb));
            modelMap.put("isBlack", UserUtil.getUser().getIsBlack());
        } catch (IOException e) {
            System.err.println("解析错误:" + e.getMessage());
        }
        return "/blackList/list";
    }

    /**
     * @Author SunChang
     * @Date 2018/8/30 16:21
     * @param request
    * @param modelMap
     * @Description 黑名单列表
     */
    @RequestMapping(value = "/blackList", method = RequestMethod.POST)
    @ResponseBody
    public MessageBean blackListPost(HttpServletRequest request, ModelMap modelMap) {
        MessageBean messageBean = new MessageBean();
        try {
            String blackList = request.getParameter("blackList");
            TxtUtil.writeTxt(blackList);
            messageBean.setStatus("y");
        } catch (IOException e) {
            System.err.println("写入错误:" + e.getMessage());
            messageBean.setMsg("写入错误，请联系管理员。");
        }
        return messageBean;
    }

}
