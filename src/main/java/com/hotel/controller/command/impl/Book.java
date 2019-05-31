package com.hotel.controller.command.impl;

import com.hotel.controller.Context;
import com.hotel.controller.command.Command;
import com.hotel.entity.Order;
import com.hotel.entity.ServiceLevel;
import com.hotel.utils.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Book implements Command {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd MMM yyyy");
    private static final Logger LOGGER = LogManager.getLogger(Book.class);


    @Override
    public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String[] serviceLevel = request.getParameter("level").split("=");

        LocalDate checkInDate = LocalDate.parse(request.getParameter("check_in"), DATE_FORMATTER);
        LocalDate checkOutDate = LocalDate.parse(request.getParameter("check_out"), DATE_FORMATTER);

        if (Validator.datesAreValid(checkInDate,checkOutDate)) {

            Context.getOrderService().create(Order.builder()
                    .withUser(Context.getUserService().findById((Long) request.getSession().getAttribute("id")).get())
                    .withOrderTime(LocalDateTime.now())
                    .withCheckIn(checkInDate.atStartOfDay())
                    .withCheckOut(checkOutDate.atStartOfDay())
                    .withServiceLevel(new ServiceLevel(Long.valueOf(serviceLevel[0]), serviceLevel[1]))
                    .withNumberOfPlaces(Integer.valueOf(request.getParameter("number")))
                    .build());

            LOGGER.info("order was created for user with id"+request.getSession().getAttribute("id"));
            response.sendRedirect("/user");

        } else {
            LOGGER.info("user with id "+request.getSession().getAttribute("id")+ "chose unreal pairs of dates");
            request.setAttribute("errorMessage",
                    "Choose correct dates: \nCheck-in date should be before check-out and after today");
            executeCommand(request, response);
        }
    }
}
