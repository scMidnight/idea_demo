package person.util;

import jodd.util.StringUtil;
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

import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SunChang on 2018/9/6
 */
public class MobileFromUtil {

    /**
     * @Author SunChang
     * @Date 2018/9/6 11:11
     * @param mobileNumber
     * @Description 获取手机号归属地
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
                                result = node1.childNode(4).childNode(0).attr("value");
                            }
                            //result = element.childNode(1).childNode(4).childNode(2).childNode(1).toString();
                            //for (Element element : elements) {
                            //    System.out.println("===================================================");
                            //    System.out.println(element.toString());
                            //}
                        }
                        //result = htmlSource;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) throws MalformedURLException {
        System.out.println(getMobileFrom("18286809527"));
    }
}
