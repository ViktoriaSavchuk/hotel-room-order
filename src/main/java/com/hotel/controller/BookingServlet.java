package com.hotel.controller;

import com.hotel.controller.command.impl.Booking;
import com.hotel.dao.impl.Connector;
import com.hotel.dao.impl.RoomDaoImpl;
import com.hotel.service.RoomService;
import com.hotel.service.impl.RoomServiceImpl;

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

    Connector connector=new Connector();
    private RoomService roomService = new RoomServiceImpl(new RoomDaoImpl(connector));



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/booking.jsp");
        Set<Integer> allRoomTypeByNumberOfPlaces = roomService.findAllRoomTypeByNumberOfPlaces();
        Map<Long, String> allTypesOfServiceLevel = roomService.findAllTypesOfServiceLevel();


        request.setAttribute("number_of_places", allRoomTypeByNumberOfPlaces);
        request.setAttribute("levels_of_service",allTypesOfServiceLevel);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new Booking().executeCommand(request, response);
    }
}
