<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="message" scope="session"/>
<%@ page import="com.hotel.utils.Internationalization" %>

<!DOCTYPE html>
<html lang="${sessionScope.lang}">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css"
          href="http://localhost:8081/ui/header/styles/bootstrap-4.1.2/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8081/ui/header/styles/main_styles.css">
    <link rel="stylesheet"
          href="http://localhost:8081/ui/main/fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="http://localhost:8081/ui/main/css/style.css">
</head>
<body>
<header class="header">
    <div class="header_content d-flex flex-row align-items-center justify-content-start">
        <div class="logo"><a href="#">Forest Hotel</a></div>
        <div class="ml-auto d-flex flex-row align-items-lg-end justify-content-start on-left">
            <form action="about" method="get">
                <input type="submit" value=
                <fmt:message key="about"/>  class="submit" id="about"
                       name="registration"/>
            </form>
        </div>
        <div class="submit ml-auto d-flex flex-row align-items-lg-end justify-content-start on-left">
            <select id="dynamic_select">
                <c:forEach items="${Internationalization.supportedLocales}" var="locale">
                    <option value="http://localhost:8081/login?lang=${locale.toLanguageTag()}">
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
        <div class="booking-content" >
            <div class="booking-image" >
                <img class="booking-img" style="vertical-align:middle" src="http://localhost:8081/ui/main/images/building.jpeg"/>
            </div>
            <div class="booking-form">
                <form action="login" method="post">
                    <h5><%=request.getAttribute("errorMessage") %>
                    </h5>
                    <div class="form-group">
                            <label><fmt:message key="email"/></label> <input
                            type="text" class="form-control" name="login" id="login"
                            placeholder=<fmt:message key="email"/> required="required">
                    </div>
                    <div class="form-group">
                        <label> <fmt:message key="password"/></label> <input
                            type="password" class="form-control" name="password" id="password"
                            placeholder=<fmt:message key="password"/> required="required">
                    </div>
                    <div class="form-submit">
                        <input type="submit" value=<fmt:message key="login"/> class="submit" id="submit" name="login"/>
                    </div>
                </form>
                <form action="registration" method="get">
                    <input type="submit" value=<fmt:message key="registration"/> class="submit" id="registration"
                           name="registration"/>
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

