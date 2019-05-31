package com.hotel.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class Coder {

    public static String encode(String password) {
        return DigestUtils.md5Hex(password);
    }

}
