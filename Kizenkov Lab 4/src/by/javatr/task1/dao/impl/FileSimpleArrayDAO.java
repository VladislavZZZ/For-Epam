package by.javatr.task1.dao.impl;

import by.javatr.task1.bean.SimpleArray;
import by.javatr.exception.ArrayNullPointerException;
import by.javatr.task1.dao.SimpleArrayDAO;
import by.javatr.task1.dao.exception.DAOException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileSimpleArrayDAO implements SimpleArrayDAO {
    private Scanner scanner;

    @Override
    public void fillArray(SimpleArray array,String filePath)throws DAOException,ArrayNullPointerException {
        if (array==null)throw new ArrayNullPointerException("array doesn't exist");
        try {
            scanner = new Scanner(new FileReader(filePath));
        }catch (FileNotFoundException ex){
            throw new DAOException("file doesn't find");
        }
        int[] arr=new int[array.getSize()];
        for (int i=0;i<arr.length;i++){
            arr[i]=scanner.nextInt();
        }
        array.setArr(arr);
        scanner.close();
    }
}
