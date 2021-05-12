package com.zhangkai.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Collection;

public class RegisterServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        ResultSet rs;
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("selfValidateType");
        String birthdate=request.getParameter("date");
        String sql1="INSERT INTO dbo.usertable" +
                "(username, password,email,gender,birthdate)VALUES( ?,?,?,?,?)";
        String sql2="select * from usertable";
        try {
            PreparedStatement statement=con.prepareStatement(sql1);
            statement.setString(1,username);
            statement.setString(2,password);
            statement.setString(3,email);
            statement.setString(4,gender);
            statement.setDate(5, Date.valueOf(birthdate));
            statement.executeUpdate();
            response.sendRedirect("login");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            Statement statement;
            statement=con.createStatement();
            rs=statement.executeQuery(sql2);
//            writer.print("<table  b"order=\"1\" align=\"center\">");
//            writer.print("<tr>");
//            writer.print("<td>"+"id"+"</td>");
//            writer.print("<td>"+"username"+"</td>");
//            writer.print("<td>"+"password"+"</td>");
//            writer.print("<td>"+"email"+"</td>");
//            writer.print("<td>"+"gender"+"</td>");
//            writer.print("<td>"+"birthdate"+"</td>");
//            writer.print("</tr>");
//            while (rs.next()){
//                writer.print("<tr>");
//                writer.println("<td>"+rs.getObject("id")+"</td>");
//                writer.println("<td>"+rs.getObject("username")+"</td>");
//                writer.println("<td>"+rs.getObject("password")+"</td>");
//                writer.println("<td>"+rs.getObject("email")+"</td>");
//                writer.println("<td>"+rs.getObject("gender")+"</td>");
//                writer.println("<td>"+rs.getObject("birthdate")+"</td>");
//                writer.print("</tr>");
//            }
////            writer.print("</table>");
//            request.setAttribute("rsname",rs);
//            response.setContentType("text/html");
//            request.getRequestDispatcher("userlist.jsp").forward(request,response);
//            System.out.println("i am in registerservlet--dopost()-->after forward");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req,resp);
    }
}
