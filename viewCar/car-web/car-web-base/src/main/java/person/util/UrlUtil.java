package person.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SunChang on 2018/8/24
 */
public class UrlUtil {
    public static String buildRequestUrl(HttpServletRequest r) {
        return buildRequestUrl(r.getServletPath(), r.getRequestURI(),
                r.getContextPath(), r.getPathInfo(), r.getQueryString());
    }

    private static String buildRequestUrl(String servletPath,
                                          String requestURI, String contextPath, String pathInfo,
                                          String queryString) {
        StringBuilder url = new StringBuilder();
        if (servletPath != null) {
            url.append(servletPath);
            if (pathInfo != null)
                url.append(pathInfo);
        } else {
            url.append(requestURI.substring(contextPath.length()));
        }
        return url.toString();
    }
}
