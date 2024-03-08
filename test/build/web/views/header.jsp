<%-- 
    Document   : header
    Created on : Jan 18, 2024, 1:26:51 AM
    Author     : Phong Vu
--%>

<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>JSP Page</title>
                <link href="assets/css/notification.css" rel="stylesheet">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
                      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
                crossorigin="anonymous"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
                        integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
                crossorigin="anonymous" referrerpolicy="no-referrer"></script>
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
                      integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
                      crossorigin="anonymous" referrerpolicy="no-referrer" />
                <style>
                        .header-item {
                                color: white;
                                font-weight: 500;
                        }
                </style>
                <style>
                        .dropdown {
                                position: relative;
                                /*display: inline-block;*/
                                margin: 0px 5px 0px 5px;
                        }

                        .dropdown-content {
                                display: none;
                                position: absolute;
                                background-color: #f9f9f9;
                                width: 380px;
                                box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
                                padding: 12px 16px;
                                /*margin-top: 14px;*/
                                z-index: 1;
                                color: black;
                        }

                        .dropdown:hover .dropdown-content {
                                display: flex;
                        }

                        .menu-item a {
                                text-decoration: none;
                                color: black;
                        }

                        .menu-item a:hover {
                                color: #21BF73;
                        }
                </style>
                <style>
                        .notification-message
                        {
                                margin-bottom: 2px;
                                width: 100%; /* Đặt độ rộng tối đa của thông báo */
                                max-width: 400px; /* Đặt độ rộng tối đa để tránh tràn quá mức */
                                white-space: normal;
                        }
                        .notification-time
                        {
                                font-size: 10px;
                                color: gray;
                                margin-left: 10px;
                        }
                        #notification-count {
                                position: absolute;
                                top: -5px;
                                right: -3px;
                                background-color: red;
                                color: white;
                                border-radius: 50%;
                                padding: 1px 5px;
                                font-size: 12px;
                        }
                        .hidden
                        {
                                display: none;
                        }
                </style>
        </head>
        <body>
                <header>
                        <div class="d-flex justify-content-between container-fluid">
                                <div class="d-flex">
                                        <div>Hỗ trợ trực tuyến:</div>
                                        <a href="#" class="d-flex align-items-center mx-3" style="color: #21BF73; text-decoration: none;">
                                                <i class="fa-brands fa-facebook"></i>
                                                <div style="margin-left: 5px">ElaTrading</div>
                                        </a>
                                </div>
                                <div class="d-flex">
                                        <div class="d-flex">
                                                <div style="color: #919191;">Ngôn ngữ: </div>
                                                <div style="color: #21BF73;"> VI</div>
                                        </div>
                                </div>
                        </div>
                        <div class="d-flex justify-content-between container-fluid align-items-center"
                             style="background-color: #21bf73">
                                <div class="d-flex align-items-center">
                                        <a href="index.jsp">
                                                <img src="https://taphoammo.net/images/logo/logo1.png" height="45" />
                                        </a>
                                        <div class="d-flex">
                                                <div class="header-item mx-2 dropdown">
                                                        Sản phẩm
                                                        <i class="fa-solid fa-chevron-down"></i>
                                                        <div class="dropdown-content row">
                                                                <div class="col-md-6 menu-item">
                                                                        <a href="products?catgory=1">Tài khoản</a>
                                                                </div>
                                                                <div class="col-md-6 menu-item">
                                                                        <a href="products?catgory=2">Phần mềm</a>
                                                                </div>
                                                                <div class="col-md-6 menu-item">
                                                                        <a href="products?catgory=3">Khác</a>
                                                                </div>
                                                        </div>
                                                </div>
                                                <div class="header-item mx-2">Hỗ trợ</div>
                                                <div class="header-item mx-2">FAQs</div>
                                        </div>
                                </div>

                                <div class="d-flex">
                                        <c:if test="${user != null}">
                                                <c:set var = "test" value = "${fn:length(notifications)}" />
                                                <div class="dropdown">
                                                        <span id="notification-count" class="hidden"></span>
                                                        <button class="text-white fs-4" type="button" id="notification-action" data-bs-toggle="dropdown"
                                                                aria-expanded="false" style="background-color: unset; border: none; outline: none">
                                                                <i class="fas fa-bell"></i>
                                                        </button>

                                                        <ul class="dropdown-menu dropdown-menu-light shadow-md" id="notification-message" aria-labelledby="notification-action"
                                                            style=" width: 400px; font-size: 15px; font-weight: 500">
                                                                <li><a class="dropdown-item" style="text-align: left; color: #21bf73; font-weight: bold;">Thông báo</a></li>
                                                                <li id ="begin">
                                                                        <hr class="dropdown-divider">
                                                                </li>
                                                                <c:choose>
                                                                        <c:when test="${test == 0}">
                                                                                <li id="none_notification"><p class="dropdown-item">Không có thông báo</p></li>
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                        <c:forEach var="notification" items="${notifications}">
                                                                                        <li>
                                                                                                <a href="${notification.url}" style="text-decoration: none">
                                                                                                        <div class="dropdown-item">
                                                                                                                <p class="hidden" id="notification_id" value="${notification.code}">${notification.code}</p>
                                                                                                                <p class="notification-message">${notification.message}</p>
                                                                                                                <time class="notification-time" datetime="${notification.created_at}"></time>
                                                                                                        </div>
                                                                                                </a>
                                                                                        </li>
                                                                                </c:forEach>
                                                                        </c:otherwise>
                                                                </c:choose>
                                                                <li>
                                                                        <hr class="dropdown-divider">
                                                                </li>
                                                                <li><a class="dropdown-item" style="text-align: center" href="logout">Xem tất cả</a></li>
                                                        </ul>
                                                </div>
                                        </c:if>
                                        <div class="dropdown">
                                                <button class="text-white fs-4" type="button" id="user-action" data-bs-toggle="dropdown"
                                                        aria-expanded="false" style="background-color: unset; border: none; outline: none">
                                                        <i class="fa-regular fa-user"></i>
                                                </button>
                                                <ul class="dropdown-menu dropdown-menu-light shadow-md" aria-labelledby="user-action"
                                                    style="font-size: 15px; font-weight: 500">
                                                        <li>
                                                                <hr class="dropdown-divider">
                                                        </li>
                                                        <li><a class="dropdown-item" href="profile">Thông tin tài khoản</a></li>
                                                        <li><a class="dropdown-item" href="#">Danh sách giao dịch</a></li>
                                                        <li><a class="dropdown-item" href="#">Lịch sử giao dịch</a></li>
                                                        <li><a class="dropdown-item" href="#">Nạp tiền</a></li>
                                                        <li><a class="dropdown-item" href="action">Hệ thống</a></li>
                                                        <li>
                                                                <hr class="dropdown-divider">
                                                        </li>
                                                        <li><a class="dropdown-item" href="logout">Thoát</a></li>
                                                </ul>
                                        </div>
                                </div>
                        </div>
                        <marquee width="100%" direction="left" height="20px" style="color: #FF2626">
                                ElaTrading - Sàn thương mại điện tử sản phẩm số phục vụ Kiếm tiền online. Mọi giao dịch trên trang đều hoàn
                                toàn tự động và được giữ tiền 3 ngày, thay thế cho hình thức trung gian, các bạn yên tâm giao dịch nhé.
                        </marquee>
                        <div id="toastX"></div>
                </header>                
                <c:if test="${user != null}">
                        <script>
                                let count = "${count}";
                                window.onload = function ()
                                {
                                        unread_notification(count);
                                        updateVietnameseTime();
                                };

                                const begin = document.getElementById("begin");
                                var socket = new WebSocket("ws://localhost:9999/test/notification?id=${user.id}");

                                socket.onmessage = function (event)
                                {
                                        // Handle incoming messages
                                        var notification = JSON.parse(event.data);
                                        $.ajax({
                                                method: "POST",
                                                url: "/test/add",
                                                data: notification
                                        }).done(function ()
                                        {
                                                toast(event.data);
                                                count++;
                                                document.getElementById("notification-count").innerHTML = "";
                                                document.getElementById("notification-count").innerHTML += count;

                                                $("#notification-count").removeClass("hidden");
                                                const none = document.getElementById("none_notification");
                                                if (none)
                                                {
                                                        none.remove();
                                                }
                                                let html = "<li><a href=\"" + notification.url + "\" style=\"text-decoration: none\"><div class=\"dropdown-item\">"
                                                        + "<p class=\"hidden\">" + notification.code + "</p>"
                                                        + "<p class=\"notification-message\">" + notification.message + "</p>"
                                                        + "<time class=\"notification-time\" id=\"Created_at\" datetime=\"" + notification.created_at + "\">Vài giây trước</time>"
                                                        + "</div></a></li>";
                                                begin.insertAdjacentHTML("afterend", html);
                                        });
                                };

                                socket.onclose = function (event)
                                {
                                        // Handle connection close
                                        alert("Connection closed");
                                };

                                socket.onclose = function (event)
                                {
                                        // Handle connection close
                                        alert("Connection closed");
                                };

                                const action = document.getElementById("notification-action");
                                action.onclick = function ()
                                {
                                        const code = document.getElementById("notification_id");
                                        if (code)
                                        {
                                                var code_value = code.textContent;
                                                console.log(code_value);
                                                setReadCode(code_value);
                                        }
                                };
                        </script>
                        <script src="assets/js/notification.js"></script>
                </c:if>
        </body>
</html>