<%--
  Created by IntelliJ IDEA.
  User: SunChang
  Date: 2018/4/24
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>response对象示例03</title>
</head>
<body>
<%
    Cookie myCookie = new Cookie("root", "00000000");
    myCookie.setMaxAge(3600);//3600秒
    response.addCookie(myCookie);
%>
</body>
</html>
