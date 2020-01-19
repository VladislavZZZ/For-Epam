package by.javatr.day1.task3.logic;

import by.javatr.day1.exceptions.GeometricFundamentalException;
import by.javatr.day1.validation.PositiveNumberValidation;

public class SquareLogic {
    public static double areaOfInscribedInCircleSquare(double squareArea)throws GeometricFundamentalException{
        if (PositiveNumberValidation.isValid(squareArea)) {
            double squareSide = squareSide(squareArea);
            double radiusOfCircle = circleRadius(squareSide);
            return lowerSquareArea(radiusOfCircle);
        }else throw new GeometricFundamentalException("Incorrect square area count");
    }

    public static double ratioBetweenSquareAreas(double squareAreaOne,double squareAreaTwo){
        return squareAreaOne/squareAreaTwo;
    }

    private static double squareSide(double squareArea){
        return Math.sqrt(squareArea);
    }

    private static double circleRadius(double squareSide){
        return squareSide/2;
    }

    private static double lowerSquareArea(double circleRadius){
        return 2*Math.pow(circleRadius,2);
    }
}
