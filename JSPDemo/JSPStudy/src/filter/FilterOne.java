package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by SunChang on 2018/8/18
 */
public class FilterOne implements Filter {

    public FilterOne() {
        System.out.println("============== FilterOne 构造函数================");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("============== FilterOne 初始化方法================");
        String initParam = filterConfig.getInitParameter("param");
        System.out.println("param == " + initParam);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("============== FilterOne 开始执行doFilter方法================");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("============== FilterOne 结束执行doFilter方法================");
    }

    @Override
    public void destroy() {
        System.out.println("============== FilterOne 销毁方法================");
    }
}
