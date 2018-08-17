package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        String userName = req.getParameter("uname");
        String password = req.getParameter("upwd");
        System.out.println("用户名 ==》 " + userName);
        System.out.println("密码 ==》 " + password);
        String forward = null;
        if(userName.equals("test")) {
            //resp.sendRedirect(req.getContextPath() + "/servletLogin/success.jsp");
            forward = "/servletLogin/success.jsp";
            RequestDispatcher rd = req.getRequestDispatcher(forward);
            rd.forward(req,resp);
        }else {
            //resp.sendRedirect(req.getContextPath() + "/servletLogin/error.jsp");
            forward = "/servletLogin/error.jsp";
            RequestDispatcher rd = req.getRequestDispatcher(forward);
            rd.forward(req,resp);
        }
    }
}
