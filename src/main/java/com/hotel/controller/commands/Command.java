package com.hotel.controller.commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface Command {

    default void executeCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    default void executeCommand(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession)
            throws ServletException, IOException {
    }
}
