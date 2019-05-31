package com.hotel.controller;

import com.hotel.controller.command.impl.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;


@WebServlet("/booking")
public class BookingServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(BookingServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LOGGER.info("GET to BookingServlet");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/booking.jsp");
        Set<Integer> allRoomTypeByNumberOfPlaces = Context.getRoomService().findAllRoomTypeByNumberOfPlaces();
        Map<Long, String> allTypesOfServiceLevel = Context.getRoomService().findAllTypesOfServiceLevel();
        request.setAttribute("number_of_places", allRoomTypeByNumberOfPlaces);
        request.setAttribute("levels_of_service", allTypesOfServiceLevel);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("POST from BookingServlet");
        new Book().executeCommand(request, response);
    }
}
