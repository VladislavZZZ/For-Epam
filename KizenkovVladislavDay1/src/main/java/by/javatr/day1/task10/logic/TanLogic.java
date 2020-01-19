package by.javatr.day1.task10.logic;

import by.javatr.day1.task10.exceptions.IncorrectIntervalException;
import by.javatr.day1.validation.PositiveNumberValidation;

import java.util.LinkedHashMap;
import java.util.Map;

public class TanLogic {

    private static double func(double x){
        return Math.tan(x);
    }

    public static Map<Double,Double> countSequence(double a,double b,double h)throws IncorrectIntervalException{
        if (!isValid(a,b,h))throw new IncorrectIntervalException("interval is wrong");
        Map<Double,Double> map=new LinkedHashMap<Double, Double>(); //потому что необходимо хранить элемент и отображение, а HashMap несинхронизирована
        double cur=a;
        while(cur<b){
            map.put(cur,func(cur));
            cur+=h;
        }
        return map;
    }


    private static boolean isValid(double a,double b, double h){
        return isValidAB(a,b)&& PositiveNumberValidation.isValid(h);
    }

    private static boolean isValidAB(double a,double b){
        return a<b;
    }




}
