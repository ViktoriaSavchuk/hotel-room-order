package com.hotel.controller;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ErrorHandler extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(ErrorHandler.class);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("GET to ErrorHandler");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/error.jsp");
        requestDispatcher.forward(request, response);

    }
}
