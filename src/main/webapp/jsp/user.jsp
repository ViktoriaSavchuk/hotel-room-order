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

            <div class="booking-form">
                <form action="booking" method="post">
                    <form id="booking-form">
                        <h2>Your orders</h2>
                        <tr>
                        <c:forEach items="${orders}" var="order">
                            <td>${order}</td>
                        </c:forEach>
                        </tr>
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

