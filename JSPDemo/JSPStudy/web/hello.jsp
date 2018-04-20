<%--
  Created by IntelliJ IDEA.
  User: SunChang
  Date: 2018/4/20
  Time: 23:41
  To change this template use File | Settings | FiTemplatesle .
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
JSP表达式输出：<%="hello world"%>
<br />
<%
    String str = "hello world";
    out.println(str);
%>
</body>
</html>
