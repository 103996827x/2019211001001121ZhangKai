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

    }


    @Override
    public void init() throws ServletException {
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb";
        String userName="ZK";
        String password="103996827zk";
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url, userName, password);
            System.out.println("INIT()-->"+con);
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultSet rs;
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter writer=response.getWriter();
        String sql="select username,password from usertable";
        int flag=0;
        try {
            Statement statement=con.createStatement();
            rs=statement.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("username").equals(username)&&rs.getString("password").equals(password))
                {
                   flag=1;
                }else{flag=0;};
            };
            if (flag==1){
                writer.println("Login Success!!!"+"<br>");
                writer.println("Welcome  "+username);
            }else{
                writer.println("Login Error");

            };
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
