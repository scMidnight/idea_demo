package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by SunChang on 2018/8/18
 */
public class EncodingFilter implements Filter {
    private String charEncoding = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        charEncoding = filterConfig.getInitParameter("encoding");
        if(charEncoding == null) {
            throw new ServletException("EncodingFilter中的编码设置为空！");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(!charEncoding.equals(servletRequest.getCharacterEncoding())) {
            servletRequest.setCharacterEncoding(charEncoding);
        }
        servletResponse.setCharacterEncoding(charEncoding);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
