<%-- 
    Document   : gdPhanCongNhanVien.jsp
    Created on : Dec 7, 2020, 1:10:18 AM
    Author     : nguye
--%>

<%@page import="model.ServerShift"%>
<%@page import="dao.ServerShiftDAO"%>
<%@page import="model.BookedRoomServing"%>
<%@page import="dao.BookedRoomServingDAO"%>
<%@page import="model.BookedRoom"%>
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

    <body>
        <div class="container">
            <h1 class="row d-flex justify-content-center" style="padding-bottom: 100px">Phân công nhân viên phục vụ</h1>
            
            <div class="row d-flex justify-content-center" style="margin-top: 10px">
                <a class="btn btn-primary" href="gdQLPhongHat.jsp" role="button">Quay lại</a>
            </div>
            <div class="row d-flex justify-content-center _btn" id="roomTable">
                <table class="table">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Tên nhân viên</th>
                            <th scope="col">Phân công</th>
                        </tr>
                    </thead>
                    <tbody>

                        
                        <%  
                            ArrayList<BookedRoom> abr = (ArrayList<BookedRoom>)session.getAttribute("bookedRoomList");
                            int index = Integer.parseInt(request.getParameter("inListId"));
                            session.setAttribute("bookedRoomId", index);
                            BookedRoom curBookedRoom = abr.get(index);
                            
                            BookedRoomServingDAO brsd = new BookedRoomServingDAO();
                            ServerShiftDAO ssd = new ServerShiftDAO();
                            // lấy ds nhân viên đang rảnh
                            ArrayList<BookedRoomServing> abrs = brsd.getdsNhanVienDangPhucVu();
                            ArrayList<ServerShift> ass = ssd.getdsNhanVienDangLam();
                            session.setAttribute("serverShiftList", ass);
                            session.setAttribute("bookedRoomServingList", abrs);
                            System.out.println(abrs);
                            System.out.println(ass);
                            Boolean[] aFlag = new Boolean[ass.size()];
                            
                            for (int i=0; i<ass.size(); i++){
                                ServerShift ss = ass.get(i);
                                aFlag[i] = true;
                                for (BookedRoomServing brs : abrs){
                                    if (ss.getServer().getId() == brs.getServerShift().getServer().getId()){
                                        aFlag[i] = false;
                                        break;
                                    }
                                }
                            }
                            for (int i=0; i<ass.size(); i++)
                            if (aFlag[i] == true){
                                
                                pageContext.setAttribute("loopindex", i);
                                pageContext.setAttribute("current", ass.get(i).getServer());
                                System.out.print("Server name: " + ass.get(i).getServer().getName());
                        %>
                                <tr>
                                    <td><c:out value="${loopindex + 1}" /></td>
                                    <td><c:out value="${current.name}" /></td>
                                    <form action="doPhanCongNhanVien.jsp" method="post">
                                        <input name="deleteFlag" value="1" hidden/>
                                        <input name="servershiftId" value="${loopindex}"hidden/>
                                        <td><button class="btn btn-primary" type="submit">Phân công</button></td>
                                    </form>

                        

                                </tr>
                            <%}%>
                    

                    </tbody>
                </table>
            </div>
        </div>

    </body>
</html>
