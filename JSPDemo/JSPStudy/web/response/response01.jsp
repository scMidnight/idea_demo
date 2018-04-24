<%--
  Created by IntelliJ IDEA.
  User: SunChang
  Date: 2018/4/24
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>response对象示例01</title>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache");
    response.setIntHeader("Refresh", 2);
    out.println("data is " + new java.util.Date().toString() + "<br />");
%>
</body>
</html>
