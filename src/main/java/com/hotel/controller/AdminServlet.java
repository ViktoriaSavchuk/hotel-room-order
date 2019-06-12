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
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

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
                request.setAttribute("info", ResourceBundle.getBundle("message",
                        Locale.forLanguageTag((String) request.getSession().getAttribute("lang"))).getString("choose.suitable.room"));
                request.setAttribute("rooms", Context.getAdminService().getAllSuitableRooms(order.get()));
                request.setAttribute("next", true);
                request.setAttribute("delete", false);
                request.getSession().setAttribute("order", order.get().getId());

            } else if (Context.getAdminService().getAllAvailableRoomOnDates(order.get()) != null) {
                request.setAttribute("info",
                        ResourceBundle.getBundle("message",
                                Locale.forLanguageTag((String) request.getSession().getAttribute("lang"))).getString("no.suitable"));

                request.setAttribute("rooms", Context.getAdminService().getAllAvailableRoomOnDates(order.get()));
                request.setAttribute("submit", true);
                request.setAttribute("delete", true);
                request.getSession().setAttribute("order", order.get().getId());
            } else {
                request.setAttribute("info", ResourceBundle.getBundle("message",
                        Locale.forLanguageTag((String) request.getSession().getAttribute("lang"))).getString("no.available"));
                request.setAttribute("next", false);
                request.setAttribute("delete", true);
            }
        } else {

            request.setAttribute("info", ResourceBundle.getBundle("message",
                    Locale.forLanguageTag((String) request.getSession().getAttribute("lang"))).getString("no.orders"));
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
