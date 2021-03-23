package com.zhangkai.week3.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        PrintWriter writer=response.getWriter();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String Gender=request.getParameter("selfValidateType");
        String date=request.getParameter("date");
        writer.print("Username:  "+username+"<br>");
        writer.print("Password:  "+password+"<br>");
        writer.print("Email:  "+email+"<br>");
        writer.print("Gender:  "+Gender+"<br>");
        writer.print("Birthdate:  "+date+"<br>");
    }

}
