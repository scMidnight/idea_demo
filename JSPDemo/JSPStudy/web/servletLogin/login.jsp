<%--
  Created by IntelliJ IDEA.
  User: SunChang
  Date: 2018/8/17
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="<%= request.getContextPath()%>/loginServlet" method="post">
        userName:<input type="text" name="uname" /> <br />
        password:<input type="password" name="upwd" id="" /> <br/>
        <input type="submit" value="Login" />
        <input type="reset" value="Reset" />
    </form>
</body>
</html>
