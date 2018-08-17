<%--
  Created by IntelliJ IDEA.
  User: SunChang
  Date: 2018/8/17
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录错误页面</title>
</head>
<body>
登录失败。<br>
您提交的信息为：<br>
用户名：<%=request.getParameter("uname")%><br>
密码：<%=request.getParameter("upwd")%><br>
<a href="<%= request.getContextPath() %>/servletLogin/login.jsp">返回登录页面</a>
</body>
</html>
