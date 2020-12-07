<%-- 
    Document   : doThemPhongHat
    Created on : Dec 6, 2020, 5:28:27 PM
    Author     : nguye
--%>

<%@page import="dao.RoomDAO"%>
<%@page import="model.Room"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        
        String name = (String)request.getParameter("name");
        String type = (String)request.getParameter("type");
        String desc = (String)request.getParameter("desc");
        float price = Float.parseFloat(request.getParameter("price"));
        Room room = new Room();
        RoomDAO roomDAO = new RoomDAO();
        room.setName(name);
        room.setDesc(desc);
        room.setPrice(price);
        room.setType(type);
        int status = roomDAO.themPhongHat(room);
        if (status != -99){
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
                        <h2>Có lỗi xảy ra, vui lòng thử lại sau</h2>
                    </div>
                    <div class="row d-flex justify-content-center">
                        <a class="btn btn-primary" href="gdThemPhongHat.jsp">Ok</a>
                    </div>
                </div>
            </body>
        <%}
        else{
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
                        <h2>Cập nhật thông tin phòng hát thành công</h2>
                    </div>
                    <div class="row d-flex justify-content-center">
                        <a class="btn btn-primary" href="gdThemPhongHat.jsp">Ok</a>
                    </div>
                </div>
            </body>
            <%
        }
    %>
</html>
