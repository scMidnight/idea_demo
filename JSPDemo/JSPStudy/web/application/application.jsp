<%--
  Created by IntelliJ IDEA.
  User: SunChang
  Date: 2018/4/24
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>application对象示例</title>
</head>
<body>
当前服务器信息：<%= application.getServerInfo()%><br/>
当前应用名称：<%= application.getServletContextName()%><br/><%-- 返回的是应用程序部署描述符web.xml中的display-name --%>
主机名称：<%= application.getVirtualServerName()%><br/>
</body>
</html>
