package by.javatr.day1.task2.runner;

import by.javatr.day1.scanner.DataScanner;
import by.javatr.day1.task2.exceptions.DateIncorrectFormatException;
import by.javatr.day1.task2.logic.CountDaysOfMonthFinder;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args){
            DataScanner dataScanner=new DataScanner();
            System.out.print("Write a year: ");
            try {
                int year = dataScanner.findInt();
                System.out.print("Write number of month: ");
                int month = dataScanner.findInt();
                System.out.println("Count of days in current month is " + CountDaysOfMonthFinder.findNumberOfDaysInMonth(year, month-1));
            }catch (DateIncorrectFormatException ex) {
                System.out.println(ex.getMessage());
            }catch (InputMismatchException ex){
            System.out.println("Incorrect year... Write a number");
        }
    }
}
