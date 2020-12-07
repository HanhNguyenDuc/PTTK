<%-- 
    Document   : gdPhanCongNhanVien.jsp
    Created on : Dec 7, 2020, 1:10:18 AM
    Author     : nguye
--%>

<%@page import="model.BookedRoom"%>
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
        <div class="container">
            <h1 class="row d-flex justify-content-center" style="padding-bottom: 100px">Tìm kiếm phòng hát</h1>
            <div class="row d-flex justify-content-center _btn">
                <form action="doTimKiemPhong.jsp" method="post" class="row">
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
                            <th scope="col">Đang phục vụ</th>
                            <th scope="col">Phân công thêm</th>
                        </tr>
                    </thead>
                    <tbody>

                        
                        <%  
                            ArrayList<BookedRoom> abr = (ArrayList<BookedRoom>)session.getAttribute("bookedRoomList");
                            int index = Integer.parseInt(request.getParameter("loopindex"));
                            BookedRoom curBookedRoom = abr.get(index);
                            // lấy ds nhân viên đang rảnh
                        %>
                                <tr>
                                    <td><c:out value="${loopindex + 1}" /></td>
                                    <td><c:out value="${current.name}" /></td>
                                    <td><c:out value="${current.type}" /></td>
                                    <td><c:out value="${current.desc}" /></td>
                                    <td><c:out value="${current.price}" /></td>
                                    <td><c:out value="${staffNumber}"/></td>
                                    <form action="gdPhanCongNhanVien.jsp" method="post">
                                        <input name="deleteFlag" value="1" hidden/>
                                        <input name="inListId" value="${loopindex}"hidden/>
                                        <td><button class="btn btn-primary" type="submit">Phân công thêm</button></td>
                                    </form>

                        

                                </tr>
                            <%}%>
                    

                    </tbody>
                </table>
            </div>
        </div>

    </body>
</html>
