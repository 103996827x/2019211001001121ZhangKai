package com.zhangkai.controller;

import com.zhangkai.dao.UserDao;
import com.zhangkai.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateServlet", value = "/update")
public class UpdateUserServlet extends HttpServlet {
    Connection con = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setGender(request.getParameter("gender"));
        user.setBirthdate(Date.valueOf(request.getParameter("date")));
        user.setId(Integer.parseInt(request.getParameter("id")));
        try {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60 * 60);
            session.setAttribute("user", user);
            UserDao userDao = new UserDao();
            if (userDao.updateUser(con, user) != 0) {
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }
}
