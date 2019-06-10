package com.hotel.controller.command.impl;

import com.hotel.controller.Context;
import com.hotel.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteOrder implements Command {
    @Override
    public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long orderId = (Long) request.getSession().getAttribute("order");
        Context.getOrderService().deleteById(orderId);
        response.sendRedirect("/admin");
    }
}
