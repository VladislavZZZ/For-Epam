package by.javatr.day1.task9.runner;

import by.javatr.day1.scanner.DataScanner;
import by.javatr.day1.exceptions.GeometricFundamentalException;
import by.javatr.day1.task9.logic.CircleLogic;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args){
        DataScanner dataScanner=new DataScanner();
        System.out.println("Write a length of radius: ");
        try {
            double radius = dataScanner.findDouble();
            System.out.println("The length of circle is " + CircleLogic.lengthOfCircle(radius));
            System.out.println("The area of circle is " + CircleLogic.areaOfCircle(radius));
        }catch (GeometricFundamentalException ex){
            System.out.println("radius can only be positive or null");
        }catch (InputMismatchException ex){
            System.out.println("format data is incorrect");
        }
    }
}
