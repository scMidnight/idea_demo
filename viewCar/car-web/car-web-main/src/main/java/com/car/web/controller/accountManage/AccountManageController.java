package com.car.web.controller.accountManage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import person.db.bean.AccountManageBean;
import person.db.bean.JsonBean;
import person.db.bean.TblFileBean;
import person.db.entity.Page;
import person.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/*
账号管理-账号管理
 */
@Controller
@RequestMapping(value = "/accountManage")
public class AccountManageController {

    /**
     * @Author SunChang
     * @Date 2018/8/28 18:58
     * @param request
    * @param map
     * @Description 意向客户采集
     */
    @RequestMapping(method = RequestMethod.GET)
    public String accountManageGet(HttpServletRequest request, ModelMap map) throws Exception {
        //UserUtil - 获取当前登录用户的工具类
        return "/accountManage/accountManage/list";
    }

    /**
     * @Author SunChang
     * @Date 2018/8/30 16:21
     * @param request
    * @param modelMap
     * @Description 静态数据
     */
    @RequestMapping(value = "/admin1", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String admin1Post(HttpServletRequest request) {
        AccountManageBean manageBean = new AccountManageBean("10001","admin","**********","375463548@qq.com","13800138000","1,2,3,4,5","新建|编辑|删除|整理");
        List<AccountManageBean> list = new ArrayList<>();
        list.add(manageBean);
        JsonBean jsonBean = new JsonBean("0", "", "1", list);
        return JsonUtil.beanToJsonString(jsonBean);
    }
}
