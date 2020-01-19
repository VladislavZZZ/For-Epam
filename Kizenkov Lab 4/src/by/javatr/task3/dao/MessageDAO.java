package by.javatr.task3.dao;

import by.javatr.task3.dao.exception.DAOException;

public interface MessageDAO {
    public String readMessage(String filepath) throws DAOException;
}
