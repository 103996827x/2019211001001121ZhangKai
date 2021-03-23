<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/16
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <style type="text/css">
      body{
         background-color: #ffffff;
         display: flex;
         flex-direction: row;
         justify-content: center;
      }
      .register{
         margin-top: 50px;
      }
      .register form{
         display: flex;
         flex-direction: column;
         justify-content: flex-start;
      }
      input{
         outline: none;
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
      #submit{
         background-color: #e3901d;
         width: 100px;
      }
   </style>

</head>
<body>

   <div class="register">
   <form method="post" action="${pageContext.request.contextPath}/RegisterServlet">
        <h1> New User registration</h1>
       <input name="username" type="text" placeholder="username" id="username" >
       <div><input name="password" type="text" placeholder="password" id="password"> <span id="tip">length must be at least 8 characters</span></div>
       <input name="email" type="text" placeholder="email" id="email" >
       <div> Gender:<input type="radio" style="height: 10px" class="gender" value="male" name="selfValidateType" checked="true"> Male
          <input type="radio" style="height: 10px" class="gender" value="famale" name="selfValidateType" checked="false">Female </div>
       <input name="date" type="text" placeholder="Date of Birth(yyyy-mm-dd)" id="date" >
       <input type="submit" value="Register" id="submit">
   </form>
   </div>
</body>
<script src="register.js"></script>
</html>
