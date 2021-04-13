package com.zhangkai.week5.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    public void init() throws ServletException {
//        ServletContext config= getServletContext();
//        String driver = config.getInitParameter("driver");
//        String url = config.getInitParameter("url");
//        String username = config.getInitParameter("username");
//        String password = config.getInitParameter("password");
//        try {
//            Class.forName(driver);
//            con= DriverManager.getConnection(url, username, password);
//            System.out.println("INIT()-->"+con);
//        }catch (ClassNotFoundException | SQLException e){
//            e.printStackTrace();
//        }
        con= (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String sql="select * from Usertable where username=? and password=?";
        PreparedStatement pstmt= null;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            ResultSet rs= pstmt.executeQuery();
            PrintWriter out=response.getWriter();
            if(rs.next()){
                /*out.println("Login Success!!!");
                out.println("Welcome,"+Username);*/
                request.setAttribute("username",rs.getObject("username"));
                request.setAttribute("password",rs.getObject("password"));
                request.setAttribute("email",rs.getObject("email"));
                request.setAttribute("gender",rs.getObject("gender"));
                request.setAttribute("birthdate",rs.getObject("birthdate"));
                request.getRequestDispatcher("userinfo.jsp").forward(request,response);
            }else {
                //out.println("Username or password Error!!!");
                request.setAttribute("message","Username or password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
