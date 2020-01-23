package by.javatr.dao;

import by.javatr.bean.Financial;
import by.javatr.dao.exception.DAOException;

public interface FinancialDAO {
    Financial getFinancial(String login) throws DAOException;
    void updateFinancial(Financial financial) throws DAOException;
    void addFinancial(Financial financial) throws DAOException;
    void deleteFinancial(String login) throws DAOException;
}
