package by.javatr.dao.factory;

import by.javatr.dao.FinancialDAO;
import by.javatr.dao.UserDAO;
import by.javatr.dao.impl.FileFinancialDAO;
import by.javatr.dao.impl.FileUserDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final FinancialDAO financialDAO = new FileFinancialDAO();
    private final UserDAO userDAO = new FileUserDAO();

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public FinancialDAO getFinancialDAO(){
        return financialDAO;
    }

    public UserDAO getUserDAO(){
        return userDAO;
    }
}
