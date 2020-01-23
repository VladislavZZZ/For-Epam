package by.javatr.controller;

import by.javatr.controller.command.Command;
import by.javatr.controller.command.CommandName;
import by.javatr.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.SIGN_UP, new SignUp());
        repository.put(CommandName.LOG_IN, new LogIn());
        repository.put(CommandName.DELETE_USER, new DeleteUser());
        repository.put(CommandName.CHANGE_INCOME, new ChangeIncome());
        repository.put(CommandName.CHANGE_EXPENSES, new ChangeExpenses());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());

    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
