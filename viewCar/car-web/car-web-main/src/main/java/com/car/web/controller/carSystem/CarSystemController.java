package com.car.web.controller.carSystem;

import jodd.util.StringUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import person.db.bean.TableJsonBean;
import person.db.bean.TblCarSystemBean;
import person.db.entity.Page;
import person.handler.CarSystemHandler;
import person.util.ExcelUtil;
import person.util.IdUtils;
import person.util.JsonUtil;
import person.util.UpOrDownloadUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SunChang on 2018/8/28
 */
@Controller
public class CarSystemController {
    @Autowired
    CarSystemHandler carSystemHandler;

    @RequestMapping(value = "/carSystem/info", method = RequestMethod.GET)
    public String carSystemInfoGet(HttpServletRequest request, ModelMap modelMap) {
        return "/carSystem/list";
    }

    /**
     * @Author SunChang
     * @Date 2018/8/28 17:28
     * @param page
    * @param request
    * @param map
     * @Description 车系信息列表
     */
    @RequestMapping(value = "/carSystem/info", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object carSystemInfoPost(Page<TblCarSystemBean> page, HttpServletRequest request, ModelMap map) {
        String pageNo = request.getParameter("page");//page是当前页码
        String limit = request.getParameter("limit");//limit是每页数据量
        String key = request.getParameter("key");//得到前台选中的值
        String hql = "SELECT t FROM TblCarSystem t WHERE t.isDel = '0' ";
        Map<String,Object> valueMap = new HashMap<String, Object>();
        String where = "";
        if(StringUtil.isNotBlank(key)) {
            String val = request.getParameter("selectedVal");
            where = " AND t." + key + " like '%" + val + "%'";
        }
        page.setPageNo(Integer.parseInt(pageNo));
        page.setPageSize(Integer.parseInt(limit));
        Page<TblCarSystemBean> pageResult = carSystemHandler.queryByPageFilter(page,hql + where, valueMap);
        TableJsonBean tableJsonBean = new TableJsonBean("0", "", String.valueOf(pageResult.getTotalCount()), pageResult.getResult());
        return JsonUtil.beanToJsonString(tableJsonBean);
    }

    /**
     * 车系信息删除
     **/
    @RequestMapping(value = "/carSystem/info/delInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object delInfoPost(String id) {
        try {
            carSystemHandler.removeCarSystemInfo(id);
            return JsonUtil.toString("Y", "操作成功！");
        } catch (Exception e) {
            return JsonUtil.toString("N", "失败异常：" + e.getMessage());
        }
    }

    /**
     * @Author SunChang
     * @Date 2018/8/28 18:58
     * @param request
    * @param map
     * @Description 新增车系
     */
    @RequestMapping(value = "/carSystem/info/add", method = RequestMethod.GET)
    public String carSystemInfoAddGet(HttpServletRequest request, ModelMap map) throws Exception {
        //UserUtil - 获取当前登录用户的工具类
        return "/carSystem/add";
    }

    /**
     * @Author SunChang
     * @Date 2018/8/28 18:58
     * @param request
    * @param map
     * @Description 新增车系
     */
    @RequestMapping(value = "/carSystem/info/add", method = RequestMethod.POST)
    public String carSystemInfoAddPost(TblCarSystemBean carSystemBean, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        //UserUtil - 获取当前登录用户的工具类
        carSystemBean.setId(IdUtils.randomString());
        carSystemBean.setIsDel("0");
        try {
            carSystemHandler.addCarSystemInfo(carSystemBean);
            redirectAttributes.addFlashAttribute("add_status", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("add_status", "error");
            redirectAttributes.addFlashAttribute("error_info", "添加异常：" + e.getMessage() + "。");
        }
        return "redirect:/carSystem/info";
    }

    /**
     * @Author SunChang
     * @Date 2018/8/28 20:35
     * @param request
    * @param response
     * @Description 导出所有车系数据为excel文件
     */
    @RequestMapping(value = "/carSystem/info/exportExcel", method = RequestMethod.GET)
    public Object exportExcel(HttpServletRequest request, HttpServletResponse response) {
        UpOrDownloadUtil upOrDownloadUtil = new UpOrDownloadUtil();
        //需要导出的结果集
        List<TblCarSystemBean> carSystemBeans = carSystemHandler.queryAll();
        //excel标题
        String [] title = {"品牌ID", "品牌名称", "厂商ID", "厂商名称", "车系ID", "车系名称"};
        //excel文件名
        String fileName = "车系数据表"+System.currentTimeMillis()+".xls";
        //sheet名
        String sheetName = "车系信息";
        String[][] contents = new String[carSystemBeans.size()][title.length];
        for (int i = 0; i < carSystemBeans.size(); i++) {
            TblCarSystemBean tblCarSystemBean = carSystemBeans.get(i);
            contents[i][0] = tblCarSystemBean.getBrandId();
            contents[i][1] = tblCarSystemBean.getBrandName();
            contents[i][2] = tblCarSystemBean.getTradeId();
            contents[i][3] = tblCarSystemBean.getTradeName();
            contents[i][4] = tblCarSystemBean.getCarSysId();
            contents[i][5] = tblCarSystemBean.getCarSysName();
        }
        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, contents, null);
        upOrDownloadUtil.downLodaCarExcel(fileName, request, response, ExcelUtil.wbToInputstream(wb));
        return null;
    }
}
