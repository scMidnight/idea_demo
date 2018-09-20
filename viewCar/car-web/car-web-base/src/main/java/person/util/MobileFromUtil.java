package person.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jodd.util.StringUtil;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SunChang on 2018/9/6
 */
public class MobileFromUtil {

    public static String getMobileFromBd(String mobileNumber) {
        //百度的API地址
        String urlString = "http://mobsec-dianhua.baidu.com/dianhua_api/open/location?tel=" + mobileNumber;
        StringBuilder sb = new StringBuilder();
        BufferedReader buffer;
        String provinces = "";//省
        String city = "";//城市
        String operators = "";//运营商
        try {
            URL url = new URL(urlString);
            //获取URL地址中的页面内容
            InputStream in = url.openStream();
            // 解决乱码问题
            buffer = new BufferedReader(new InputStreamReader(in, "utf8"));
            String line = null;
            //一行一行的读取数据
            while ((line = buffer.readLine()) != null) {
                sb.append(line);
            }
            in.close();
            buffer.close();
            //1、使用JSONObject
            JsonObject jsonStr = new Gson().fromJson(sb.toString(), JsonObject.class);
            if(!jsonStr.get("response").getAsJsonObject().get(mobileNumber).isJsonNull()) {
                city = jsonStr.get("response").getAsJsonObject().get(mobileNumber).getAsJsonObject().get("detail").getAsJsonObject().get("area").getAsJsonArray().get(0).getAsJsonObject().get("city").getAsString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    /**
     * @Author SunChang
     * @Date 2018/9/6 11:11
     * @param mobileNumber
     * @Description 获取手机号归属地 ip138的，使用一段时间后特别慢。
     */
    public static String getMobileFrom(String mobileNumber) throws MalformedURLException {
        HttpClient client=null;
        GetMethod method=null;
        int httpStatusCode;
        String htmlSource=null;
        String result=null;
        try {
            client=new HttpClient();
            client.getHostConfiguration().setHost("www.ip138.com", 8080, "http");
            method = new GetMethod("/search.asp?mobile=" + mobileNumber + "&action=mobile");
            client.executeMethod(method);
            httpStatusCode=method.getStatusLine().getStatusCode();
            if(httpStatusCode!=200){
                throw new Exception("网页内容获取异常！Http Status Code:"+httpStatusCode);
            }
            htmlSource = new String(method.getResponseBodyAsString().getBytes("ISO-8859-1"),"gbk");
            if(htmlSource!=null&&!htmlSource.equals("")){
                if(StringUtil.isNotBlank(htmlSource)) {
                    Document doc = Jsoup.parse(htmlSource);
                    if(doc != null) {
                        Elements elements = doc.getElementsByTag("table");// 通过tag标签获取元素
                        if (null != elements && elements.size() > 0) {
                            Element element = elements.get(1);
                            Node node = element.childNode(1);
                            Node node1 = node.childNode(4);
                            if(node1.childNodeSize() == 4) {
                                result = node1.childNode(2).childNode(1).toString();
                            }else if(node1.childNodeSize() == 6) {
                                result = node1.childNode(4).childNode(0).toString();
                            }else if(node1.childNodeSize() == 5) {
                                result = node1.childNode(3).childNode(0).toString();
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) throws MalformedURLException {
        //System.out.println(getMobileFrom("18286809527"));
        System.out.println(getMobileFromBd("17364401868"));
    }
}
