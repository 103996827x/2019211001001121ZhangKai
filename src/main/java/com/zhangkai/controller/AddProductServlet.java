package com.zhangkai.controller;

import com.zhangkai.dao.ProductDao;
import com.zhangkai.model.Category;
import com.zhangkai.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

@WebServlet(name = "AddProductServlet", value = "/admin/addProductServlet")
public class AddProductServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        con= (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categoryList=Category.findallCategory(con);
            request.setAttribute("categoryList",categoryList);
            String path="/WEB-INF/views/admin/addProduct.jsp";
            request.getRequestDispatcher(path).forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName=request.getParameter("productName");
        double price=request.getParameter("price")!=null?Double.parseDouble(request.getParameter("price")):0.0;
        int categoryId=request.getParameter("categoryId")!=null?Integer.parseInt(request.getParameter("categoryId")):0;
        String productDescription=request.getParameter("productDescription");
        InputStream inputStream=null;
        Part fileParts=request.getPart("picture");
        if(fileParts!=null){
            inputStream= fileParts.getInputStream();
        }
        Product product=new Product();
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setPicture(inputStream);
        product.setPrice(price);
        product.setCategoryId(categoryId);
        ProductDao productDao=new ProductDao();

        try {
            int n=productDao.save(product,con);
            if(n>0)
                response.sendRedirect("productList");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    }
