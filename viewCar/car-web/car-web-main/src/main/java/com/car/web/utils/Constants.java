package com.car.web.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static Map<String, Object> pubMap = new HashMap<String, Object>();

    public static String getRootPath(){
        String osName=System.getProperty("os.name");
        if(osName.toUpperCase().startsWith("WIN")){
            return "D:/car/uploader/";
        }
        return "/usr/local/uploader/";
    }
}
