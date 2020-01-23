package by.javatr.service.factory;

import by.javatr.service.FinancialService;
import by.javatr.service.UserService;
import by.javatr.service.impl.FinancialServiceImpl;
import by.javatr.service.impl.UserServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final FinancialService accountService = new FinancialServiceImpl();
    private final UserService clientService = new UserServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public FinancialService getAccountService(){
        return accountService;
    }

    public UserService getClientService() {
        return clientService;
    }
}
