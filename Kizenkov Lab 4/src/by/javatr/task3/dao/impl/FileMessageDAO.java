package by.javatr.task3.dao.impl;

import by.javatr.task3.dao.MessageDAO;
import by.javatr.task3.dao.exception.DAOException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileMessageDAO implements MessageDAO {
    private Scanner scanner;

    @Override
    public String readMessage(String filepath) throws DAOException{
        try {
            scanner = new Scanner(new FileReader(filepath));
        }catch (FileNotFoundException ex){
            throw new DAOException("file not found");
        }
        StringBuilder sb=new StringBuilder();
        while (scanner.hasNext()){
            sb.append(scanner.next());
        }
        return sb.toString();
    }
}
