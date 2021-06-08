<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/6
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style type="text/css">
        body {
            background-color: #ffffff;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }

        .login {
            margin-top: 50px;
        }

        .login form {
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
        }

        input {
            outline: none;
            width: 200px;
            height: 30px;
            border-radius: 5px;
            border: 1px solid rgb(209, 209, 209);
            background-color: #eeeee7;
            margin-bottom: 25px;
        }

        input::-webkit-input-placeholder {
            font-size: 15px;
            position: relative;
            left: 10px;
        }

        #submit {
            background-color: #e3901d;
            width: 100px;
        }
    </style>
</head>
<body>
<%@include file="header.jsp" %>
<div class="login">
    <form method="post" action="${pageContext.request.contextPath}/LoginServlet">
        <h1> New User registration</h1>
        <input name="username" type="text" placeholder="username" id="username">
        <div><input name="password" type="text" placeholder="password" id="password"></div>
        <input type="submit" value="Register" id="submit">
    </form>
</div>

<%@include file="footer.jsp" %>
</body>
</html>
