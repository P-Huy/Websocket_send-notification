<%-- 
    Document   : login
    Created on : Feb 21, 2024, 6:28:46 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>JSP Page</title>
        </head>
        <body>
                <h1>Hello World!</h1>
                <form class="form-horizontal" id="login" role="form" method="POST" action="/test/login">
                        <div class="form-group">
                                <label for="name" class="col-md-4 control-label">Email hoặc Tên đăng nhập</label>
                                <div class="col-md-6">
                                        <input id="name" type="text" class="form-control" name="name" value>
                                </div>
                        </div>
                        <div class="form-group">
                                <div class="col-md-6 col-md-offset-4">
                                        <button type="submit" class="btn btn-primary">
                                                <i class="fas fa-btn fa-sign-in"></i> Đăng nhập
                                        </button>
                                </div>
                        </div>
                </form>
        </body>
</html>
