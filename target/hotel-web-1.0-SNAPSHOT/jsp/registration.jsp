<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.hotel.utils.Internationalization" %>
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
</head>
<body>
<header class="header">
    <div class="header_content d-flex flex-row align-items-center justify-content-start">
        <div class="logo"><a href="#">Forest Hotel</a></div>
        <div class="ml-auto d-flex flex-row align-items-lg-end justify-content-start on-left">
            <form action="about" method="get">
                <input type="submit" value=
                <fmt:message key="about"/> class="submit" id="about"
                       name="registration"/>
            </form>
        </div>
        <form action="about" method="post">
            <input type="submit" value=
            <fmt:message key="home"/>  class="submit" id="home"
                   name="command"/>
        </form>
        <div class="submit ml-auto d-flex flex-row align-items-lg-end justify-content-start on-left">
            <<select id="dynamic_select">
            <c:forEach items="${Internationalization.supportedLocales}" var="locale">
                <option value="http://localhost:8081/admin?lang=${locale.toLanguageTag()}">
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
                <img class="booking-img" src="http://localhost:8081/ui/main/images/building.jpeg"/>
            </div>
            <div class="booking-form">
                <form action="registration" method="post" id="contactForm">
                    <h5><%=request.getAttribute("errorMessage") %>
                    </h5>
                    <h3><fmt:message key="new.account"/></h3>
                    <div class="form-group">
                        <span class="lnr lnr-user"></span>
                        <label><fmt:message key="first.name"/></label>
                        <input required minlength="2" type="text" class="form-control"
                               placeholder="<fmt:message key="first.name" />"
                               name="name"
                               id="name">
                    </div>
                    <div class="form-holder">
                        <span class="lnr lnr-user"></span>
                        <label><fmt:message key="second.name"/> </label>
                        <input required minlength="2" type="text" class="form-control"
                               placeholder=
                               <fmt:message key="second.name"/> name="surname" id="surname">
                    </div>
                    <div class="form-holder">
                        <span class="lnr lnr-phone-handset"></span>
                        <label for="phone"><fmt:message key="phone"/></label>
                        <input required minlength="5" maxlength="11" type="text" class="form-control"
                               placeholder=
                               <fmt:message key="phone"/> name="phone" id="phone">
                    </div>
                    <div class="form-group">
                        <span class="lnr lnr-envelope"></span>
                        <label for="email" class="control-label"><fmt:message key="email"/></label>
                        <input type="email" class="form-control"
                               placeholder=
                               <fmt:message key="email"/> name="email" id="email">
                    </div>
                    <div class="form-holder">
                        <span class="lnr lnr-lock"></span>
                        <label><fmt:message key="password"/></label>
                        <input required minlength="7" maxlength="255" type="password"
                               class="form-control" placeholder=
                               <fmt:message key="password"/>  name="pass1" id="pass1">
                    </div>
                    <div class="form-holder">
                        <span class="lnr lnr-lock"></span>
                        <label><fmt:message key="confirm.password"/></label>
                        <input required minlength="7" maxlength="255" type="password"
                               class="form-control" placeholder=
                               <fmt:message key="confirm.password"/> name="pass2"
                               id="pass2">
                    </div>

                    <div class="form-submit">
                        <input type="submit" value=
                        <fmt:message key="registration"/> class="submit" id="submit"
                               name="submit"/>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
<script src="http://localhost:8081/ui/registration/js/jquery-3.3.1.min.js"></script>
<script src="http://localhost:8081/ui/registration/js/main.js"></script>
</body>
</html>