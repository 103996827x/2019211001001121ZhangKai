<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/28
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        body {
            background-color: #ffffff;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }

        .register {
            margin-top: 50px;
        }

        .register form {
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

        .gender {
            width: 50px;
        }

        #submit {
            background-color: #e3901d;
            width: 100px;
        }
    </style>
</head>
<body>
<%@include file="header.jsp" %>
<% User u = (User) session.getAttribute("user");%>
<div class="register">
    <form method="post" action="${pageContext.request.contextPath}/update">
        <input type="hidden" name="id" value="<%=u.getId()%>">
        <input name="username" type="text" placeholder="username" id="username" value="<%=u.getUsername()%>">
        <div>
            <input name="password" type="text" placeholder="password" id="password" value="<%=u.getPassword()%>">
        </div>
        <input name="email" type="text" placeholder="email" id="email" value="<%=u.getEmail()%>">
        <div>Gender:<input type="radio" style="height: 10px" class="gender" value="male" name="selfValidateType"
                           checked="true" <%="male".equals(u.getGender())?"checked":""%>> male
            <input type="radio" style="height: 10px" class="gender" value="famale" name="selfValidateType"
                   checked="false" <%="female".equals(u.getGender())?"checked":""%>>female
        </div>
        <input name="date" type="text" placeholder="Date of Birth(yyyy-mm-dd)" id="date" value="<%=u.getBirthdate()%>">
        <input type="submit" value="update">
    </form>

</div>
<%@include file="footer.jsp" %>
</body>
<script src="WEB-INF/register.js"></script>
</html>
