<%-- 
    Document   : doTimKiemPhongHat
    Created on : Dec 6, 2020, 3:26:20 PM
    Author     : nguye
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Room"%>
<%@page import="dao.RoomDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        
        RoomDAO rd = new RoomDAO();
        if (request.getParameter("deleteFlag") != null){
            int id = Integer.parseInt((String)request.getParameter("inListId"));
            
            ArrayList<Room> roomList = (ArrayList<Room>)session.getAttribute("roomList");
            int i = rd.xoaPhongHat(roomList.get(id));
            roomList.remove(roomList.get(id));
        }
        String roomName = request.getParameter("roomName");
        ArrayList<Room> roomList = rd.timPhongHatTheoTen(roomName);
        
        session.setAttribute("roomList", roomList);
        
        response.sendRedirect("gdTimKiemPhongHat.jsp");
    %>
</html>
