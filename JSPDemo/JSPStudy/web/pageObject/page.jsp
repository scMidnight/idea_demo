<%--
  Created by IntelliJ IDEA.
  User: SunChang
  Date: 2018/4/24
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>page对象示例</title>
</head>
<body>
<%
    out.println("page对象的字符串：" + page.toString() + "<br/>");
    out.println("当前object类：" + page.getClass() + "<br/>");
    out.println("当前类的hashCode值：" + page.hashCode() + "<br/>");
%>
</body>
</html>
