<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/16
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
    </style>
    <title>Myjsp</title>
</head>
<body>
<a href="http://www.ecjtu.jx.cn/">go to ecjtu</a>
<form method="post" action="${pageContext.request.contextPath}/HelloWorldServlet">
    Name:<input type="text" name="name"><br/>
    ID:<input type="text" name="id"><br/>
    <input type="submit" value="Send data to server">
</form>
</body>
</html>
