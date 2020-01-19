package by.javatr.task1.dao.factory;

import by.javatr.task1.dao.SimpleArrayDAO;
import by.javatr.task1.dao.impl.FileSimpleArrayDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final SimpleArrayDAO fileSimpleArrayDAO=new FileSimpleArrayDAO();

    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return instance;
    }

    public SimpleArrayDAO getFileSimpleArrayDAO(){
        return fileSimpleArrayDAO;
    }
}
