<%-- 
    Document   : gdTimKiemPhongHat
    Created on : Dec 6, 2020, 2:38:30 PM
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
            <h1 class="row d-flex justify-content-center" style="padding-bottom: 100px">Tìm kiếm phòng hát</h1>
            <div class="row d-flex justify-content-center _btn">
                <form action="doTimKiemPhongHat.jsp" method="post" class="row">
                    <div class="col-md-10">
                        <label for="roomName">Nhập vào tên phòng hát:</label>
                        <input type="text" class="form-control" id="roomName" name="roomName">
                    </div>
                    <div class="col-md-2">
                        <button class="btn btn-primary" type="submit" id="submitName" style="">Tìm kiếm</button>
                        
                    </div>
                </form>
                
            </div>
            <div class="row d-flex justify-content-center" style="margin-top: 10px">
                <a class="btn btn-primary" href="gdQLPhongHat.jsp" role="button">Quay lại</a>
            </div>
            <div class="row d-flex justify-content-center _btn" id="roomTable">
                <table class="table">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Tên phòng</th>
                            <th scope="col">Loại phòng</th>
                            <th scope="col">Mô tả</th>
                            <th scope="col">Giá phòng</th>
                            <th scope="col">Sửa</th>
                            <th scope="col">Xóa</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Room> roomList = (ArrayList<Room>) session.getAttribute("roomList");
                            System.out.println(roomList);
                            pageContext.setAttribute("roomList", roomList);
                        %>

                        <c:forEach items="${roomList}" var="current" varStatus="loop">

                            <tr>
                                <td><c:out value="${loop.index + 1}" /></td>
                                <td><c:out value="${current.name}" /></td>
                                <td><c:out value="${current.type}" /></td>
                                <td><c:out value="${current.desc}" /></td>
                                <td><c:out value="${current.price}" /></td>
                        <form action="gdSuaThongTinPhong.jsp" method="post">
                            <input name="inListId" value="${loop.index}"hidden/>
                            <td><button class="btn btn-primary" type="submit">Sửa</button></td>
                        </form>
                        <form action="doTimKiemPhongHat.jsp" method="post">
                            <input name="deleteFlag" value="1" hidden/>
                            <input name="inListId" value="${loop.index}"hidden/>
                            <td><button class="btn btn-primary" type="submit">Xóa</button></td>
                        </form>

                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>

    </body>
</html>
