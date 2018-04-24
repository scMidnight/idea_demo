<%--
  Created by IntelliJ IDEA.
  User: SunChang
  Date: 2018/4/24
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>异常处理</title>
</head>
<body>
<%out.println("异常描述信息：" + exception.getMessage());%>
<br/>
<%
    out.println("exception对象的字符串描述：" + exception.toString());
%>
<br/>
<%
    exception.printStackTrace();
%>
</body>
</html>
