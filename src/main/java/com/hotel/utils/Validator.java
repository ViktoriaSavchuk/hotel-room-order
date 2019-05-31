package com.hotel.utils;

import com.hotel.controller.Context;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Validator {

    private static final String EMAIL_REGEX = "\\w{4,}@(\\w+\\.)([a-z]{2,4})";
    private static final String PHONE_REGEX_TRUE = "/^(\\+\\d{1,3}[- ]?)?\\d{10}$/";
    private static final String PHONE_REGEX_FALSE = "/0{5,}/";


    public static boolean datesAreValid(LocalDate checkInDate, LocalDate checkOutDate) {
        return checkInDate.isAfter(LocalDate.now()) && checkInDate.isBefore(checkOutDate);
    }

    public static boolean passwordsAreValid(String password1, String password2) {
        return password1 != null && password1.length() > 6 && password1.length() < 255 && password1.equals(password2);
    }

    public static boolean emailIsValid(String email) {
        return Pattern.compile(EMAIL_REGEX)
                .matcher(email)
                .matches();
    }

    public static boolean phoneIsValid(String phone) {
        return Pattern.compile(PHONE_REGEX_TRUE).matcher(phone).matches()
                && !Pattern.compile(PHONE_REGEX_FALSE).matcher(phone).matches();
    }


}
