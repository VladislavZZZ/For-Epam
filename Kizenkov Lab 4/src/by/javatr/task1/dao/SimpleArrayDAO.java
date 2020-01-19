package by.javatr.task1.dao;

import by.javatr.task1.bean.SimpleArray;
import by.javatr.exception.ArrayNullPointerException;
import by.javatr.task1.dao.exception.DAOException;

public interface SimpleArrayDAO {
    void fillArray (SimpleArray array,String file) throws DAOException, ArrayNullPointerException;
}
