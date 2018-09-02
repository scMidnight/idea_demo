package com.car.web.utils;

public class Constants {
    public static String getRootPath(){
        String osName=System.getProperty("os.name");
        if(osName.toUpperCase().startsWith("WIN")){
            return "D:/car/uploader/";
        }
        return "/usr/local/uploader/";
    }
}
