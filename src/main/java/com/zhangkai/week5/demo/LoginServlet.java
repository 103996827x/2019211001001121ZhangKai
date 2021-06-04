package com.zhangkai.week5.demo;

import com.zhangkai.dao.UserDao;
import com.zhangkai.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
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
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(con, username, password);
            if (user != null) {
                String rememberme = request.getParameter("rememberme");
                if (rememberme != null && rememberme.equals("1")) {
                    Cookie usernameCookie = new Cookie("cUsername", user.getUsername());
                    Cookie passwordCookie = new Cookie("cPassword", user.getPassword());
                    Cookie rememberMeCookie = new Cookie("cRememberMe", rememberme);
                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }
                Cookie c = new Cookie("seessionid", "" + user.getId());
                c.setMaxAge(10 * 60);
                HttpSession session = request.getSession();
                System.out.println("session id  ---" + session.getId());
                session.setMaxInactiveInterval(10);
                session.setAttribute("user", user);
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Username or password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        String sql="select * from Usertable where username=? and password=?";
//        PreparedStatement pstmt= null;
//        try {
//            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1,username);
//            pstmt.setString(2,password);
//            ResultSet rs= pstmt.executeQuery();
//            PrintWriter out=response.getWriter();
//            if(rs.next()){
//                /*out.println("Login Success!!!");
//                out.println("Welcome,"+Username);*/
//                request.setAttribute("username",rs.getObject("username"));
//                request.setAttribute("password",rs.getObject("password"));
//                request.setAttribute("email",rs.getObject("email"));
//                request.setAttribute("gender",rs.getObject("gender"));
//                request.setAttribute("birthdate",rs.getObject("birthdate"));
//                request.getRequestDispatcher("userinfo.jsp").forward(request,response);
//            }else {
//                //out.println("Username or password Error!!!");
//                request.setAttribute("message","Username or password Error!!!");
//                request.getRequestDispatcher("login.jsp").forward(request,response);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
    }
}
