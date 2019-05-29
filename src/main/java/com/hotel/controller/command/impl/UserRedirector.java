package com.hotel.controller.command.impl;

import com.hotel.controller.command.Command;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.TextCodec;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserRedirector implements Command {


    //to property file
    private static final int ADMIN_MAX_INACTIVE_INTERVAL = 300000;
    private static final int USER_MAX_INACTIVE_INTERVAL = 600000;

    @Override
    public void executeCommand(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(TextCodec.BASE64.decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E="))
                .parseClaimsJws(request.getSession().getAttribute("token").toString());

        //should role be checked with null?
        Integer role = (Integer) claimsJws.getBody().get("role");

        switch (role) {
            case 1: {
                request.getSession().setMaxInactiveInterval(ADMIN_MAX_INACTIVE_INTERVAL);
                response.sendRedirect("/admin");

                break;
            }
            case 2: {
                request.getSession().setMaxInactiveInterval(USER_MAX_INACTIVE_INTERVAL);
          /*
                booking.executeCommand(request, response);*/

                response.sendRedirect("/booking");
                break;
            }
        }
    }
}
