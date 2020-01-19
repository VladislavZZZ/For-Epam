package by.javatr.command.day2.task5.runner;

import by.javatr.command.day2.scanner.DataScanner;
import by.javatr.command.day2.task5.logic.Logic;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        DataScanner dataScanner=new DataScanner();
        try {
            int a = dataScanner.findInt(args[0]);
            int b = dataScanner.findInt(args[1]);
            System.out.println(a + " + " + b + " = " + Logic.sum(a, b));
            System.out.println(a + " * " + b + " = " + Logic.mul(a, b));
        }catch (NumberFormatException ex){
            System.out.println("Incorrect data");
        }
    }
}
