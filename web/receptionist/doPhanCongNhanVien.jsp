<%-- 
    Document   : doPhanCongNhanVien
    Created on : Dec 7, 2020, 9:41:56 AM
    Author     : nguye
--%>

<%@page import="dao.BookedRoomServingDAO"%>
<%@page import="model.ServerShift"%>
<%@page import="model.BookedRoomServing"%>
<%@page import="model.BookedRoom"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        // lấy ra bookedroom
        ArrayList<BookedRoom> abr = (ArrayList<BookedRoom>)session.getAttribute("bookedRoomList");
        System.out.println("");
        System.out.println("abr: " + abr);
        System.out.println("bookedRoomId " + session.getAttribute("bookedRoomId"));
        int bookedRoomIdsadvcl = (Integer)session.getAttribute("bookedRoomId");
        BookedRoom br = abr.get(0) ;
        int bookedRoomDBId = br.getId();
        
        // tạo bookedroomserving
        ArrayList<ServerShift> ass = (ArrayList<ServerShift>)session.getAttribute("serverShiftList");
        int servershiftId = Integer.parseInt(request.getParameter("servershiftId"));
        ArrayList<BookedRoomServing> abrs = (ArrayList<BookedRoomServing>)session.getAttribute("bookedRoomServingList");
        BookedRoomServing brs = new BookedRoomServing();
        brs.setServerShift(ass.get(servershiftId));
         
        // gọi DAO
        BookedRoomServingDAO brsd = new BookedRoomServingDAO();
        int result = brsd.capNhatPhanCongNhanVien(brs, bookedRoomDBId);
        if (result != -99){
            ass.remove(servershiftId);
            abrs.add(brs);
            session.setAttribute("bookedRoomServingList", abrs);
            session.setAttribute("serverShiftList", ass);
        %>
            <header>
                <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
                <!--<link href="../statics/css/gdTimKiemPhongHat.css" rel="stylesheet"/>-->
                <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
                <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
            </header>
            <body>
                <div class="container">
                    <div class="row d-flex justify-content-center">
                        <h2>Thực hiện phân công nhân viên thành công</h2>
                    </div>
                    <div class="row d-flex justify-content-center">
                        <a class="btn btn-primary" href="gdTimKiemPhong.jsp">Ok</a>
                    </div>
                </div>
            </body>
    <%
        }
    %>
</html>
