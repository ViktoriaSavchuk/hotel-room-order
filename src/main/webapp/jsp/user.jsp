<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.hotel.utils.Internationalization" %>
<fmt:setLocale value="${sessionScope.lang}" scope="session"/>
<fmt:setBundle basename="message" scope="session"/>

<!DOCTYPE html>
<html lang="${sessionScope.lang}">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" type="text/css"
          href="http://localhost:8081/ui/header/styles/bootstrap-4.1.2/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8081/ui/header/styles/main_styles.css">
    <link rel="stylesheet" type="text/css"
          href="http://localhost:8081/ui/header/styles/bootstrap-4.1.2/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8081/ui/header/styles/main_styles.css">
    <link rel="stylesheet"
          href="http://localhost:8081/ui/main/fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="http://localhost:8081/ui/main/css/style.css">
    <link rel="stylesheet" href="http://localhost:8081/ui/find/fonts/linearicons/style.css">
    <link rel="stylesheet"
          href="http://localhost:8081/ui/find/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="http://localhost:8081/ui/find/vendor/date-picker/css/datepicker.min.css">


</head>
<body>
<header class="header">
    <div class="header_content d-flex flex-row align-items-center justify-content-start">
        <div class="logo"><a href="#">Forest Hotel</a></div>
        <div class="ml-auto d-flex flex-row align-items-lg-end justify-content-start on-left">
            <form action="about" method="post">
                <input type="submit" value=
                <fmt:message key="home"/>  class="submit" id="home"
                       name="command"/>
            </form>
            <form action="login" method="get">
                <input type="submit" value=
                <fmt:message key="logout"/>  class="submit" id="logout"
                       name="command"/>
            </form>
            <form action="about" method="get">
                <input type="submit" value=
                <fmt:message key="about"/>  class="submit" id="about"
                       name="registration"/>
            </form>
        </div>
        <div class="submit ml-auto d-flex flex-row align-items-lg-end justify-content-start on-left">
            <select id="dynamic_select">
            <c:forEach items="${Internationalization.supportedLocales}" var="locale">
                <option value="http://localhost:8081/user?lang=${locale.toLanguageTag()}">
                        ${locale.toLanguageTag()}
                </option>
            </c:forEach>
        </select>
        </div>
        <div class="submit d-flex flex-row align-items-center justify-content-center on-left">
            <img src="http://localhost:8081/ui/header/images/phone.png" alt="">
            <span>0123-12345678</span>
        </div>
    </div>

    </div>
</header>
<div class="main">
    <div class="container">
        <div class="booking-content">
            <div class="booking-image">
                <img class="booking-img" src="http://localhost:8081/ui/main/images/building.jpeg"/>"
            </div>
            <div class="booking-form">
                <form action="user" method="post">
                    <h2>Your orders</h2>
                    <tr>
                        <c:forEach items="${orders}" var="order">
                            <p><fmt:message key="order.time"/> ${order.orderTime}</p>
                            <p><fmt:message key="check.in"/> ${order.checkIn.toLocalDate()}</p>
                            <p><fmt:message key="check.out"/> ${order.checkOut.toLocalDate()}</p>
                            <p><fmt:message key="service.level"/> ${order.serviceLevel.classLevel}</p>
                            <p><fmt:message key="room"/>:
                                <c:choose>
                                    <c:when test="${order.room.id==null}">
                                        <fmt:message key="wait.confirmation"/></p>
                                    </c:when>
                                    <c:otherwise>
                                        ${order.room.id}</p>
                                    </c:otherwise>
                                </c:choose><%--
                                    ${order.room.id}==null? "<fmt:message key="wait.confirmation"/>" :${order.room.id}</p>--%>
                            <p><fmt:message key="number.of.places"/>: ${order.numberOfPlaces}</p>
                        </c:forEach>
                        <c:if test="${page != 1}">
                            <td><a href="user?page=${page - 1}"><</a></td>
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
                        <c:if test="${page lt pages}">
                            <td><a href="user?page=${page + 1}"></a></td>
                        </c:if>
                    </tr>
                </form>
                </form>
                <form action="booking" method="get">
                    <input type="submit" value=
                    <fmt:message key="book.new"/> class="submit" id="booking"
                           name="booking"/>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="http://localhost:8081/ui/find/js/jquery-3.3.1.min.js"></script>
<script>
    $(function () {
        // bind change event to select
        $('#dynamic_select').on('change', function () {
            var url = $(this).val(); // get selected value
            if (url) { // require a URL
                window.location = url; // redirect
            }
            return false;
        });
    });
</script>
</body>
</html>

