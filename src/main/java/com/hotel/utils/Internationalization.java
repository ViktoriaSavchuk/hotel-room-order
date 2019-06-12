package com.hotel.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Internationalization {

    public static final Locale EN = new Locale("en", "EN");
    public static final Locale RU = new Locale("ru", "RU");
    public static Locale currentLocale = EN;


    public static List<Locale> supportedLocales = Arrays.asList(currentLocale, EN, RU);


}
