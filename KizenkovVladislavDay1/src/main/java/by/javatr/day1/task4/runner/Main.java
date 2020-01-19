package by.javatr.day1.task4.runner;

import by.javatr.day1.scanner.DataScanner;
import by.javatr.day1.task4.logic.Logic;

import java.util.InputMismatchException;


public class Main {
    public static void main(String[] args){
        try {
            DataScanner dataScanner = new DataScanner();
            System.out.print("Write 4 integers separated by space: ");
            System.out.println(Logic.hasTwoOrMoreEven(dataScanner.findIntArray(4)));
        }catch (InputMismatchException ex){
            System.out.println("Illegal type of input data");
        }
    }
}
