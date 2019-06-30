package com.car.web.controller.car;

import com.car.web.utils.Constants;
import jodd.util.StringUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import person.db.bean.CarFindBean;
import person.db.bean.JsonBean;
import person.db.bean.TblAreaBean;
import person.db.bean.TblCarSystemBean;
import person.db.entity.Page;
import person.handler.CarSystemHandler;
import person.handler.FileDetailHandler;
import person.handler.FileHandler;
import person.security.cache.CacheManager;
import person.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/car/find")
public class CarfindController {
    @Autowired
    FileHandler fileHandler;

    @Autowired
    FileDetailHandler fileDetailHandler;

    @Autowired
    CarSystemHandler carSystemHandler;

    @RequestMapping(method = RequestMethod.GET)
    public String listGet(HttpServletRequest request, ModelMap modelMap) {
        Constants.pubMap.remove(UserUtil.getUserId() + "carFindHql");
        Constants.pubMap.remove(UserUtil.getUserId() + "exportStatus");
        return "/car/find/list";
    }

    @RequestMapping(method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object listPost(Page<CarFindBean> page, HttpServletRequest request, ModelMap map) {
        String pageNo = request.getParameter("page");//page是当前页码
        String limit = request.getParameter("limit");//limit是每页数据量
        String dateStr = request.getParameter("dateStr");
        String phones = request.getParameter("phones");
        String taskIds = request.getParameter("taskIds");
        String brandNames = request.getParameter("brandNames");
        String tradeNames = request.getParameter("tradeNames");
        String carSysNames = request.getParameter("carSysNames");
        String cityNames = request.getParameter("cityNames");
        String packageNames = request.getParameter("packageNames");
        String sourceTags = request.getParameter("sourceTags");
        String hql = "SELECT t.uploadDate, t.taskId, t.name,t.phone,t2.provName,t2.cityName,t.carSys,t.brand,t.trade,t1.fileNameBak,t.fileName,t1.sourceTag,t1.bigLibRepeatCount,t1.brandCount,t1.tradeCount,t1.carSysRepeatCount, t1.id FROM TblFileDetail t, TblFile t1, TblArea t2 where t.fileId = t1.id and t.area = t2.areaCode";
        String where = "";
        String dateWhere = "";
        String dateWhere2 = "";
        Map<String,Object> valueMap = new HashMap<String, Object>();
        if(StringUtil.isNotBlank(dateStr)) {
            String[] dates = dateStr.split(" ~ ");
            dateWhere = " AND date_format(t.uploadDate, '%Y-%m-%d') BETWEEN :begin and :end";
            dateWhere2 = " AND date_format(t.uploadDate, '%Y-%m-%d') BETWEEN '" + dates[0] + "' and '" + dates[1] + "'";
            valueMap.put("begin", dates[0]);
            valueMap.put("end", dates[1]);
        }
        if(StringUtil.isNotBlank(phones)) {
            where += " AND t.phone in (";
            filterWhere(where, phones, "\n");
        }
        if(StringUtil.isNotBlank(taskIds)) {
            where += " AND t.taskId in (";
            filterWhere(where, taskIds, ",");
        }
        if(StringUtil.isNotBlank(carSysNames)) {
            Map<String, TblCarSystemBean> carMap = CacheManager.getInstance().getCarMapBeanName();
            String temp = "";
            for (String s : carSysNames.split(",")) {
                if(carMap.get(s) != null) {
                    temp += "'" + carMap.get(s).getCarSysId() + "',";
                }
            }
            temp = temp.substring(0, temp.length() - 1);
            where += " AND t.carSys in (" + temp + ")";
        }else {
            if(StringUtil.isNotBlank(tradeNames)) {
                Map<String, TblCarSystemBean> carMap = CacheManager.getInstance().getCarMapBeanNameTradeName();
                String temp = "";
                for (String s : tradeNames.split(",")) {
                    if(carMap.get(s) != null) {
                        temp += "'" + carMap.get(s).getTradeId() + "',";
                    }
                }
                temp = temp.substring(0, temp.length() - 1);
                where += " AND t.trade in (" + temp + ")";
            }else {
                if(StringUtil.isNotBlank(brandNames)) {
                    Map<String, TblCarSystemBean> carMap = CacheManager.getInstance().getCarMapBeanNameBrandName();
                    String temp = "";
                    for (String s : brandNames.split(",")) {
                        if(carMap.get(s) != null) {
                            temp += "'" + carMap.get(s).getBrandName() + "',";
                        }
                    }
                    temp = temp.substring(0, temp.length() - 1);
                    where += " AND t.brand in (" + temp + ")";
                }
            }
        }
        if(StringUtil.isNotBlank(cityNames)) {
            String citys[] = cityNames.split(",");
            String cityN = "";
            String prov = "";
            Map<String, List<TblAreaBean>> provMap = CacheManager.getInstance().getAreaMapProv();
            Map<String, TblAreaBean> cityMap = CacheManager.getInstance().getgetMapCityName();
            for (String city : citys) {
                if(provMap.get(city) != null) {
                    prov += "'" + city + "',";
                }else {
                    if(cityMap.get(city) != null) {
                        cityN += "'" + city + "',";
                    }
                }
            }
            if(StringUtil.isNotBlank(cityN)) {
                cityN = cityN.substring(0, cityN.length() - 1);
                where += " AND t2.cityName in (" + cityN + ")";
            }
            if(StringUtil.isNotBlank(prov)) {
                prov = prov.substring(0, prov.length() - 1);
                where += " AND t2.provName in (" + prov + ")";
            }
        }
        if(StringUtil.isNotBlank(packageNames)) {
            where += " AND t1.fileNameBak in (";
            filterWhere(where, packageNames, ",");
        }
        if(StringUtil.isNotBlank(sourceTags)) {
            where += " AND t1.sourceTag in (";
            filterWhere(where, sourceTags, ",");
        }
        String order = " order by t.uploadDate desc";
        page.setPageNo(Integer.parseInt(pageNo));
        page.setPageSize(Integer.parseInt(limit));
        Constants.pubMap.put(UserUtil.getUserId() + "carFindHql", hql + dateWhere2 + where + order);
        Page<CarFindBean> pageResult = fileHandler.queryByPageCarFind(page, hql + dateWhere + where + order, valueMap);
        List<CarFindBean> carFindBeans = pageResult.getResult();
        Map<String, TblCarSystemBean> carSysMap = CacheManager.getInstance().getCarMapBean();
        Map<String, TblCarSystemBean> brandIdMap = CacheManager.getInstance().getCarMapBeanNameBrandId();
        Map<String, TblCarSystemBean> tradeIdMap = CacheManager.getInstance().getCarMapBeanNameTradeId();
        for (CarFindBean carFindBean : carFindBeans) {
            if(carSysMap.get(carFindBean.getCarSys()) != null) {
                carFindBean.setCarSys(carSysMap.get(carFindBean.getCarSys()).getCarSysName());
            }
            if(brandIdMap.get(carFindBean.getBrand()) != null) {
                carFindBean.setBrand(brandIdMap.get(carFindBean.getBrand()).getBrandName());
            }
            if(tradeIdMap.get(carFindBean.getTrade()) != null) {
                carFindBean.setTrade(tradeIdMap.get(carFindBean.getTrade()).getTradeName());
            }
        }
        pageResult.setResult(carFindBeans);
        JsonBean jsonBean = new JsonBean("0", "", String.valueOf(pageResult.getTotalCount()), pageResult.getResult());
        return JsonUtil.beanToJsonString(jsonBean);
    }

    @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    public Object exportExcel(HttpServletRequest request, HttpServletResponse response) {
        UpOrDownloadUtil upOrDownloadUtil = new UpOrDownloadUtil();
        String hql = Constants.pubMap.get(UserUtil.getUserId() + "carFindHql").toString();
        //需要导出的结果集
        List<CarFindBean> carFindBeans = fileHandler.queryByhqlFind(hql);
        Map<String, TblCarSystemBean> carSysMap = CacheManager.getInstance().getCarMapBean();
        Map<String, TblCarSystemBean> brandIdMap = CacheManager.getInstance().getCarMapBeanNameBrandId();
        Map<String, TblCarSystemBean> tradeIdMap = CacheManager.getInstance().getCarMapBeanNameTradeId();
        for (CarFindBean carFindBean : carFindBeans) {
            if(carSysMap.get(carFindBean.getCarSys()) != null) {
                carFindBean.setCarSys(carSysMap.get(carFindBean.getCarSys()).getCarSysName());
            }
            if(brandIdMap.get(carFindBean.getBrand()) != null) {
                carFindBean.setBrand(brandIdMap.get(carFindBean.getBrand()).getBrandName());
            }
            if(tradeIdMap.get(carFindBean.getTrade()) != null) {
                carFindBean.setTrade(tradeIdMap.get(carFindBean.getTrade()).getTradeName());
            }
        }
        //excel标题
        String [] title = {"序号", "上传日期", "任务ID", "姓名", "手机号", "省", "城市", "车系", "品牌", "厂商", "包名", "表名", "来源", "大库重复次数", "品牌重复次数", "厂商重复次数", "车系重复次数"};
        //excel文件名
        String fileName = "数据查询" + CarUtil.getDateStr(new Date(), "yyyyMMdd HH:mm:ss") + ".xls";
        //sheet名
        String sheetName = "数据查询";
        String[][] contents = new String[carFindBeans.size()][title.length];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < carFindBeans.size(); i++) {
            CarFindBean bean = carFindBeans.get(i);
            contents[i][0] = String.valueOf(i);
            contents[i][1] = sdf.format(bean.getUploadDate());
            contents[i][2] = bean.getTaskId();
            contents[i][3] = bean.getName();
            contents[i][4] = bean.getPhone();
            contents[i][5] = bean.getProvName();
            contents[i][6] = bean.getCityName();
            contents[i][7] = bean.getCarSys();
            contents[i][8] = bean.getBrand();
            contents[i][9] = bean.getTrade();
            contents[i][10] = bean.getFileNameBak();
            contents[i][11] = bean.getFileName();
            contents[i][12] = bean.getSourceTag();
            contents[i][13] = bean.getBigLibRepeatCount();
            contents[i][14] = bean.getBrandCount();
            contents[i][15] = bean.getTradeCount();
            contents[i][16] = bean.getCarSysRepeatCount();
        }
        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, contents, null);
        upOrDownloadUtil.downLoadCarExcel(fileName, request, response, ExcelUtil.wbToInputstream(wb));
        Constants.pubMap.put(UserUtil.getUserId() + "exportStatus", "ok");
        return null;
    }

    @RequestMapping(value = "/exportStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object exportStatus() {
        try {
            if(StringUtil.isNotBlank((String) Constants.pubMap.get(UserUtil.getUserId() + "exportStatus"))) {
                Constants.pubMap.remove(UserUtil.getUserId() + "exportStatus");
                return JsonUtil.toString("Y", "操作成功！");
            }else {
                return JsonUtil.toString("N", "");
            }
        } catch (Exception e) {
            return JsonUtil.toString("N", "失败异常：" + e.getMessage());
        }
    }

    public void filterWhere(String where, String val, String str) {
        String strs[] = val.split(str);
        for (String s : strs) {
            where += "'" + s + "',";
        }
        where = where.substring(0, where.length() - 1);
        where += ")";
    }
}
