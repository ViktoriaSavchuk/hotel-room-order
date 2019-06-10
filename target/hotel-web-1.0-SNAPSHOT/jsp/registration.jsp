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


</head>
<body>
<header class="header">
    <div class="header_content d-flex flex-row align-items-center justify-content-start">
        <div class="logo"><a href="#">Forest Hotel</a></div>
        <%-- <div class="pull-left">--%>
        <div class="ml-auto d-flex flex-row align-items-lg-end justify-content-start on-left">
            <%-- <div class="book_button" >--%>
            <form action="about" method="get">
                <input type="submit" value="    About    " class="submit" id="about"
                       name="registration"/>
            </form>
            <%--    // <a href="http://localhost:8081/ui/header/about.html">About</a>--%>
        </div>
        <div class="submit d-flex flex-row align-items-center justify-content-center on-left">
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
                <form action="registration" method="post" id="contactForm">
                    <h5><%=request.getAttribute("errorMessage") %>
                    </h5>
                    <h3>New Account?</h3>
                    <div class="form-group">
                        <span class="lnr lnr-user"></span>
                        <label>First Name</label>
                        <input required minlength="2" type="text" class="form-control" placeholder="Username"
                               name="name"
                               id="name">
                    </div>
                    <div class="form-holder">
                        <span class="lnr lnr-user"></span>
                        <label>Second Name</label>
                        <input required minlength="2" type="text" class="form-control"
                               placeholder="Username" name="surname" id="surname">
                    </div>
                    <div class="form-holder">
                        <span class="lnr lnr-phone-handset"></span>
                        <label for="phone">Phone Number</label>
                        <input required minlength="5" maxlength="11" type="text" class="form-control"
                               placeholder="Phone Number" name="phone" id="phone">
                    </div>
                    <div class="form-group"<%--"form-holder"--%>>
                        <span class="lnr lnr-envelope"></span>
                        <label for="email" class="control-label">E-mail</label>
                        <input type="email" class="form-control" placeholder="Mail" name="email" id="email">
                    </div>
                    <div class="form-holder">
                        <span class="lnr lnr-lock"></span>
                        <label>Password</label>
                        <input required minlength="7" maxlength="255"  type="password"
                               class="form-control" placeholder="Password" name="pass1" id="pass1">
                    </div>
                    <div class="form-holder">
                        <span class="lnr lnr-lock"></span>
                        <label>Confirm Password</label>
                        <input required minlength="7" maxlength="255" type="password"
                               class="form-control" placeholder="Confirm Password" name="pass2"
                               id="pass2">
                    </div>

                    <div class="form-submit">
                        <input type="submit" value="Registration" class="submit" id="submit"
                               name="submit"/>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
<script src="http://localhost:8081/ui/registration/js/jquery-3.3.1.min.js"></script>
<script src="http://localhost:8081/ui/registration/js/main.js"></script>
<%--<script src="http://localhost:8081/ui/main/js/validation.js"></script>--%>
</body>
</html>