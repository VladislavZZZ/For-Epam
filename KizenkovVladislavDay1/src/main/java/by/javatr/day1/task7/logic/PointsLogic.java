package by.javatr.day1.task7.logic;

public class PointsLogic {

    public static Point nearestPoint(Point a,Point b,Point zero){
        if (a.distance(zero)>b.distance(zero)){
            return b;
        }else return a;
    }
}
