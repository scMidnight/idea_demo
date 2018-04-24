<%--
  Created by IntelliJ IDEA.
  User: SunChang
  Date: 2018/4/24
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session示例</title>
</head>
<body>
session的唯一标识：<%= session.getId()%><br/>
session的创建时间：<%= new java.util.Date(session.getCreationTime()).toString() %><br/>
session的最后访问时间：<%= new java.util.Date(session.getLastAccessedTime()).toString() %><br/>
session的失效时间(s)：<%= session.getMaxInactiveInterval()%><br/>
</body>
</html>
