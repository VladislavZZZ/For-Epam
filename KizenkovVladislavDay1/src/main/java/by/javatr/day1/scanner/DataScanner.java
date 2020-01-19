package by.javatr.day1.scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataScanner {
    private Scanner scanner;

    public DataScanner(){
        scanner=new Scanner(System.in);
    }

    public int findInt()throws InputMismatchException{
        return scanner.nextInt();
    }

    public double findDouble()throws InputMismatchException {
        return scanner.nextDouble();
    }

    public int[] findIntArray(int size)throws InputMismatchException {
        int[] arr=new int[size];
        for (int i=0;i<size;i++)
            arr[i]=scanner.nextInt();
        return arr;
    }
}
