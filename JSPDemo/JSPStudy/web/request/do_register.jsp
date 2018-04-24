<%--
  Created by IntelliJ IDEA.
  User: SunChang
  Date: 2018/4/24
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userName = request.getParameter("userName");
    String skills = "";
    String[] skillArr = request.getParameterValues("skills");
    if(skillArr != null && skillArr.length > 0) {
        for (String s : skillArr) {
            skills = skills + s + " ";
        }
    }
    request.setAttribute("userName", userName);
    request.setAttribute("skills", skills);
%>
<jsp:forward page="welcome.jsp"></jsp:forward>