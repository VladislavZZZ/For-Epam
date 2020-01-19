package by.javatr.day1.task7.runner;

import by.javatr.day1.scanner.DataScanner;
import by.javatr.day1.task7.logic.Point;
import by.javatr.day1.task7.logic.PointsLogic;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args){
        DataScanner dataScanner=new DataScanner();
        Point zeroPoint=new Point(0,0);
        System.out.println("Write coordinates of point A: ");
        try {
            Point A = new Point(dataScanner.findDouble(), dataScanner.findDouble());
            System.out.println("Write coordinates of point B: ");
            Point B = new Point(dataScanner.findDouble(), dataScanner.findDouble());
            System.out.println("Point " + PointsLogic.nearestPoint(A, B, zeroPoint) + " is closer one");
        }catch (InputMismatchException ex){
            System.out.println("your input format is not correct");
        }
    }
}
