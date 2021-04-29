<%@ page import="com.zhangkai.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/13
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="header.jsp"%>
<head>
    <title>userinfo</title>
</head>
<body>
<%--<%--%>
<%--    Cookie [] allCookies=request.getCookies();--%>
<%--    for(Cookie c:allCookies){--%>
<%--        out.println("<br>"+c.getName()+"---"+c.getValue());--%>
<%--    }--%>
<%--%>--%>
<%  user= (User) session.getAttribute("user");
%>
<table>
    <tr><td>Username:</td><td><%=user.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=user.getPassword()%></td></tr>
    <tr><td>email:</td><td><%=user.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=user.getGender()%></td></tr>
    <tr><td>Birth Date:</td><td><%=user.getBirthdate()%></td></tr>
    <tr><a href="${pageContext.request.contextPath}/update">Update User</a></tr>
</table>
<%@include file="footer.jsp"%>
</body>
</html>
