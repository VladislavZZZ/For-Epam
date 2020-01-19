package by.javatr.day1.task1.runner;

import by.javatr.day1.scanner.DataScanner;
import by.javatr.day1.task1.logic.LastDigitOfNumberFounding;

import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        DataScanner scanner=new DataScanner();
        System.out.print("Write a number: ");
        try {
            int number =scanner.findInt();
            System.out.println("Last digit of square is " + LastDigitOfNumberFounding.getLastDigitOfSquare(number));
        }catch (InputMismatchException ex){
            System.out.println("Incorrect input data");
        }
    }
}
