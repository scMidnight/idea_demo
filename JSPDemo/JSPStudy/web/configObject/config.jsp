<%--
  Created by IntelliJ IDEA.
  User: SunChang
  Date: 2018/4/24
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>config对象示例</title>
</head>
<body>
用户名：<%= config.getInitParameter("username")%><br/>
密码：<%= config.getInitParameter("password")%><br/>
</body>
</html>
