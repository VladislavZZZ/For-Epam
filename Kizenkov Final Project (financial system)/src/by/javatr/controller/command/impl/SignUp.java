package by.javatr.controller.command.impl;

import by.javatr.bean.Financial;
import by.javatr.controller.command.Command;
import by.javatr.controller.exception.SignUpControllerException;
import by.javatr.resourse.TextConstants;
import by.javatr.service.FinancialService;
import by.javatr.service.UserService;
import by.javatr.service.exception.FinancialServiceException;
import by.javatr.service.exception.UserServiceException;
import by.javatr.service.factory.ServiceFactory;

public class SignUp implements Command {
    @Override
    public String execute(String request) throws Exception {
        String login;
        String password;
        Financial newFinancial;

        String[] params = request.split(TextConstants.SPACE_DELIMITER);
        if(params.length < 3){
            throw new SignUpControllerException("Invalid request!");
        }

        login = params[1];
        password = params[2];

        ServiceFactory factory = ServiceFactory.getInstance();
       UserService clientService = factory.getClientService();
        FinancialService financialService = factory.getAccountService();

        try {
            clientService.signUp(login, password);
            newFinancial= new Financial();
            newFinancial.setLogin(login);
            newFinancial.setGain(0);
            newFinancial.setSpend(0);
            financialService.addFinancial(newFinancial);
        } catch (UserServiceException | FinancialServiceException e) {
            throw new SignUpControllerException(TextConstants.RESPONSE_SIGN_UP_FAIL, e);
        }
        return TextConstants.RESPONSE_SIGN_UP_SUCCESS;
    }
}
