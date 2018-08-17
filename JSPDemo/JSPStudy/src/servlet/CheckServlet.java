package servlet;

import com.mysql.jdbc.StringUtils;
import entity.User;
import service.CheckUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckServlet extends HttpServlet {
    private CheckUserService cku = new CheckUserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("uname");
        String password = req.getParameter("upwd");
        String forward = null;
        RequestDispatcher rd = null;
        if(userName == null || password == null) {
            req.setAttribute("msg", "用户名或密码为空");
            rd = req.getRequestDispatcher("/servletLogin1/error.jsp");
            rd.forward(req, resp);
        }else {
            User user = new User();
            user.setName(userName);
            user.setPassword(password);
            boolean bool = cku.check(user);
            if(bool) {
                forward = "/servletLogin1/success.jsp";
            }else {
                req.setAttribute("msg", "用户名或密码输入错误");
                forward = "/servletLogin1/error.jsp";
            }
            rd = req.getRequestDispatcher(forward);
            rd.forward(req, resp);
        }
    }
}
