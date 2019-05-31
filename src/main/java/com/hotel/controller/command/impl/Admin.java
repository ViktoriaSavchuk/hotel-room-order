package com.hotel.controller.command.impl;

import com.hotel.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Admin implements Command {
    @Override
    public void executeCommand(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //special rooms
        //all free rooms on this dates
    }
}
