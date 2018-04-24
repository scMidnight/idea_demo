<%--
  Created by IntelliJ IDEA.
  User: SunChang
  Date: 2018/4/24
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@page buffer="10kb" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.println("test1");//println在页面上看不到换行效果
    out.print("test2");
    out.newLine();//也是输出一个换行，在页面上看不到换行效果
    out.println("<br />");
    out.flush();//强制刷新服务器输出缓冲区中的数据
    //out.clearBuffer();//清空缓冲区数据
    out.clear();//清空缓冲区数据，如果在它之前调用flush方法再调用clear则报错
    //out 对转对象对输出缓冲区进行管理，默认缓冲区大小8KB，可以设置缓冲区大小
    out.println("获取当前缓冲区大小：" + out.getBufferSize());
    out.println("<br />");
    out.println("当前缓冲区剩余字节数目：" + out.getRemaining());
%>
</body>
</html>
