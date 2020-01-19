package by.javatr.day1.task5.runner;

import by.javatr.day1.scanner.DataScanner;
import by.javatr.day1.task5.logic.NumberCharacteristic;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args){
        DataScanner dataScanner=new DataScanner();
        System.out.print("Write a number: ");
        try{
            int number = dataScanner.findInt();
            System.out.println(NumberCharacteristic.isPerfect(number));
        }catch (InputMismatchException ex){
            System.out.println("Incorrect format of data");
        }
    }
}
