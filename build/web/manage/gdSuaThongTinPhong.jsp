<%-- 
    Document   : gdSuaThongTinPhong
    Created on : Dec 6, 2020, 3:56:24 PM
    Author     : nguye
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Room"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <header>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="../statics/css/gdTimKiemPhongHat.css" rel="stylesheet"/>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </header>
    <body>
        <div class="container">
            <div class="row d-flex justify-content-center">
                <h2>Sửa thông tin phòng hát</h2>
                <%
                    
                    int id = Integer.parseInt((String)request.getParameter("inListId"));
                    ArrayList<Room> roomList = (ArrayList<Room>)session.getAttribute("roomList");
                    pageContext.setAttribute("room", roomList.get(id));
                    Room fixingRoom = roomList.get(id);
                    session.setAttribute("fixingRoom", fixingRoom);
                %>
            </div>
            
            <div class="row d-flex justify-content-center" style="margin-top: 100px">
                <form action="doSuaThongTinPhongHat.jsp" method="post">
                    <label for="name">Tên phòng: </label>
                    <input type="text" class="form-control" id="name" value="${room.name}" name="name" readonly>
                    
                    <label for="type">Loại phòng: </label>
                    <input type="text" class="form-control" id="type" value="${room.type}" name="type">
                    
                    <label for="desc">Mô tả: </label>
                    <input type="text" class="form-control" id="desc" value="${room.desc}" name="desc">      
                    
                    <label for="price">Giá phòng (nghìn đồng / h): </label>
                    <input type="text" class="form-control" id="price" value="${room.price}" name="price">
                    <div class="row d-flex justify-content-center" style="margin-top: 20px">
                        <button class="btn btn-primary" type="submit"> Submit </button>
                    </div>
                    <div class="row d-flex justify-content-center _btn">
                        <a class="btn btn-primary" href="gdTimKiemPhongHat.jsp" role="button">Quay lại</a>
                    </div>
                </form>
                    
            </div>
        </div>
    </body>
</html>
