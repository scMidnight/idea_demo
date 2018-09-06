package com.car.web.utils;

import jodd.util.StringUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SunChang on 2018/8/30
 */
public class TxtUtil {

    /**
     * @Author SunChang
     * @Date 2018/8/30 16:54
     * @param
     * @Description 读取txt文件内容
     */
    public static StringBuilder readTxt() throws IOException {
        String path = TxtUtil.class.getClassLoader().getResource("blackList.txt").getPath();
        BufferedReader br=new BufferedReader(new FileReader(path));
        StringBuilder str = new StringBuilder();
        String r = br.readLine();
        while(r != null) {
            str.append(r).append("\r\n");
            r = br.readLine();
        }
        return str;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 19:09
     * @param
     * @Description 读取txt内容到list
     */
    public static List<String> readTxtToList() throws IOException {
        List<String> list = new ArrayList<String>();
        String path = TxtUtil.class.getClassLoader().getResource("blackList.txt").getPath();
        BufferedReader br=new BufferedReader(new FileReader(path));
        StringBuilder str = new StringBuilder();
        String r = br.readLine();
        while(r != null) {
            list.add(r);
            r = br.readLine();
        }
        return list;
    }

    /**
     * @Author SunChang
     * @Date 2018/8/30 16:54
     * @param
     * @Description 计算有多少行
     */
    public static int lineNum(StringBuilder sb) {
        if(StringUtil.isNotBlank(sb.toString())) {
            String[] strArr = sb.toString().split("\n");
            return strArr.length;
        }else {
            return 0;
        }
    }

    public static void writeTxt(String content) throws IOException {
        String path = TxtUtil.class.getClassLoader().getResource("blackList.txt").getPath();
        File file = new File(path);
        file.createNewFile();  //创建新文件
        PrintWriter fw = new PrintWriter(file);
        BufferedWriter out = new BufferedWriter(fw);
        if(StringUtil.isNotBlank(content)) {
            String[] strArr = content.split("\n");
            for (int i = 0; i < strArr.length; i++) {
                fw.write(strArr[i] + "\r\n");
            }
        }else {
            fw.write("");
        }
        fw.flush(); // 把缓存区内容压入文件
        fw.close(); // 最后记得关闭文件
    }

    public static void main(String[] args) {
        try {
            writeTxt("123\n12");
            StringBuilder str = readTxt();
            System.out.println(str);
        } catch (IOException e) {
            System.err.println("出错了");
        }
    }
}
