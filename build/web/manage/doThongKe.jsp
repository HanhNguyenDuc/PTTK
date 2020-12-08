<%-- 
    Document   : doThongKe.jsp
    Created on : Dec 7, 2020, 2:31:54 PM
    Author     : nguye
--%>

<%@page import="model.ServingHourStat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ServingHourStatDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        // nhận parameter
        System.out.println("Start Date: " +  request.getParameter("startdate"));
        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startdate"));  
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("enddate"));  
        session.setAttribute("startDate", startDate);
        session.setAttribute("endDate", endDate);

        ServingHourStatDAO shsd = new ServingHourStatDAO();
        ArrayList<ServingHourStat> ashs = shsd.getServingHourStat(startDate, endDate);
        
        session.setAttribute("totalHourServingList", ashs);
        response.sendRedirect("gdThongKe.jsp");
    %>
</html>
