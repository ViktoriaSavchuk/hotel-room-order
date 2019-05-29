<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
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
       <%-- <div class="pull-left">--%>
        <div class="ml-auto d-flex flex-row align-items-center justify-content-start">
            <div class="book_button" ><a href="http://localhost:8081/ui/header/about.html">About</a></div>
            <div class="header_phone d-flex flex-row align-items-center justify-content-center on-left">
                <img src="http://localhost:8081/ui/header/images/phone.png" alt="">
                <span>0123-12345678</span>
            </div>
        </div>

        <%--</--%><%--div>--%>
    </div>
</header>
<div class="main">
    <div class="container">
        <div class="booking-content">
            <div class="booking-image">
                <img class="booking-img" src="http://localhost:8081/ui/main/images/building.jpeg"/>
            </div>
            <div class="booking-form">
                <form action="login" method="post">
                    <h5><%=request.getAttribute("errorMessage") %>
                    </h5>
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
                    <%--<button type="submit" style="width: 100%; font-size:1.1em;"
                            class="btn btn-large btn btn-success btn-lg btn-block"><b>Login</b></button>--%>
                    <div class="form-submit">
                        <input type="submit" value="         Login         " class="submit" id="submit" name="submit"/>
                    </div>
                </form>
                <form action="registration" method="get">
                    <input type="submit" value="Registration" class="submit" id="registration"
                           name="registration"/>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

