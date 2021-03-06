package com.hotel.controller;

import com.hotel.controller.command.impl.Registrate;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(RegistrationServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("GET to RegistrationServlet");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/registration.jsp");
        request.setAttribute("errorMessage", "     ");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("POST to RegistrationServlet");
        new Registrate().executeCommand(request, response);
    }
}
