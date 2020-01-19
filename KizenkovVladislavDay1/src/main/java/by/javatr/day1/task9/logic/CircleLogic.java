package by.javatr.day1.task9.logic;

import by.javatr.day1.exceptions.GeometricFundamentalException;
import by.javatr.day1.validation.PositiveNumberValidation;

public class CircleLogic {

    private static final double pi=Math.PI;

    public static double lengthOfCircle(double radius)throws GeometricFundamentalException{
        if (!PositiveNumberValidation.isValid(radius))
            throw new GeometricFundamentalException("radius is negative");
        return 2*pi*radius;
    }

    public static double areaOfCircle(double radius)throws GeometricFundamentalException{
        if (!PositiveNumberValidation.isValid(radius))
            throw new GeometricFundamentalException("radius is negative");
        return pi*radius*radius;
    }
}
