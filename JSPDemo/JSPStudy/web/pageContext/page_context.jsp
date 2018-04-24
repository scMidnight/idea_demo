<%--
  Created by IntelliJ IDEA.
  User: SunChang
  Date: 2018/4/24
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext对象示例</title>
</head>
<body>
<%
    JspWriter myOut = pageContext.getOut();
    myOut.println("hello world");
    pageContext.setAttribute("root", "000000", pageContext.SESSION_SCOPE);//设置键值对，存放到session范围中，也可以存放到其他内置对象中。
    String value = session.getAttribute("root").toString();
    out.println(value);
    out.println("<br/>");
%>
</body>
</html>
