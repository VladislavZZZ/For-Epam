package by.javatr.service.impl;

import by.javatr.bean.User;
import by.javatr.dao.UserDAO;
import by.javatr.dao.exception.DAOException;
import by.javatr.dao.factory.DAOFactory;
import by.javatr.service.UserService;
import by.javatr.service.exception.UserServiceException;
import by.javatr.service.validation.Validator;

public class UserServiceImpl implements UserService {
    @Override
    public void signUp(String login, String password) throws UserServiceException {
        Validator validator = Validator.getInstance();
        if(!validator.isValidLoginOrPassword(login) || !validator.isValidLoginOrPassword(password)){
            throw new UserServiceException("Invalid login or password!");
        }
        UserDAO userDAO = getUserDAO();
        try {
            userDAO.signUp(login, password);
        } catch (DAOException e) {
            throw new UserServiceException(e);
        }
    }

    @Override
    public User logIn(String login, String password) throws UserServiceException {
        Validator validator = Validator.getInstance();
        if(!validator.isValidLoginOrPassword(login) || !validator.isValidLoginOrPassword(password)){
            throw new UserServiceException("Invalid login or password!");
        }
        UserDAO userDAO = getUserDAO();
        try {
            return userDAO.logIn(login, password);
        } catch (DAOException e) {
            throw new UserServiceException("Error occurred while logging in!", e);
        }    }

    @Override
    public void deleteUser(User user, String login, String password) throws UserServiceException {
        if(user == null){
            throw new UserServiceException("Null user passed!");
        }
        Validator validator = Validator.getInstance();
        if(!validator.isValidLoginOrPassword(login) || !validator.isValidLoginOrPassword(password)){
            throw new UserServiceException("Invalid login or password!");
        }
        if(!validator.dataMatches(user, login, password)){
            throw new UserServiceException("Incorrect login or password!");
        }
        UserDAO userDAO = getUserDAO();
        try {
            userDAO.deleteUser(login);
        } catch (DAOException e) {
            throw new UserServiceException("Error occurred while deleting user!", e);
        }
    }
    private UserDAO getUserDAO(){
        DAOFactory factory = DAOFactory.getInstance();
        return factory.getUserDAO();
    }
}
