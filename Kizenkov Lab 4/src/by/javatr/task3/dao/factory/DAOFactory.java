package by.javatr.task3.dao.factory;

import by.javatr.task3.dao.MessageDAO;
import by.javatr.task3.dao.impl.FileMessageDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final MessageDAO fileMessageDAO=new FileMessageDAO();

    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return instance;
    }

    public MessageDAO getFileSimpleArrayDAO(){
        return fileMessageDAO;
    }
}
