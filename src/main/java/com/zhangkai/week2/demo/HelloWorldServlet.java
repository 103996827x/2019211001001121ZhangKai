package com.zhangkai.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorldServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        String Name = request.getParameter("name");
        String Id = request.getParameter("id");
        String time = format.format(date);
        writer.print("Name:  " + Name + "<br>");
        writer.print("ID:  " + Id + "<br>");
        writer.print("Time:  " + time);
    }
}
