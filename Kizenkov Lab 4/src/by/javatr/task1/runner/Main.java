package by.javatr.task1.runner;

import by.javatr.task1.bean.SimpleArray;
import by.javatr.exception.ArrayNullPointerException;
import by.javatr.task1.bean.exception.SimpleArrayIncorrectSizeException;
import by.javatr.task1.service.ArrayMethods;
import by.javatr.task1.service.exception.ServiceException;

public class Main {

    public static void main(String[] args){
        SimpleArray arrayFromFile=new SimpleArray();
        try {
            ArrayMethods arrayMethods1 = new ArrayMethods(arrayFromFile);
            arrayMethods1.fillArrayFromFile(arrayFromFile, "src/by/javatr/task1/input.txt");
        }catch (ArrayNullPointerException ex){
            System.out.println("Array is not exist");
        }catch (ServiceException ex){
            System.out.println("problem with service");
        }
        System.out.println(arrayFromFile);
        arrayFromFile.doQuickSort();
        System.out.println(arrayFromFile);

        try {
            SimpleArray arrayRandom = new SimpleArray(15);
            ArrayMethods arrayMethods2 = new ArrayMethods(arrayRandom);
            arrayMethods2.fillArrayByRandomNumbers(arrayRandom,100);
            System.out.println(arrayRandom);
            arrayRandom.doInsertionSort();
            System.out.println(arrayRandom);
        }catch (ArrayNullPointerException ex){
            System.out.println("Array is not exist");
        }catch (SimpleArrayIncorrectSizeException ex){
            System.out.println("size cannot be negative or null");
        }

        try {
            SimpleArray arrayFromConsole = new SimpleArray(8);
            ArrayMethods arrayMethods3 = new ArrayMethods(arrayFromConsole);
            arrayMethods3.fillArrayFromConsole(arrayFromConsole);
            System.out.println(arrayFromConsole);
            arrayFromConsole.doBubbleSort();
            System.out.println(arrayFromConsole);
            System.out.println(arrayFromConsole.findIndex(84));
            System.out.println(arrayMethods3.findAllFibbonachiNumbers(arrayFromConsole));
            System.out.println(arrayMethods3.findAllSimpleNumbers(arrayFromConsole));
        }catch (ArrayNullPointerException ex){
            System.out.println("Array is not exist");
        }catch (SimpleArrayIncorrectSizeException ex){
            System.out.println("size cannot be negative or null");
        }
    }
}
