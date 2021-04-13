<%--<%@include file="header.jsp"%>--%>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/12
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<table  border="1" >
    <tr>
        <td>id</td>
        <td>username</td>
        <td>password</td>
        <td>email</td>
        <td>gender</td>
        <td>birthdate</td>
    </tr>
    <%
        ResultSet rs=(ResultSet) request.getAttribute("rsname");
        System.out.println(rs);
        if(rs==null){
        %>
    <tr>
        <td>no data</td>
    </tr>
    <%}else {
        while (rs.next()) {
            out.print("<tr>");
            out.println("<td>" + rs.getObject("id") + "</td>");
            out.println("<td>" + rs.getObject("username") + "</td>");
            out.println("<td>" + rs.getObject("password") + "</td>");
            out.println("<td>" + rs.getObject("email") + "</td>");
            out.println("<td>" + rs.getObject("gender") + "</td>");
            out.println("<td>" + rs.getObject("birthdate") + "</td>");
            out.print("</tr>");
        }

    }
        %>
</table>

</body>
</html>
