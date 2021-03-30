package com.zhangkai.week4.demo;

import jdk.nashorn.internal.ir.RuntimeNode;

import javax.jws.WebParam;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.*;
import java.util.Collection;
@WebServlet(urlPatterns = "/JDBCCDemoServlet",
 initParams = {
        @WebInitParam(name = "driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
        @WebInitParam(name = "url",value = "jdbc:sqlserver://localhost:1433;DatabaseName=userdb"),
        @WebInitParam(name = "userName",value = "ZK"),
        @WebInitParam(name = "password",value = "103996827zk")
 },loadOnStartup = 1
)
public class JDBCDemoServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb";
        String userName="ZK";
        String password="103996827zk";
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url, userName, password);
            System.out.println("INIT()-->"+con);
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("I am in doGet()");
        String sql="select * from usertable";
        ResultSet rs;
        Statement statement;
        try {
            statement=con.createStatement();
            rs=statement.executeQuery(sql);
            while (rs.next()){
            };
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultSet rs=null;
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("selfValidateType");
        String birthdate=request.getParameter("date");
        String sql1="INSERT INTO dbo.usertable" +
                "(username, password,email,gender,birthdate)VALUES( ?,?,?,?,?)";
        try {
            PreparedStatement statement=con.prepareStatement(sql1);
            statement.setString(1,username);
            statement.setString(2,password);
            statement.setString(3,email);
            statement.setString(4,gender);
            statement.setDate(5, Date.valueOf(birthdate));
            int num=statement.executeUpdate();
            if(num>0){
                System.out.println("add success");
            }else{
                System.out.println("false");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.setContentType("text/html");
        PrintWriter writer=response.getWriter();
        String sql2="select * from usertable";
        try {
            Statement statement;
            statement=con.createStatement();
            rs=statement.executeQuery(sql2);
            writer.print("<table table border=\"1\" >");
            writer.print("<tr>");
            writer.print("<td>"+"id"+"</td>");
            writer.print("<td>"+"username"+"</td>");
            writer.print("<td>"+"password"+"</td>");
            writer.print("<td>"+"email"+"</td>");
            writer.print("<td>"+"gender"+"</td>");
            writer.print("<td>"+"birthdate"+"</td>");
            writer.print("</tr>");
            while (rs.next()){
                writer.print("<tr>");
                writer.println("<td>"+rs.getObject("id")+"</td>");
                writer.println("<td>"+rs.getObject("username")+"</td>");
                writer.println("<td>"+rs.getObject("password")+"</td>");
                writer.println("<td>"+rs.getObject("email")+"</td>");
                writer.println("<td>"+rs.getObject("gender")+"</td>");
                writer.println("<td>"+rs.getObject("birthdate")+"</td>");
                writer.print("</tr>");
            }
            writer.print("</table>");;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void destroy(){
        super.destroy();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
