package com.hotel.controller.commands.impl;

import com.hotel.controller.commands.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SuccessfulLogin implements Command {

    @Override
    public void executeCommand(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/booking.jsp");
        request.setAttribute("login", "tatiana@gmail.com");
        //TODO
        rd.forward(request, response);
    }
}
