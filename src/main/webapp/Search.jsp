<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/9
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1><%= "Welcome to My online shop Home Page" %>
</h1>
<br>
<form method="get" action="${pageContext.request.contextPath}/SearchServlet">
    <input type="text" name="txt" size="30">
    <select name="search">
        <option value="baidu">baidu</option>
        <option value="bing">bing</option>
        <option value="google">google</option>
    </select>
    <input type="submit" value="search">
</form>
<%@include file="footer.jsp"%>
</body>
</html>
