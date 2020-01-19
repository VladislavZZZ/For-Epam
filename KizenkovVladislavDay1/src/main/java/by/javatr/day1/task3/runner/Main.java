package by.javatr.day1.task3.runner;

import by.javatr.day1.scanner.DataScanner;
import by.javatr.day1.exceptions.GeometricFundamentalException;
import by.javatr.day1.task3.logic.SquareLogic;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args){
            DataScanner dataScanner = new DataScanner();
            System.out.print("Write a greater square area: ");
            try {
                double greaterSquareArea = dataScanner.findDouble();
                double lowerSquareArea = SquareLogic.areaOfInscribedInCircleSquare(greaterSquareArea);
                System.out.println("Area of less square is "
                        + lowerSquareArea);
                System.out.println("Smaller square is "
                        + SquareLogic.ratioBetweenSquareAreas(greaterSquareArea, lowerSquareArea)
                        + " times less than a larger square");
            }catch (GeometricFundamentalException ex) {
                System.out.println(ex.getMessage());
            }catch (InputMismatchException ex) {
                System.out.println("Incorrect format data");
            }

    }
}
