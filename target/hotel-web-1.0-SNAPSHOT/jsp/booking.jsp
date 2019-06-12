<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <form action="booking" method="post">
                <input type="submit" value="logout" class="submit" id="logout"
                       name="command"/>
            </form>
            <form action="about" method="post">
                <input type="submit" value="home" class="submit" id="home"
                       name="command"/>
            </form>
            <form action="about" method="get">
                <input type="submit" value="about" class="submit" id="about"
                       name="command"/>
            </form>
        </div>
        <div class="submit ml-auto d-flex flex-row align-items-lg-end justify-content-start on-left">
            <select id="dynamic_select">
            <c:forEach items="${Internationalization.supportedLocales}" var="locale">
                <option value="http://localhost:8081/booking?lang=${locale.toLanguageTag()}">
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
                <form action="booking" method="post">
                    <form id="booking-form">
                        <h2>Find a room</h2>
                        <form action="">
                            <div class="form-row">
                                <div class="form-wrapper">
                                    <label>Check-in *</label>
                                    <input type="date" class="form-control" data-language='en'
                                           name="check_in" id="check_in"
                                           min="${check_in_min_start_date}" max="${check_in_max_start_date}">
                                </div>
                                <div class="form-wrapper">
                                    <label>Check-out *</label>
                                    <input type="date" class="form-control" data-language='en'
                                           name="check_out" id="check_out"
                                           min="${check_out_min_start_date}" max="${check_out_max_start_date}">
                                </div>
                            </div>
                            <div class="select-list">
                                <label>Places</label>
                                <select id="number" name="number">
                                    <c:forEach items="${number_of_places}" var="number">
                                        <option value="${number}">${number}</option>
                                    </c:forEach>
                                </select>
                                <label>Service Level</label>
                                <select id="level" name="level">
                                    <c:forEach items="${levels_of_service}" var="level">
                                        <option value="${level}">${level.value}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-submit">
                                <input type="submit" value="book" class="submit" id="book" name="command"/>
                            </div>

                        </form>
                    </form>
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
<%--<script src="http://localhost:8081/ui/find/js/jquery-3.3.1.min.js"></script>
<script src="http://localhost:8081/ui/find/vendor/date-picker/js/datepicker.js"></script>
<script src="http://localhost:8081/ui/find/vendor/date-picker/js/datepicker.en.js"></script>
<script src="http://localhost:8081/ui/find/js/main.js"></script>--%>
</body>
</html>

