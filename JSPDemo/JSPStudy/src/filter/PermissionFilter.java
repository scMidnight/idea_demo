package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by SunChang on 2018/8/18
 */
public class PermissionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String servletPath = req.getServletPath();
        HttpSession session = req.getSession();
        String flag = (String) session.getAttribute("flag");
        if(servletPath != null && (servletPath.equals("/servletLogin3/login.jsp") || (servletPath.equals("/servletLogin3/index.jsp")) || (servletPath.equals("/loginServlet3")))) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            if(flag != null && flag.equals("login_success")) {
                filterChain.doFilter(servletRequest, servletResponse);
            }else if(flag != null && flag.equals("login_error")) {
                req.setAttribute("msg", "登录失败，请重新登录！！<br />");
                req.setAttribute("return_uri", servletPath);
                RequestDispatcher rd = req.getRequestDispatcher("/servletLogin3/login.jsp");
                rd.forward(req, resp);
            }else {
                req.setAttribute("msg", "您尚未登录！");
                req.setAttribute("return_uri", servletPath);
                RequestDispatcher rd = req.getRequestDispatcher("/servletLogin3/login.jsp");
                rd.forward(req, resp);
            }
        }


    }

    @Override
    public void destroy() {

    }
}
