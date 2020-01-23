package by.javatr.controller.command.impl;

import by.javatr.bean.User;
import by.javatr.controller.command.Command;
import by.javatr.controller.exception.DeleteUserControllerException;
import by.javatr.resourse.TextConstants;
import by.javatr.service.FinancialService;
import by.javatr.service.UserService;
import by.javatr.service.exception.FinancialServiceException;
import by.javatr.service.exception.UserServiceException;
import by.javatr.service.factory.ServiceFactory;

public class DeleteUser implements Command {
    @Override
    public String execute(String request) throws Exception {
        String login;
        String password;
        String enteredID;
        String enteredPassword;

        String[] params = request.split(TextConstants.SPACE_DELIMITER);
        if(params.length < 5){
            throw new DeleteUserControllerException("Invalid request!");
        }

        login = params[1];
        password = params[2];
        enteredID = params[3];
        enteredPassword = params[4];

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService clientService = factory.getClientService();
        FinancialService accountService = factory.getAccountService();

        User user = new User(login,password);

        try {
            clientService.deleteUser(user, enteredID, enteredPassword);
            accountService.deleteFinancial(user.getLogin());
            return TextConstants.RESPONSE_OK + " " + TextConstants.RESPONSE_DELETE_USER_SUCCESS;
        } catch (UserServiceException | FinancialServiceException e) {
            throw new DeleteUserControllerException(TextConstants.RESPONSE_DELETE_USER_FAIL, e);
        }
    }
}
