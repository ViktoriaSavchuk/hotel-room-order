package com.hotel.controller.commands.impl;

import com.auth0.jwt.JWT;
import com.hotel.controller.commands.Command;
import com.hotel.dao.UserDao;
import com.hotel.dao.impl.Connector;
import com.hotel.dao.impl.UserDaoImpl;
import com.hotel.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class Login implements Command {
    @Override
    public void executeCommand(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao userDao = new UserDaoImpl(new Connector());
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User loginUser = userDao.findByEmail(login).get();
        if (loginUser != null && loginUser.getPassword().equals(password)) {
            String token = JWT.create()
                    .withIssuer(login)
                    .withSubject(loginUser.getName())
                    .withIssuedAt(new Date(System.currentTimeMillis() + 360000))
                    .

                    new SuccessfulLogin().executeCommand(request, response);
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/booking.jsp");
            request.setAttribute("login", login);
            rd.forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid user or password");
            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
        }
    }
}
