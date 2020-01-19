package by.javatr.day1.task8.logic;

public class Funcs {
    public static double solve(double x){
        return function(x);
    }

    private static double function(double x){
        return x<3 ? 1/(x*x*x-6) : -x*x+3*x+9;
    }
}
