package by.javatr.controller.command.impl;

import by.javatr.bean.User;
import by.javatr.controller.command.Command;
import by.javatr.controller.exception.LogInControllerException;
import by.javatr.resourse.TextConstants;
import by.javatr.service.UserService;
import by.javatr.service.exception.UserServiceException;
import by.javatr.service.factory.ServiceFactory;

public class LogIn implements Command {
    @Override
    public String execute(String request) throws Exception {
        String login;
        String password;
        String userInfo;

        String[] params = request.split(TextConstants.SPACE_DELIMITER);
        if(params.length < 3){
            throw new LogInControllerException("Invalid request!");
        }
        login = params[1];
        password = params[2];

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService clientService = factory.getClientService();

        try {
            User user = clientService.logIn(login, password);
            userInfo = user.getLogin() + " " + user.getPassword();
            return TextConstants.RESPONSE_LOG_IN_SUCCESS + "\n"
                    + TextConstants.RESPONSE_USER_INFO + "(" + userInfo + ")";
        } catch (UserServiceException e) {
            throw new LogInControllerException(TextConstants.RESPONSE_LOG_IN_FAIL, e);
        }
    }
}
