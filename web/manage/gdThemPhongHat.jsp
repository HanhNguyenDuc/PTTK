<%-- 
    Document   : gdThemPhongHat
    Created on : Dec 6, 2020, 5:19:24 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <header>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="../statics/css/gdQLPhongHat.css" rel="stylesheet"/>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </header>
    
    <body>
        <div class="container">
            <form action="doSuaThongTinPhongHat.jsp" method="post">
                    <label for="name">Tên phòng: </label>
                    <input type="text" class="form-control" id="name" value="" name="name">
                    
                    <label for="type">Loại phòng: </label>
                    <input type="text" class="form-control" id="type" value="" name="type">
                    
                    <label for="desc">Mô tả: </label>
                    <input type="text" class="form-control" id="desc" value="" name="desc">      
                    
                    <label for="price">Giá phòng (nghìn đồng / h): </label>
                    <input type="text" class="form-control" id="price" value="" name="price">
                    <div class="row d-flex justify-content-center" style="margin-top: 20px">
                        <button class="btn btn-primary" type="submit"> Submit </button>
                    </div>
                </form>
        </div>
        
    </body>
</html>
