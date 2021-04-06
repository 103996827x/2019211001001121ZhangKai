<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1><%= "My Homework" %>
</h1>
<br/>
<a href="Myjsp.jsp">This is Myjsp</a>
</br>
<a href="register.jsp">This is register</a>
</br>
<a href="login.jsp">This is login</a>
<%@include file="footer.jsp"%>
</body>
</html>