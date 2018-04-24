<%--
  Created by IntelliJ IDEA.
  User: SunChang
  Date: 2018/4/24
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册信息处理</title>
</head>
<body>
<jsp:useBean id="user" class="entity.UserEntity"></jsp:useBean>
<jsp:setProperty name="user" property="userName"></jsp:setProperty>
<jsp:setProperty name="user" property="passWord"></jsp:setProperty>
<%
    String userName = request.getParameter("userName");
    String passWord = request.getParameter("passWord");
    out.print(userName);
    out.print("<br />");
    out.print(passWord);
%>
<br/>
<jsp:getProperty name="user" property="userName"></jsp:getProperty>
<jsp:getProperty name="user" property="passWord"></jsp:getProperty>
</body>
</html>
