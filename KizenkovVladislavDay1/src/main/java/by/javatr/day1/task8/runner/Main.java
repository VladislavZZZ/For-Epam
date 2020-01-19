package by.javatr.day1.task8.runner;

import by.javatr.day1.scanner.DataScanner;
import by.javatr.day1.task8.logic.Funcs;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args){
        DataScanner dataScanner=new DataScanner();
        System.out.print("Write variable x: ");
        try{
            double x=dataScanner.findDouble();
            System.out.println("Answer is "+ Funcs.solve(x));
        }catch (InputMismatchException ex){
            System.out.println("Input data is incorrect");
        }
    }
}
