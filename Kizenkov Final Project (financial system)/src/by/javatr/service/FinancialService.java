package by.javatr.service;

import by.javatr.bean.Financial;
import by.javatr.bean.User;
import by.javatr.service.exception.FinancialServiceException;

public interface FinancialService {
    void changeIncome(User user, String newGain) throws FinancialServiceException;
    void changeExpenses(User user, String newSpend) throws FinancialServiceException;
    void addFinancial(Financial financial) throws FinancialServiceException;
    void deleteFinancial(String login) throws FinancialServiceException;
}
