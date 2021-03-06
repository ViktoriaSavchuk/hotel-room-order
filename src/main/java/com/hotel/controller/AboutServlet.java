package com.hotel.controller;


import com.hotel.controller.command.impl.Redirect;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/about")
public class AboutServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(AboutServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("GET to AboutServlet");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/about.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("role")!=null){
            new Redirect().executeCommand(request,response);
        }else {
            response.sendRedirect("/login");
        }
    }
}
