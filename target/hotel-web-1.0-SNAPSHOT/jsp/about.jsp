<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <title>About us</title>
    <meta charset="utf-8">

    <meta name="description" content="The River template project">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css"
          href="http://localhost:8081/ui/header/styles/bootstrap-4.1.2/bootstrap.min.css">
    <link href="http://localhost:8081/ui/header/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet"
          type="text/css">


    <link rel="stylesheet" type="text/css" href="http://localhost:8081/ui/header/styles/about.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8081/ui/header/styles/about_responsive.css">
    <link rel="stylesheet" href="http://localhost:8081/ui/main/css/style.css">
</head>
<body>

<div class="super_container">


    <header class="header">
        <div class="header_content d-flex flex-row align-items-center justify-content-start">
            <div class="ml-auto d-flex flex-row align-items-center justify-content-start">

                <div class="ml-auto d-flex flex-row align-items-lg-end justify-content-start on-left">
                    <%-- <div class="book_button" >--%>
                    <form action="about" method="post">
                        <input type="submit" value="home" class="submit" id="home"
                               name="command"/>
                    </form>
                </div>

                <div class="header_phone d-flex flex-row align-items-center justify-content-center">
                    <img src="http://localhost:8081/ui/header/images/phone.png" alt="">
                    <span>0123-12345678</span>
                </div>
                <div class="hamburger"><i class="fa fa-bars" aria-hidden="true"></i></div>
            </div>
        </div>
    </header>


    <div class="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="about_title"><h2>Forest Hotel / 10 years of excellence</h2></div>
                </div>
            </div>
            <div class="row about_row">

                <div class="col-lg-6">
                    <div class="about_content">
                        <div class="about_text">
                            <p>Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;
                                Suspendisse nec faucibus velit. Quisque eleifend orci ipsum, a bibendum lacus suscipit
                                sit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia
                                Curae; Suspendisse nec faucibus velit. Quisque eleifend orci ipsum, a bibendum lacus
                                suscipit sit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere
                                cubilia Curae; Suspendisse nec faucibus velit.</p>
                        </div>
                        <div class="about_sig"><img src="http://localhost:8081/ui/header/images/sig.png" alt=""></div>
                    </div>
                </div>

                <div class="col-lg-6">
                    <div class="about_images d-flex flex-row align-items-start justify-content-between flex-wrap">
                        <img src="http://localhost:8081/ui/header/images/about_1.png" alt="">
                        <img src="http://localhost:8081/ui/header/images/about_2.png" alt="">
                        <img src="http://localhost:8081/ui/header/images/about_3.png" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="testimonials">
        <div class="parallax_background parallax-window" data-parallax="scroll"
             data-image-src="http://localhost:8081/ui/header/images/testimonials.jpg"
             data-speed="0.8"></div>
        <div class="testimonials_overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="testimonials_slider_container">

                        <!-- Testimonials Slider -->
                        <div class="owl-carousel owl-theme test_slider">

                            <!-- Slide -->
                            <div class="test_slider_item text-center">
                                <div class="rating rating_5 d-flex flex-row align-items-start justify-content-center">
                                    <i></i><i></i><i></i><i></i><i></i></div>
                                <div class="testimonial_title"><a href="#">Perfect Stay</a></div>
                                <div class="testimonial_text">
                                    <p>Etiam nec odio vestibulum est mattis effic iturut magna. Pellentesque sit amet
                                        tellus blandit. Etiam nec odio vestibulum est mattis effic.</p>
                                </div>
                                <div class="testimonial_image"><img
                                        src="http://localhost:8081/ui/header/images/user_1.jpg" alt=""></div>
                                <div class="testimonial_author"><a href="#">Samantha Smith</a>, Greece</div>
                            </div>

                            <!-- Slide -->
                            <div class="test_slider_item text-center">
                                <div class="rating rating_5 d-flex flex-row align-items-start justify-content-center">
                                    <i></i><i></i><i></i><i></i><i></i></div>
                                <div class="testimonial_title"><a href="#">Nice place</a></div>
                                <div class="testimonial_text">
                                    <p>Etiam nec odio vestibulum est mattis effic iturut magna. Pellentesque sit amet
                                        tellus blandit. Etiam nec odio vestibulum est mattis effic.</p>
                                </div>
                                <div class="testimonial_image"><img
                                        src="http://localhost:8081/ui/header/images/user_2.jpg" alt=""></div>
                                <div class="testimonial_author"><a href="#">Michael Doe</a>, Italy</div>
                            </div>

                            <div class="test_slider_item text-center">
                                <div class="rating rating_5 d-flex flex-row align-items-start justify-content-center">
                                    <i></i><i></i><i></i><i></i><i></i></div>
                                <div class="testimonial_title"><a href="#">We loved it</a></div>
                                <div class="testimonial_text">
                                    <p>Etiam nec odio vestibulum est mattis effic iturut magna. Pellentesque sit amet
                                        tellus blandit. Etiam nec odio vestibulum est mattis effic.</p>
                                </div>
                                <div class="testimonial_image"><img
                                        src="http://localhost:8081/ui/header/images/user_3.jpg" alt=""></div>
                                <div class="testimonial_author"><a href="#">Luis Garcia</a>, Spain</div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <footer class="footer">
        <div class="footer_content">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="footer_logo_container text-center">
                            <div class="footer_logo text-black-50">
                                <a href="#"></a>
                                <div>Forest Hotel</div>
                                <div></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row footer_row">

                    <!-- Address -->
                    <div class="col-lg-3">
                        <div class="footer_title">Our Address</div>
                        <div class="footer_list">
                            <ul></ul>
                            <p>67559</p>
                            <p>Canada</p>
                        </div>
                    </div>

                    <div class="col-lg-3">
                        <div class="footer_title">Reservations</div>
                        <div class="footer_list">
                            <ul></ul>
                            <p>Tel: 345 5667 889  </p>
                            <p>Fax; 6783 4567 889</p>
                            <p>reservations@foresthotel.com</p>
                        </div>
                    </div>


                    <div class="col-lg-4">
                        <div class="certificates d-flex flex-row align-items-start justify-content-lg-between justify-content-start flex-lg-nowrap flex-wrap">
                            <div class="cert"><img src="images/cert_1.png" alt=""></div>
                            <div class="cert"><img src="images/cert_2.png" alt=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </footer>
</div>

</body>
</html>