<%-- 
    Document   : doTimKiemPhong
    Created on : Dec 6, 2020, 9:48:47 PM
    Author     : nguye
--%>

<%@page import="model.BookedRoom"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.BookedRoomDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String roomName = request.getParameter("roomName");
        BookedRoomDAO brd = new BookedRoomDAO();
        ArrayList<BookedRoom> abr;
        abr = brd.timPhongHatDangDungTheoTen(roomName);
        session.setAttribute("bookedRoomList", abr);
        response.sendRedirect("gdTimKiemPhong.jsp");
    %>
</html>
