package person;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by SunChang on 2018/8/22
 * 防sql注入拦截器
 */
public class SqlInjectionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Enumeration<?> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();

            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() == 0) {

                    continue;
                }
                System.out.println("参数：" + paramName + "=" + paramValue);

                // 转义 二选一
                request.setAttribute(paramName, clearXss(paramValue));

                // 跳页 二选一
                if (containsSensitiveWords(paramValue)) {
                    request.setAttribute("paramName", paramName);
                    request.setAttribute("paramValue", paramValue);
                    response.sendRedirect("");
                    return false;
                }
            }
        }
        return true;
    }

    /***
     * 判断参数是否含有敏感词汇
     *
     * @param paramValue
     * @return
     */
    private boolean containsSensitiveWords(String paramValue) {

        return false;
    }
    /***
     * 处理字符转义
     *
     * @param value
     * @return
     */
    private String clearXss(String value) {
        if (value == null || "".equals(value)) {
            return value;
        }
        value = value.replaceAll("<", "<").replaceAll(">", ">");
        value = value.replaceAll("\\(", "(").replace("\\)", ")");
        value = value.replaceAll("'", "'");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replace("script", "");
        return value;
    }
}
