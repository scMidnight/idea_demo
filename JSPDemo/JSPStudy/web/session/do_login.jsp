<%--
  Created by IntelliJ IDEA.
  User: SunChang
  Date: 2018/4/24
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userName = request.getParameter("userName");
    String passWord = request.getParameter("passWord");
    if(userName != null && passWord != null) {
        session.setAttribute("userName", userName);
        response.setHeader("refresh", "2;URL=welcome.jsp");
    }
%>
