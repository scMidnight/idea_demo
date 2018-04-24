<%--
  Created by IntelliJ IDEA.
  User: SunChang
  Date: 2018/4/24
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎页面</title>
</head>
<body>
<%if(session.getAttribute("userName") != null){ %>
    欢迎：<%= session.getAttribute("userName")%>
    <a href="logout.jsp">注销</a>
    <br/>
<%}else{%>
    请先登录
    <a href="login.jsp">登录</a>
<%}%>
<%if(session.isNew()){%><%-- session.isNew()是判断session是否为新创建的session --%>
    <br/>
    欢迎新用户！
<%}else{%>
  欢迎老用户！
<%}%>
</body>
</html>
