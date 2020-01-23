package by.javatr.controller.command.impl;

import by.javatr.controller.command.Command;
import by.javatr.controller.exception.WrongRequestControllerException;

public class WrongRequest implements Command {
    @Override
    public String execute(String request) throws Exception {
        throw new WrongRequestControllerException("Invalid request!");
    }
}
