package com.hotel.controller;

import com.hotel.controller.command.CommandFactory;
import com.hotel.controller.command.impl.DeleteOrder;
import com.hotel.controller.command.impl.UpdateOrder;
import com.hotel.entity.Order;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(BookingServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LOGGER.info("GET to AdminServlet");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/admin.jsp");
        Optional<Order> order = Context.getOrderService().selectFirstNotFullOrder();

        if (order.isPresent()) {
            request.setAttribute("order", order.get());
            if (Context.getAdminService().getAllSuitableRooms(order.get()).size() > 0) {
                request.setAttribute("info", "Choose suitable room for user");
                request.setAttribute("rooms", Context.getAdminService().getAllSuitableRooms(order.get()));
                request.setAttribute("next", true);
                request.setAttribute("delete", false);
                request.getSession().setAttribute("order", order.get().getId());

            } else if (Context.getAdminService().getAllAvailableRoomOnDates(order.get()) != null) {
                request.setAttribute("info",
                        "There is no suitable room for user, if the user agrees, choose room from available ");
                request.setAttribute("rooms", Context.getAdminService().getAllAvailableRoomOnDates(order.get()));
                request.setAttribute("submit", true);
                request.setAttribute("delete", true);
                request.getSession().setAttribute("order", order.get().getId());
            } else {
                request.setAttribute("info", "There are no available rooms on these dates");
                request.setAttribute("next", false);
                request.setAttribute("delete", true);
            }
            //   request.setAttribute("delete", true);
        } else {

            request.setAttribute("info", "No orders");
            request.setAttribute("next", false);
            request.setAttribute("delete", false);
        }
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        LOGGER.info("POST from AdminServlet");
        CommandFactory commandFactory=new CommandFactory();
        commandFactory.executeCommand(request,response);
     /*   if (request.getParameter("delete") != null) {
            new DeleteOrder().executeCommand(request, response);
        } else {
            new UpdateOrder().executeCommand(request, response);
        }*/
    }
}
