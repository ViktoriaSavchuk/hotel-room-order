package com.hotel.controller.command.impl;

import com.hotel.controller.command.Command;
import com.hotel.dao.impl.Connector;
import com.hotel.dao.impl.UserDaoImpl;
import com.hotel.entity.User;
import com.hotel.service.UserService;
import com.hotel.service.impl.UserServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Login implements Command {

    private static final UserService USER_SERVICE = new UserServiceImpl(new UserDaoImpl(new Connector()));

    @Override
    public void executeCommand(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User loginUser = null;

        if (USER_SERVICE.findByEmail(login).isPresent()) {
            loginUser = USER_SERVICE.findByEmail(login).get();
        } else {
            redirect(request,response,"Unknown user");
        }

        if (loginUser != null && loginUser.getPassword().equals(password)) {

            String token = Jwts.builder()
                    .claim("id", loginUser.getId())
                    .claim("role", loginUser.getRole().getId())
                    .signWith(SignatureAlgorithm.HS256,
                            TextCodec.BASE64.decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E="))
                    .compact();
            request.getSession().setAttribute("token", token);

            new UserRedirector().executeCommand(request, response);

        } else {
           redirect(request,response,"Invalid password");
        }
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response, String message)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/login.jsp");
        request.setAttribute("errorMessage",message);
        requestDispatcher.forward(request, response);
    }
}
