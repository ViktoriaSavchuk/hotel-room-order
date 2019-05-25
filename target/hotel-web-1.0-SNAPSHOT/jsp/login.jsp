<%--
  Created by IntelliJ IDEA.
  User: viktoria
  Date: 5/25/19
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form by Colorlib</title>

    <link rel="stylesheet" href="http://localhost:8081/booking/fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="http://localhost:8081/booking/css/style.css">

</head>
<body>

<div class="main">
    <div class="container">
        <div class="booking-content">
            <div class="booking-image">
                <img class="booking-img" src="http://localhost:8081/booking/images/building.jpeg" />" alt="Booking Image">
            </div>
            <div class="booking-form">
                <form action="login" method="post">
                    <h5><%=request.getAttribute("errorMessage") %></h5>
                    <div class="form-group">
                        <%--@declare id="exampleinputemail1"--%><label for="exampleInputEmail1">User
                        Name</label> <input
                            type="text" class="form-control" name="login" id="login"
                            placeholder="Enter User Name" required="required">
                    </div>
                    <div class="form-group">
                        <%--@declare id="exampleinputpassword1"--%><label
                            for="exampleInputPassword1">Password</label> <input
                            type="password" class="form-control" name="password" id="password"
                            placeholder="Password" required="required">
                    </div>
                    <button type="submit" style="width: 100%; font-size:1.1em;"
                            class="btn btn-large btn btn-success btn-lg btn-block"><b>Login</b></button>
                </form>
            </div>
        </div>
    </div>

</div>

</body>
</html>

