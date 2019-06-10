package com.hotel.controller.command.impl;

import com.hotel.controller.Context;
import com.hotel.controller.command.Command;
import com.hotel.entity.Order;
import com.hotel.entity.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

public class UpdateOrder implements Command {
    @Override
    public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long orderId = (Long) request.getSession().getAttribute("order");
        Optional<Order> order = Context.getOrderService().findById(orderId);

        Long roomId = Long.valueOf(request.getParameter("room"));
        Optional<Room> room = Context.getRoomService().findById(roomId);

        Order updatedOrder = Order.builder()
                .withId(orderId)
                .withCheckIn(order.get().getCheckIn())
                .withCheckOut(order.get().getCheckOut())
                .withOrderTime(order.get().getOrderTime())
                .withRoom(room.get())
                .withNumberOfPlaces(room.get().getNumberOfPlaces())
                .withServiceLevel(room.get().getServiceLevel())
                .withPrice(countPrice(
                        order.get().getCheckIn().toLocalDate(),
                        order.get().getCheckOut().toLocalDate(),
                        room.get().getPrice()))
                .build();
        request.getSession().removeAttribute("order");
        Context.getOrderService().update(updatedOrder);
        response.sendRedirect("/admin");
    }

    private Long countPrice(LocalDate checkInDate, LocalDate checkOutDate, Long cost) {
        return DAYS.between(checkInDate, checkOutDate) * cost;
    }
}
