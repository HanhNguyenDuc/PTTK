<%-- 
    Document   : gdXemChiTietThongKe
    Created on : Dec 7, 2020, 9:33:36 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Date"%>
<%@page import="model.ServerShift"%>
<%@page import="dao.ServerShiftDAO"%>
<%@page import="model.ServingHourStat"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <header>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="../statics/css/gdTimKiemPhongHat.css" rel="stylesheet"/>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </header>
    <body>
        <%
            int loopIndex = Integer.parseInt(request.getParameter("loopindex"));
            ArrayList<ServingHourStat> ashs = (ArrayList<ServingHourStat>) session.getAttribute("totalHourServingList");
            ServingHourStat curShs = ashs.get(loopIndex);
            session.setAttribute("curServingHourStat", curShs);

            ServerShiftDAO ssd = new ServerShiftDAO();
            Date startDate = (Date) session.getAttribute("startDate");
            Date endDate = (Date) session.getAttribute("endDate");
            ArrayList<ServerShift> ass = ssd.getCaLamViecCaNhan(curShs, startDate, endDate);

        %>
        <div class='container'>
            <div class='row d-flex justify-content-center'>
                <h2>Xem chi tiết thống kê</h2>
            </div>
            <div class='row d-flex justify-content-center'>
                <table class="table">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Tuần (ngày bắt đầu)</th>
                            <th scope="col">Ngày trong tuần</th>
                            <th scope="col">Ca trong ngày (giờ bắt đầu)</th>

                        </tr>
                    </thead>
                    <tbody>
                        <%                            
                            for (int i = 0; i < ass.size(); i++) {
                                ServerShift ss = ass.get(i);
                                pageContext.setAttribute("current", ss.getShift());
                                if (ss.getShift().getTimeTable() == 1){
                                    pageContext.setAttribute("shiftTime", "0h - 8h");
                                }
                                else if (ss.getShift().getTimeTable() == 2){
                                    pageContext.setAttribute("shiftTime", "8h - 16h");
                                }
                                else {
                                    pageContext.setAttribute("shiftTime", "16h-0h");
                                }
                                pageContext.setAttribute("loopindex", i);

                        %>

                        <tr>
                            <td><c:out value="${loopindex + 1}" /></td>
                            <td><c:out value="${current.week}" /></td>
                            <td><c:out value="${current.dayOfWeek}" /></td>
                            <td>
                                <c:out value="${shiftTime}"/>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
            </div>
        </div>

    </body>
</html>
