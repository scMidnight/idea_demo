package com.car.web.utils;

import java.io.*;

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
            str.append(r).append("\n");
            r = br.readLine();
        }
        return str;
    }

    public static void writeTxt() throws IOException {
        String path = TxtUtil.class.getClassLoader().getResource("blackList.txt").getPath();
        File file = new File(path);
        file.createNewFile();  //创建新文件
        PrintWriter fw = new PrintWriter(file);
        BufferedWriter out = new BufferedWriter(fw);
        for (int i = 0; i < 2; i++) {
            fw.write("我会写入文件啦\r\n"); // \r\n即为换行
        }
        fw.flush(); // 把缓存区内容压入文件
        fw.close(); // 最后记得关闭文件
    }

    public static void main(String[] args) {
        try {
            writeTxt();
            StringBuilder str = readTxt();
            System.out.println(str);
        } catch (IOException e) {
            System.err.println("出错了");
        }
    }
}
