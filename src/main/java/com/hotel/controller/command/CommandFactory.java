package com.hotel.controller.command;

import com.hotel.controller.command.impl.Book;
import com.hotel.controller.command.impl.DeleteOrder;
import com.hotel.controller.command.impl.Logout;
import com.hotel.controller.command.impl.UpdateOrder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandFactory implements Command {


    @Override
    public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");

        System.out.println(command);

        switch (command) {
            case "logout": {
                new Logout().executeCommand(request, response);
                break;
            }
            case "book": {
                new Book().executeCommand(request, response);
                break;
            }
            case "delete": {
                new DeleteOrder().executeCommand(request, response);
                break;
            }
            case "update": {
                new UpdateOrder().executeCommand(request, response);
                break;
            }
        }
    }
}
