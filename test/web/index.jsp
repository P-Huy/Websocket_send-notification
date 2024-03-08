<%-- 
    Document   : index
    Created on : Feb 21, 2024, 8:47:47 PM
    Author     : admin
--%>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
        <head>
                <title>WebSocket Notification</title>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" 
                        integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
                        crossorigin="anonymous" referrerpolicy="no-referrer">
                </script>
        </head>
        <body>
                <jsp:include page="/views/header.jsp"/>
                
                <h2>WebSocket Notification</h2>
                <form class="form-horizontal" id="login" role="form" method="POST" action="process">
                        <div class="form-group">
                                <label for="product" class="col-md-4 control-label">Product ID</label>
                                <div class="col-md-6">
                                        <input id="product" type="text" class="form-control" name="product" value>
                                </div>
                        </div>
                        <div class="form-group">
                                <div class="col-md-6 col-md-offset-4">
                                        <button type="submit" class="btn btn-primary">
                                                Buy
                                        </button>
                                </div>
                        </div>
                </form>
        </body>
</html>
