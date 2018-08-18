package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SunChang on 2018/8/18
 */
public class LoginServlet3 extends HttpServlet {
    public LoginServlet3() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String passwd = req.getParameter("upwd");
        String returnUri = req.getParameter("return_uri");

        System.out.println("用户名 ==》 " + uname);
        System.out.println("密码 ==》 " + passwd);
        System.out.println("return uri ==》 " + returnUri);

        RequestDispatcher rd = null;
        if(uname == null || passwd == null) {
            req.setAttribute("msg", "用户名或者密码为空！");
            rd = req.getRequestDispatcher("/servletLogin3/login.jsp");
            rd.forward(req,resp);
        }else {
            if(uname.equals("学习") && passwd.equals("123456")) {
                req.getSession().setAttribute("flag", "login_success");
                if(returnUri != null) {
                    rd = req.getRequestDispatcher(returnUri);
                    rd.forward(req,resp);
                }else {
                    rd = req.getRequestDispatcher("/servletLogin3/index.jsp");
                    rd.forward(req, resp);
                }
            }else {
                req.getSession().setAttribute("flag", "login_eroor");
                req.setAttribute("msg", "用户名或密码输入错误！");
                rd = req.getRequestDispatcher("/servletLogin3/login.jsp");
                rd.forward(req,resp);
            }
        }
    }
}
