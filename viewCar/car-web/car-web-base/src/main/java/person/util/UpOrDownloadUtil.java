package person.util;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by SunChang on 2018/8/28
 */
public class UpOrDownloadUtil {
    private static String[] IEBrowserSignals = {"MSIE", "Trident", "Edge"};//request中header中的user-agent的关键字判断浏览器
    /**
     * @Author: SunChang
     * @MethodName: isMSBrowser
     * @Description: 判断是什么浏览器，如果是微软浏览器，则true
     * @Params:  * @param request
     * @Return: boolean
     * @Date: 17:03 2017/9/22
     */
    public static boolean isMSBrowser(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        for (String signal : IEBrowserSignals) {
            if (userAgent.contains(signal))
                return true;
        }
        return false;
    }

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

    public void downLodaCarExcel(String fileName, HttpServletRequest request, HttpServletResponse response, InputStream sbs) {
        boolean isIe = isMSBrowser(request);
        OutputStream os = null;
        try {
            if(isIe) {
                fileName = URLEncoder.encode(fileName, "utf-8");
                if(fileName.contains("+")) {
                    fileName = fileName.replace("+","%20");//encode后空格会变+号，而%20是utf-8的加号编码
                }
                if(fileName.length() > 150) {
                    fileName = new String(fileName.getBytes("GB2312"), "ISO8859-1");
                    fileName = StringUtils.replace(fileName, " ", "%20");
                }
            } else {
                fileName = new String(fileName.getBytes("GB2312"), "ISO8859-1");
            }
            //response.reset();//清空response,暂且可不用;
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=\"" + fileName + "\"");
            os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = sbs.read(b)) > 0) {
                os.write(b, 0, length);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                sbs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}