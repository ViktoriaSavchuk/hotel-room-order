package com.hotel.controller.command.impl;

import com.hotel.controller.command.Command;
import com.hotel.dao.impl.Connector;
import com.hotel.dao.impl.UserDaoImpl;
import com.hotel.entity.Role;
import com.hotel.entity.User;
import com.hotel.service.UserService;
import com.hotel.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration implements Command {

    //error handler
    //class context and it should create
    private static final UserService USER_SERVICE = new UserServiceImpl(new UserDaoImpl(new Connector()));

    @Override
    public void executeCommand(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");

        //todo add email and pass validation and phone
        if (pass1 != null && pass1.equals(pass2)) {
            USER_SERVICE.create(User.builder()
                    .withName(request.getParameter("name"))
                    .withSurname(request.getParameter("surname"))
                    .withPhone(request.getParameter("phone"))
                    .withPassword(pass1)
                    .withRole(new Role(2L, "user"))
                    .withEmail(request.getParameter("email"))
                    .build());
        }else {
            redirect(request,response,"Fill all fields correct");
        }
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response, String message)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/registration.jsp");
        request.setAttribute("errorMessage",message);
        requestDispatcher.forward(request, response);
    }
}
