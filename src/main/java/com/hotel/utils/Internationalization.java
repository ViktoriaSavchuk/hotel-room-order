package com.hotel.utils;

import java.util.*;

public class Internationalization {
    public static final String MSG = ResourceBundle.getBundle("i18n_config").getString("msg.bundle");

    public static final Locale UA=new Locale("uk", "UA");
    public static final Locale EN=new Locale("en", "EN");
    public static final Locale RU=new Locale("ru", "RU");
    public static final Locale DEFAULT_LOCALE = EN ;

    List<Locale> supportedLocales = new ArrayList<>(Arrays.asList(UA,EN,RU));

}
