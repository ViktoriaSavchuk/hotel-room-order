<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
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
            <form action="admin" method="post">
                <input type="submit" value="logout" class="submit" id="logout"
                       name="command"/>
            </form>
            <form action="about" method="get">
                <input type="submit" value="    about    " class="submit" id="about"
                       name="registration"/>
            </form>
        </div>
        <div class="submit d-flex flex-row align-items-center justify-content-center on-left">
            <img src="http://localhost:8081/ui/header/images/phone.png" alt="">
            <span>0123-12345678</span>
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
                <form action="admin" method="post">
                    <form id="booking-form">
                        <h2>Find a room</h2>
                        <form action="">
                            <div class="form-row">
                                <div class="form-wrapper">
                                    <label <%--for=""--%>>Order information</label>
                                    <p>${order.user.email}</p>
                                    <p>${order.serviceLevel.classLevel}</p>
                                    <p>${order.numberOfPlaces}</p>
                                </div>
                            </div>
                            <div class="select-list">
                                <label>${info}</label>
                                <select id="room" name="room">
                                    <c:forEach items="${rooms}" var="rooms">
                                        <option value="${rooms.id}">${rooms.id}</option>
                                    </c:forEach>
                                </select>
                                <%--  <label>Choose from available rooms</label>
                                  <select id="level" name="level">
                                      <c:forEach items="${available}" var="available_room">
                                          <option value="${available_room}">${available_room.id}</option>
                                      </c:forEach>
                                  </select>--%>
                            </div>
                            <div class="form-submit">
                                <c:choose>
                                    <c:when test="${next==true}">
                                        <input type="submit" value="update" class="submit" id="submit"
                                               name="command"/>

                                    </c:when>
                                    <c:otherwise>

                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <%--  <div class="form-submit">
                                  <input type="submit" class="submit" id="submit"
                                         name="submit" <c:if test="${next == false}"><c:out value="disabled='disabled'" />
                              </c:if>">
                              </div>--%>
                            <%--<input type="submit" value="submit and get next" class="submit" id="submit"
                                   name="submit"/>--%>
                            <div class="form-submit">
                                <c:choose>
                                    <c:when test="${delete}">
                                        <%--<input type="submit"  class="submit" id="delete" value=""
                                               name="delete" disabled="disabled"/>--%>
                                        <input type="submit" value="delete" class="submit" id="submit"
                                               name="command"/>
                                    </c:when>
                                    <c:otherwise>

                                    </c:otherwise>
                                </c:choose>
                                <%--<input type="submit" class="submit" name="delete" id="delete"
                                       name="delete" <c:if test="${delete == false}"><c:out value="disabled='disabled'"/>
                            </c:if>">--%>

                            </div>

                        </form>
                    </form>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="http://localhost:8081/ui/find/js/jquery-3.3.1.min.js"></script>
<script src="http://localhost:8081/ui/find/vendor/date-picker/js/datepicker.js"></script>
<script src="http://localhost:8081/ui/find/vendor/date-picker/js/datepicker.en.js"></script>
<script src="http://localhost:8081/ui/find/js/main.js"></script>
</body>
</html>

