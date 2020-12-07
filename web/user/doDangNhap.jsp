<%-- 
    Document   : doDangNhap
    Created on : Dec 6, 2020, 11:10:06 AM
    Author     : nguye
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.*,dao.*" %>

<%
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            UserDAO dao = new UserDAO();

            if (username.isEmpty() || password.isEmpty()) {
                response.sendRedirect("gdDangNhap.jsp");
            } else if (dao.kiemTraDangNhap(user)) {
                if (user.getRole().equalsIgnoreCase("customer")) {
                    response.sendRedirect("MainCustomerView.jsp");
                } else if (user.getRole().equalsIgnoreCase("receptionist")) {
                    response.sendRedirect("MainReceptionist.jsp");
                } else {
                    response.sendRedirect("gdChinhQuanLy.jsp");
                }
            } else {
                response.sendRedirect("../manage/gdDangNhap.jsp");
            }
%>