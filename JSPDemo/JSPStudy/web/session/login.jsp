<%--
  Created by IntelliJ IDEA.
  User: SunChang
  Date: 2018/4/24
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录表单</title>
</head>
<body>
<form action="do_login.jsp" method="post">
    userName:<input type="text" name="userName" />
    passWord:<input type="password" name="passWord" />
    <input type="submit" value="submit" />
    <input type="reset" name="reset" />

</form>
</body>
</html>
