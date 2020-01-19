package by.javatr.command.day2.printer;

import java.util.Objects;

public class Printer {
    public static void printArray(Object[] o){
        for (Object ol:o){
            System.out.print(ol+" ");
        }
    }
    public static void printRandom(int size,boolean isLine){
        if(isLine){
            for (int i=0;i<size;i++){
                System.out.println((int)(Math.random()*100));
            }
        }else {
            for (int i = 0; i < size; i++) {
                System.out.print((int) (Math.random() * 10) + " ");
            }
        }
        System.out.println();
    }
}
