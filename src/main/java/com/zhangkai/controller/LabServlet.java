package com.zhangkai.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LabServlet", value = "/lab")
public class LabServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         request.getRequestDispatcher("/lab1/assignment1.jsp").forward(request,response);
         request.getRequestDispatcher("/lab1/assignment2/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
