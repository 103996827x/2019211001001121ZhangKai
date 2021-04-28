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
        body{
            background-color: #ffffff;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }
        .login{
            margin-top: 50px;
        }
        .login form{
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
        }
        input{
            outline: none;
            width: 200px;
            height: 30px;
            border-radius: 5px;
            border: 1px solid rgb(209,209,209);
            background-color: #eeeee7;
            margin-bottom: 25px;
        }
        input::-webkit-input-placeholder{
            font-size: 15px;
            position: relative;
            left: 10px;
        }
        .remember{
            display: flex;
            flex-direction: row;
            justify-content: flex-start;
        }
        #submit{
            background-color: #e3901d;
            width: 100px;
        }
    </style>
</head>
<body>
<h1>Login</h1>

<%
Cookie[] allcookies=request.getCookies();
String username="";
String password="";
String rememberMeVale="";
if(allcookies!=null) {
    for (Cookie c : allcookies) {
        if (c.getName().equals("cUsername")) {
            username = c.getValue();
        }
        if (c.getName().equals("cPassword")) {
            password = c.getValue();
        }
        if (c.getName().equals("cRememberMe")) {
            rememberMeVale = c.getValue();
        }
    }
}
%>
<%@include file="header.jsp"%>
<%
    if (!(request.getAttribute("message")==null)){
        out.print("<h3>"+request.getAttribute("message")+"</h3>");
    }
%>
<div class="login">
    <form method="post" action="${pageContext.request.contextPath}/LoginServlet">
        <h1> New User registration</h1>
        <input name="username" type="text" placeholder="username" id="username" >
        <div><input name="password" type="text" placeholder="password" id="password"> </div>
        <div class="remember"><input type="checkbox" style="width: 20px ;height: 20px;margin-right: 15px" value="1" name="rememberme" <%=rememberMeVale.equals("1")?"checked":""%>>Remember me</div>
        <input type="submit" value="Register" id="submit">
    </form>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
