package by.javatr.day1.task6.runner;

import by.javatr.day1.scanner.DataScanner;
import by.javatr.day1.task6.Exceptions.InvalidTimeException;
import by.javatr.day1.task6.logic.CurrentTime;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args){
        DataScanner dataScanner=new DataScanner();
        System.out.print("Write number of milliseconds: ");
        try {
            int currentMillis = dataScanner.findInt();
            System.out.println("seconds -> "+currentMillis);
            System.out.println("minutes -> " + CurrentTime.countOfMinutes(currentMillis));
            System.out.println("hours -> " + CurrentTime.countOfHours(currentMillis));
        }catch (InputMismatchException ex){
            System.out.println("Wrong format of data");
        }catch (InvalidTimeException ex){
            System.out.println("Date format is out of range");
        }
    }
}
