package com.hotel.controller.command.impl;

import com.hotel.controller.Context;
import com.hotel.controller.command.Command;
import com.hotel.entity.User;
import com.hotel.utils.Coder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Login implements Command {

    private static final Logger LOGGER = LogManager.getLogger(Login.class);

    @Override
    public void executeCommand(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User loginUser;
        if (Context.getUserService().findByEmail(login).isPresent()) {
            loginUser = Context.getUserService().findByEmail(login).get();
            if (loginUser.getPassword().equals(Coder.encode(password))) {
                request.getSession().setAttribute("id", loginUser.getId());
                request.getSession().setAttribute("role", loginUser.getRole());
                new Redirect().executeCommand(request, response);
            }else {
                redirect(request, response, "Invalid login or password");
            }
        } else {
            redirect(request, response, "Invalid login or password");
        }
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response, String message)
            throws ServletException, IOException {
        LOGGER.warn("user with wrong credentials tried to login");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/login.jsp");
        request.setAttribute("errorMessage", message);
        requestDispatcher.forward(request, response);
    }
}
