package by.javatr.day1.task10.printer;

import java.util.Map;

public class Printer {

    public static void printTable(Map<Double,Double> map){
        for (Map.Entry<Double,Double> entry: map.entrySet()){
            System.out.println(entry.getKey()+" -> "+ entry.getValue());
        }
    }
}
