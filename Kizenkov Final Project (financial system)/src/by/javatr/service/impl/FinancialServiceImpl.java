package by.javatr.service.impl;

import by.javatr.bean.Financial;
import by.javatr.bean.User;
import by.javatr.dao.FinancialDAO;
import by.javatr.dao.exception.DAOException;
import by.javatr.dao.factory.DAOFactory;
import by.javatr.service.FinancialService;
import by.javatr.service.exception.FinancialServiceException;

public class FinancialServiceImpl implements FinancialService {

    @Override
    public void changeIncome(User user, String newIncome) throws FinancialServiceException {
        if(user == null){
            throw new FinancialServiceException("Null user passed!");
        }
        double gain;
        try{
            gain = Double.parseDouble(newIncome);
        } catch(NumberFormatException e){
            throw new FinancialServiceException("Invalid gain value!", e);
        }
        if(gain < 0){
            throw new FinancialServiceException("Negative gain value!");
        }
        FinancialDAO financialDAO = getFinancialDAO();
        try {
            Financial financial = financialDAO.getFinancial(user.getLogin());
            financial.setGain(gain);
            financialDAO.updateFinancial(financial);
        } catch (DAOException e) {
            throw new FinancialServiceException(e);
        }
    }

    @Override
    public void changeExpenses(User user, String newExpenses) throws FinancialServiceException {
        if(user == null){
            throw new FinancialServiceException("Null user passed!");
        }
        double spend;
        try{
            spend = Double.parseDouble(newExpenses);
        } catch(NumberFormatException e){
            throw new FinancialServiceException("Invalid spend value!", e);
        }
        if(spend < 0){
            throw new FinancialServiceException("Negative spend value!");
        }
        FinancialDAO financialDAO = getFinancialDAO();
        try {
            Financial financial = financialDAO.getFinancial(user.getLogin());
            financial.setSpend(spend);
            financialDAO.updateFinancial(financial);
        } catch (DAOException e) {
            throw new FinancialServiceException(e);
        }
    }

    @Override
    public void addFinancial(Financial financial) throws FinancialServiceException {
        if(financial == null){
            throw new FinancialServiceException("Null account object passed!");
        }
        FinancialDAO financialDAO = getFinancialDAO();
        try {
            financialDAO.addFinancial(financial);
        } catch (DAOException e) {
            throw new FinancialServiceException(e);
        }
    }

    @Override
    public void deleteFinancial(String login) throws FinancialServiceException {
        if(login == null){
            throw new FinancialServiceException("Null string passed!");
        }
        DAOFactory factory = DAOFactory.getInstance();
        FinancialDAO financialDAO = factory.getFinancialDAO();
        try {
            financialDAO.deleteFinancial(login);
        } catch (DAOException e) {
            throw new FinancialServiceException(e);
        }
    }


    private FinancialDAO getFinancialDAO(){
        DAOFactory factory = DAOFactory.getInstance();
        return factory.getFinancialDAO();
    }
}
