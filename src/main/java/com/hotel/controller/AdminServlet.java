package com.hotel.controller;

import com.hotel.entity.Order;
import com.hotel.entity.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AdminServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(BookingServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LOGGER.info("GET to AdminServlet");
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/admin.jsp");
        Optional<Order> order = Context.getOrderService().selectFirstNotFullOrder();

        if (order.isPresent()) {
            List<Room> allSuitableRooms = Context.getAdminService().getAllSuitableRooms(order.get());
            List<Room> allAvailableRooms = Context.getAdminService().getAllAvailableRoomOnDates(order.get());
            request.setAttribute("order", order.get());
            request.setAttribute("suitable", allSuitableRooms);
            request.setAttribute("order", allAvailableRooms);

        } else
            rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
