package com.car.web.controller.offLine;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import person.util.PropertyUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
线下潜客筛选--目标潜客筛选
 */
@Controller
@RequestMapping(value = "/filter")
public class OffLineFilter {

    /**
     * @Author SunChang
     * @Date 2018/8/28 18:58
     * @param request
    * @param map
     * @Description 目标潜客筛选
     */
    @RequestMapping(method = RequestMethod.GET)
    public String offLineFilterGet(HttpServletRequest request, ModelMap map) throws Exception {
        //UserUtil - 获取当前登录用户的工具类
        return "/offLine/offLineClient/add";
    }

    /**
     * @Author SunChang
     * @Date 2018/8/28 18:58
     * @param request
    * @param map
     * @Description 文件下载
     */
    @RequestMapping(value = "/downFile")
    public void downFile(HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            String filePath = PropertyUtil.getProperty("offLineClientFilter.downloadFilePath");
            String fileName = PropertyUtil.getProperty("offLineClientFilter.downloadSourceFileName");
            String targetName = PropertyUtil.getProperty("offLineClientFilter.downloadTargetFileName");
            String fileNameCn = new String(targetName.getBytes("gbk"), "iso-8859-1");
            File file  = new File(filePath,fileName);
            if(file.exists()){
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileNameCn+".zip");// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    response.getOutputStream().flush();
                }catch(Exception e){
                    e.printStackTrace();
                }finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
