<%--
  Created by IntelliJ IDEA.
  User: SunChang
  Date: 2018/8/18
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
首页
<br>
<br>
<a href="<%= request.getContextPath() %>/servletLogin3/hello.jsp">hello.jsp</a><br>
<%
    String flag = "";
    Object obj = session.getAttribute("flag");
    if(obj != null) {
        flag = obj.toString();
    }
    if(flag.equals("login_success")) {
%>
    <a href="<%= request.getContextPath() %>/servletLogout3">退出</a>
<%}else{%>
    <a href="<%= request.getContextPath() %>/servletLogin3/login.jsp">登录</a>
<%}%>
</body>
</html>
