<%-- 
    Document   : gdThongKe
    Created on : Dec 7, 2020, 1:56:02 PM
    Author     : nguye
--%>

<%@page import="model.ServingHourStat"%>
<%@page import="java.util.ArrayList"%>
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
    <%
        ArrayList<ServingHourStat> ashs = (ArrayList<ServingHourStat>) session.getAttribute("totalHourServingList");
        pageContext.setAttribute("totalHourServingList", ashs);
    %>
    <body>
        <div class="container">
            <div class="row d-flex justify-content-center" style="margin-bottom: 50px"><h2>Thống kê giờ phục vụ của nhân viên</h2></div>
            <div class="row d-flex justify-content-center">
                <form action="doThongKe.jsp" method="post">
                    <div class="row">
                        <div class="col-md-6"><label for="startdate">Ngày bắt đầu:</label></div>
                        <div class="col-md-6"><input type="date" id="startdate" name="startdate"></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><label for="enddate">Ngày kết thúc:</label></div>
                        <div class="col-md-6"><input type="date" id="enddate" name="enddate"></div>
                    </div>
                    <div class="row d-flex justify-content-center" style="margin-top: 20px;">
                        <button class="btn btn-primary" type="submit">Xem thống kê</button>
                    </div>
                </form>
            </div>
            <div class="row d-flex justify-content-center" style="margin-top: 50px;">
                <table class="table">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Nhân viên</th>
                            <th scope="col">Giờ làm việc</th>
                            <th scope="col">Xem chi tiết</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${totalHourServingList}" var="current" varStatus="loop">
                            <tr>
                                <td><c:out value="${loop.index + 1}" /></td>
                                <td><c:out value="${current.name}" /></td>
                                <td><c:out value="${current.totalHourServing}" /></td>
                                <td>
                                    <form action="gdXemChiTietThongKe.jsp" action='post'>
                                        <input value="${loop.index}" name="loopindex" type='hidden'/>
                                        <button class='btn btn-primary' type='submit'>Xem chi tiết</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
