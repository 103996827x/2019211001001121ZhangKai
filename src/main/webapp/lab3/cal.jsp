<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/17
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="../js/jquery.js"></script>
<script>
    function checkNum() {
        var cheknum = /^[0-9]+.?[0-9]*$/;
        if (!cheknum.test($('#firstVal').val())) {
            alert("First val is not a number");
            return false;
        }
        if (!cheknum.test($('#secondVal').val())) {
            alert("Second val is not a number");
            return false;
        }
        return true;
    }

    function checkString() {
        var checkstring = /\d/;
        if (checkstring.test($('#name').val())) {
            alert("Name is not valid");
            return false;
        }
        return true;
    }

    $(function () {
        $("#add").on('click', (function () {
            $("#hidden").attr("value", "add");
            if (checkNum()) {
                $('#myForm').submit();
            }
        }))
    })

    $(function () {
        $('#subtract').click(function () {
            $('#hidden').attr("value", "subtract");
            if (checkNum()) {
                $('#myForm').submit();
            }
        })
    })
    $(function () {
        $('#multiply').click(function () {
            $('#hidden').attr("value", "multiply");
            if (checkNum()) {
                $('#myForm').submit();
            }
        })
    })
    $(function () {
        $('#divide').click(function () {
            $('#hidden').attr("value", "divide");
            if (checkNum()) {
                $('#myForm').submit();
            }
        })
    })
    $(function () {
        $('#computeLength').click(function () {
            $('#hidden').attr("value", "computeLength");
            if (checkString()) {
                $('#myForm').submit();
            }
        })
    })

    $(function () {
        $('#reset').click(function () {
            $('#firstVal').attr("value", "");
            $('#secondVal').attr("value", "");
            $('#name').attr("value", "");
            $('#length').attr("value", "");
            $('#result').attr("value", "");
            $('#hidden').attr("value", "");
        })
    })

</script>
<%
    Cookie[] cookies = request.getCookies();
    String firstVal = "";
    String secondVal = "";
    String result = "";
    String name = "";
    String length = "";
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cFirstVal")) {
                firstVal = cookie.getValue();
            }
            if (cookie.getName().equals("cSecondVal")) {
                secondVal = cookie.getValue();
            }
            if (cookie.getName().equals("cResult")) {
                result = cookie.getValue();
            }
            if (cookie.getName().equals("cName")) {
                name = cookie.getValue();
            }
            if (cookie.getName().equals("cLength")) {
                length = cookie.getValue();
            }
        }
    }
    //update 5 user basepath
%>
<form method="post" action="<%=request.getContextPath()+"/CalServlet"%>" id="myForm">
    <table>
        <tr>
            <td>First Val:</td>
            <td><input type="text" name="firstVal" id="firstVal" value="<%=firstVal%>"></td>
            <td>Enter a Name:</td>
            <td><input type="text" name="name" id="name" value="<%=name%>"></td>
        </tr>
        <tr>
            <td>Second Val:</td>
            <td><input type="text" name="secondVal" id="secondVal" value="<%=secondVal%>"></td>
            <td>Length:</td>
            <td><input type="text" name="length" id="length" value="<%=length%>"></td>
        </tr>
        <tr>
            <td>Result:</td>
            <td><input type="text" name="result" id="result" value="<%=result%>"></td>
        </tr>
    </table>
    <input id="hidden" type="hidden" name="action" value="">
    <button id="add" type="button">Add</button>&nbsp;
    <button id="subtract" type="button">Subtract</button>&nbsp;
    <button id="multiply" type="button">Multiply</button>&nbsp;
    <button id="divide" type="button">Divide</button>&nbsp;
    <button id="computeLength" type="button">Compute Length</button>&nbsp;
    <button id="reset" type="button">Reset</button>
</form>
</body>

</html>
