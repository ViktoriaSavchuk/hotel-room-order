<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet"
          href="http://localhost:8081/ui/main/fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="http://localhost:8081/ui/main/css/style.css">
    <link rel="stylesheet" href="http://localhost:8081/ui/find/fonts/linearicons/style.css">
    <link rel="stylesheet"
          href="http://localhost:8081/ui/find/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="http://localhost:8081/ui/find/vendor/date-picker/css/datepicker.min.css">


</head>
<body>
<div class="main">
    <div class="container">
        <div class="booking-content">
            <div class="booking-image">
                <img class="booking-img" src="http://localhost:8081/ui/main/images/building.jpeg"/>"
            </div>
            <div class="booking-form">
                <form action="user" method="post">
                    <%-- <form id="booking-form">--%>
                    <h2>Your orders</h2>


                    <tr>
                        <c:forEach items="${orders}" var="order">
                            <p>${order}</p>
                        </c:forEach>
                        <c:if test="${page != 1}">
                            <td><a href="user?page=${page - 1}">Previous</a></td>
                        </c:if>
                        <c:forEach begin="1" end="${pages}" var="i">
                            <c:choose>
                                <c:when test="${page eq i}">
                                    <td>${i}</td>
                                </c:when>
                                <c:otherwise>
                                    <td><a href="user?page=${i}">${i}</a></td>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </tr>

                    <c:if test="${page lt pages}">
                        <td><a href="user?page=${page + 1}">Next</a></td>
                    </c:if>
                </form>
                </form>
                <form action="booking" method="get">
                    <input type="submit" value="Book new one" class="submit" id="booking"
                           name="booking"/>
                </form>

            </div>
        </div>
    </div>
</div>

<%--<script src="http://localhost:8081/ui/find/js/jquery-3.3.1.min.js"></script>
<script src="http://localhost:8081/ui/find/vendor/date-picker/js/datepicker.js"></script>
<script src="http://localhost:8081/ui/find/vendor/date-picker/js/datepicker.en.js"></script>
<script src="http://localhost:8081/ui/find/js/main.js"></script>--%>
</body>
</html>

