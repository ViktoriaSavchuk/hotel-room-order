package com.hotel.controller.command.impl;

import com.hotel.controller.Context;
import com.hotel.controller.command.Command;
import com.hotel.entity.Role;
import com.hotel.entity.User;
import com.hotel.utils.Coder;
import com.hotel.utils.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registrate implements Command {

    private static final Logger LOGGER = LogManager.getLogger(Registrate.class);

    @Override
    public void executeCommand(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        System.out.println(email);

        if (Validator.passwordsAreValid(pass1, pass2) &&
                Validator.emailIsValid(email) &&
                Validator.phoneIsValid(phone)) {
            Context.getUserService().create(User.builder()
                    .withName(request.getParameter("name"))
                    .withSurname(request.getParameter("surname"))
                    .withPhone(phone)
                    .withPassword(Coder.encode(pass1))
                    .withRole(new Role(2L, "user"))
                    .withEmail(email)
                    .build());

            LOGGER.info(email + "was registered");
        } else {
            LOGGER.warn(email + "wasn't registered cause of wrong fields");
            redirect(request, response, "Fill all fields correctly");
        }
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response, String message)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/registration.jsp");
        request.setAttribute("errorMessage", message);
        requestDispatcher.forward(request, response);
    }
}
