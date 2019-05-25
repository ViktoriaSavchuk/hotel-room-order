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
                <img class="booking-img" src="http://localhost:8081/booking/images/form-img.jpg" />" alt="Booking Image">
            </div>
            <div class="booking-form">
                <form id="booking-form">
                    <h2>Booking place for your dinner!</h2>
                    <div class="form-group form-input">
                        <input type="text" name="name" id="name" value="" required/>
                        <label for="name" class="form-label">Your name</label>
                    </div>
                    <div class="form-group form-input">
                        <input type="number" name="phone" id="phone" value="" required />
                        <label for="phone" class="form-label">Your phone number</label>
                    </div>
                    <div class="form-group">
                        <div class="select-list">
                            <select name="time" id="time" required>
                                <option value="">Time</option>
                                <option value="6pm">6:00 PM</option>
                                <option value="7pm">7:00 PM</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="select-list">
                            <select name="food" id="food" required>
                                <option value="">Food</option>
                                <option value="seasonalfish">Seasonal steamed fish</option>
                                <option value="assortedmushrooms">Assorted mushrooms</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-radio">
                        <label class="label-radio"> Select Your Dining Space</label>
                        <div class="radio-item-list">
                                <span class="radio-item">
                                    <input type="radio" name="number_people" value="2" id="number_people_2" />
                                    <label for="number_people_2">2</label>
                                </span>
                            <span class="radio-item active">
                                    <input type="radio" name="number_people" value="4" id="number_people_4" checked="checked" />
                                    <label for="number_people_4">4</label>
                                </span>
                            <span class="radio-item">
                                    <input type="radio" name="number_people" value="6" id="number_people_6" />
                                    <label for="number_people_6">6</label>
                                </span>
                            <span class="radio-item">
                                    <input type="radio" name="number_people" value="8" id="number_people_8" />
                                    <label for="number_people_8">8</label>
                                </span>
                            <span class="radio-item">
                                    <input type="radio" name="number_people" value="10" id="number_people_10" />
                                    <label for="number_people_10">10</label>
                                </span>
                        </div>
                    </div>

                    <div class="form-submit">
                        <input type="submit" value="Book now" class="submit" id="submit" name="submit" />
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>

<script src="http://localhost:8081/booking/vendor/jquery/jquery.min.js"></script>
<script src="http://localhost:8081/booking/js/main.js"></script>
</body>
</html>