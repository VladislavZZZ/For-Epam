package by.javatr.dao;

import by.javatr.bean.User;
import by.javatr.dao.exception.DAOException;

public interface UserDAO {
    void signUp(String login, String password) throws DAOException;
    User logIn(String login, String password) throws DAOException;
    void deleteUser(String login) throws DAOException;
}
