package person.util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by SunChang on 2018/8/28
 */
public class UpOrDownloadUtil {
    /**
     * @Author: SunChang
     * @MethodName: saveFile
     * @Description: 保存文件
     * @Params:  * @param filePath
     * @param data
     * @Return: void
     * @Date: 16:40 2017/9/13
     */
    public void saveFile(String filePath, byte[] data) throws Exception {
        if(data != null) {
            File file = new File(filePath);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data, 0, data.length);
            fos.flush();
            fos.close();
        }
    }

    /**
     * @Author: SunChang
     * @MethodName: inputByte
     * @Description: 得到byte[]流
     * @Params:  * @param inStream
     * @Return: byte[]
     * @Date: 18:06 2017/9/15
     */
    public byte[] inputByte(InputStream inStream) throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }

    /**
     * @Author: SunChang
     * @MethodName: getRandomFileName
     * @Description: 生成随机文件名：五位随机数+当前年月日时分秒毫秒
     * @Params:  * @param
     * @Return: java.lang.String
     * @Date: 16:42 2017/9/13
     */
    public static String getRandomFileName() {
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
        return rannum + str;// 当前时间
    }


}
