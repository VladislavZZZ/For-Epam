package by.javatr.controller.command.impl;

import by.javatr.bean.User;
import by.javatr.controller.command.Command;
import by.javatr.controller.exception.ChangeSpendControllerException;
import by.javatr.resourse.TextConstants;
import by.javatr.service.FinancialService;
import by.javatr.service.exception.FinancialServiceException;
import by.javatr.service.factory.ServiceFactory;

public class ChangeExpenses implements Command {

    @Override
    public String execute(String request) throws Exception {
        String login;
        String password;
        String newExpenses;

        String[] params = request.split(TextConstants.SPACE_DELIMITER);
        if(params.length < 4){
            throw new ChangeSpendControllerException("Invalid request!");
        }

        login = params[1];
        password = params[2];
        newExpenses = params[3];

        ServiceFactory factory = ServiceFactory.getInstance();
        FinancialService accountService = factory.getAccountService();
        User user = new User(login,password);

        try {
            accountService.changeExpenses(user, newExpenses);
            return TextConstants.RESPONSE_CHANGE_SPEND_SUCCESS;
        } catch (FinancialServiceException e) {
            throw new ChangeSpendControllerException(TextConstants.RESPONSE_CHANGE_SPEND_FAIL, e);
        }
    }
}
