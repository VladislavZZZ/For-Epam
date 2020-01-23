package by.javatr.service;

import by.javatr.bean.User;
import by.javatr.service.exception.UserServiceException;

public interface UserService {
    void signUp(String login, String password) throws UserServiceException;
    User logIn(String login, String password) throws UserServiceException;
    void deleteUser(User user, String login, String password) throws UserServiceException;
}
