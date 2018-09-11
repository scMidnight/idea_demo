package com.car.web.controller.batchExport;

import com.car.web.utils.Constants;
import jodd.util.StringUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import person.db.bean.TblFileBean;
import person.db.bean.TblFileDetailBean;
import person.handler.FileDetailHandler;
import person.handler.FileHandler;
import person.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SunChang on 2018/9/10
 */
@Controller
public class BatchExportController {
    @Autowired
    FileHandler fileHandler;

    @Autowired
    FileDetailHandler fileDetailHandler;

    /**
     * @Author SunChang
     * @Date 2018/9/10 15:12
     * @param request
    * @param modelMap
     * @Description 批量导出
     */
    @RequestMapping(value = "/car/batchExport", method = RequestMethod.GET)
    public String carBatchExportGet(HttpServletRequest request, ModelMap modelMap) {
        modelMap.put("userCode", UserUtil.getName());
        return "/batchExport/batchExport";
    }

    /**
     * @Author SunChang
     * @Date 2018/9/10 15:32
     * @param request
    * @param response
     * @Description 导出范围内全部数据
     */
    @RequestMapping(value = "/car/batchExport/export", method = RequestMethod.GET)
    public Object carListExportPackage(HttpServletRequest request, HttpServletResponse response) {
        Constants.pubMap.put(UserUtil.getUserId() + "batchExportExce", false);//记录公共变量当前用户导出excel是否成功
        String dateStr = request.getParameter("dateStr");
        String[] dates = dateStr.split(" ~ ");
        String arrs = request.getParameter("arrs");
        String hql = "FROM TblFileDetail t where t.fileId = ?";
        String where = " and t.status not in (";
        String where1 = "";
        if(StringUtil.isNotBlank(arrs)) {
            if(arrs.length() > 1) {
                String[] arrs1 = arrs.split(",");
                for (int i = 0; i < arrs1.length; i++) {
                    String s = arrs1[i];
                    if (CarUtil.isInteger(s)) {
                        where1 += "'" + s + "',";
                    }
                }
            }else {
                if (CarUtil.isInteger(arrs)) {
                    where1 += "'" + arrs + "',";
                }
            }
        }
        if(StringUtil.isNotBlank(where1)) {
            where1 = where1.substring(0, where1.length() - 1);
            hql = hql + where + where1 + ")";
        }
        //excel标题
        String [] title = {"姓名", "手机号", "城市ID", "车系ID", "车型ID", "经销商ID"};
        //excel文件名
        String fileName = dateStr + ".xls";
        //sheet名
        String sheetName = dateStr;
        List<TblFileBean> fileBeans = fileHandler.queryByHql("FROM TblFile t where t.status = ? and date_format(t.uploadDate, '%Y-%m-%d') BETWEEN ? and ?", "1", dates[0], dates[1]);
        if(fileBeans != null && fileBeans.size() > 0) {
            List<TblFileDetailBean> list = new ArrayList<TblFileDetailBean>();
            for (TblFileBean fileBean : fileBeans) {
                List<TblFileDetailBean> fileDetailBeans = fileDetailHandler.queryByHql(hql, fileBean.getId());
                for (TblFileDetailBean fileDetailBean : fileDetailBeans) {
                    list.add(fileDetailBean);
                }
            }
            String[][] contents = new String[list.size()][title.length];
            for (int i = 0; i < list.size(); i++) {
                contents[i][0] = list.get(i).getName();
                contents[i][1] = list.get(i).getPhone();
                contents[i][2] = list.get(i).getArea();
                contents[i][3] = list.get(i).getCarSys();
                contents[i][4] = "";
                contents[i][5] = "";
            }
            //创建HSSFWorkbook
            HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, contents, null);
            UpOrDownloadUtil up = new UpOrDownloadUtil();
            up.downLoadCarExcel(fileName, request, response, ExcelUtil.wbToInputstream(wb));
            Constants.pubMap.put(UserUtil.getUserId() + "batchExportExce", true);//记录公共变量当前用户导出excel是否成功
            return JsonUtil.toString("Y", "操作成功！");
        }else {
            Constants.pubMap.put(UserUtil.getUserId() + "batchExportExce", true);//记录公共变量当前用户导出excel是否成功
            return JsonUtil.toString("N", "无数据！");
        }
    }

    /**
     * @Author SunChang
     * @Date 2018/9/10 17:00
     * @param request
    * @param response
     * @Description 检测是否有数据
     */
    @RequestMapping(value = "/car/batchExport/export/isData", method = RequestMethod.GET)
    @ResponseBody
    public Object checkIsData(HttpServletRequest request, HttpServletResponse response) {
        String dateStr = request.getParameter("dateStr");
        String[] dates = dateStr.split(" ~ ");
        List<TblFileBean> fileBeans = fileHandler.queryByHql("FROM TblFile t where t.status = ? and date_format(t.uploadDate, '%Y-%m-%d') BETWEEN ? and ?", "1", dates[0], dates[1]);
        if(null != fileBeans && fileBeans.size() > 0) {
            return JsonUtil.toString("Y", "操作成功！");
        }else {
            return JsonUtil.toString("N", "无数据！");
        }
    }

    /**
     * @Author SunChang
     * @Date 2018/9/10 16:05
     * @param request
    * @param response
     * @Description 获取下载结果，做用户体验
     */
    @RequestMapping(value = "/car/batchExport/export/exportRes", method = RequestMethod.GET)
    @ResponseBody
    public Object getBatchExportRes(HttpServletRequest request, HttpServletResponse response) {
        boolean res = (boolean) Constants.pubMap.get(UserUtil.getUserId() + "batchExportExce");
        if(res) {
            Constants.pubMap.remove(UserUtil.getUserId() + "batchExportExce");
            return JsonUtil.toString("Y", "操作成功！");
        }else {
            return JsonUtil.toString("N", "无结果");
        }
    }
}
