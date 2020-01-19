package by.javatr.day1.task10.runner;

import by.javatr.day1.scanner.DataScanner;
import by.javatr.day1.task10.exceptions.IncorrectIntervalException;
import by.javatr.day1.task10.logic.TanLogic;
import by.javatr.day1.task10.printer.Printer;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args){
        DataScanner dataScanner=new DataScanner();
        System.out.print("Write an interval from a to b: ");
        try {
            double a = dataScanner.findDouble();
            double b = dataScanner.findDouble();
            System.out.print("write a step h: ");
            double h = dataScanner.findDouble();
            Printer.printTable(TanLogic.countSequence(a, b, h));
        }catch (IncorrectIntervalException ex){
            System.out.println("your orders is not correct. Try again...");
        }catch (InputMismatchException ex){
            System.out.println("incorrect format of input data");
        }
    }
}
