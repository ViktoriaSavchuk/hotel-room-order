<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <form action="booking" method="post">
                    <form id="booking-form">
                        <h2>Find a room</h2>
                        <form action="">
                            <div class="form-row">
                                <div class="form-wrapper">
                                    <label <%--for=""--%>>Check-in *</label>
                                    <span class="lnr lnr-calendar-full"></span>
                                    <input type="text" class="form-control datepicker-here" data-language='en'
                                           data-date-format="dd M yyyy" name="check_in" id="check_in">
                                </div>
                                <div class="form-wrapper">
                                    <label <%--for=""--%>>Check-out *</label>
                                    <span class="lnr lnr-calendar-full"></span>
                                    <input type="text" class="form-control datepicker-here" data-language='en'
                                           data-date-format="dd M yyyy" name="check_out" id="check_out">
                                </div>
                            </div>
                            <%--  < class="form-group">--%>
                            <div class="select-list">
                                <label>Places</label>
                                <select id="number" name="number">
                                    <%--<option value="">choose number of places in the room</option>--%>
                                    <c:forEach items="${number_of_places}" var="number" >
                                        <option  value="${number}">${number}</option>
                                    </c:forEach>
                                </select>
                                <label>Service Level</label>
                                <select id="level" name="level">
                                    <%-- <option value="">choose level of service</option>--%>
                                    <c:forEach items="${levels_of_service}" var="level">
                                        <option value="${level}">${level.value}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-submit">
                                <input type="submit" value="Book now" class="submit" id="submit" name="submit"/>
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

