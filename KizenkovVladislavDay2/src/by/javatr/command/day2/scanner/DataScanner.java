package by.javatr.command.day2.scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataScanner {
    private Scanner scanner;

    public DataScanner() {
        this.scanner =new Scanner(System.in);
    }

    public int findInt()throws InputMismatchException {
        return scanner.nextInt();
    }
    public int findInt(String s)throws NumberFormatException{
        return Integer.parseInt(s);
    }

    public double findDouble()throws InputMismatchException{
        return scanner.nextDouble();
    }

    public String findString(){
        return scanner.next();
    }

    public int[] findIntArray(int size){
        int[] arr=new int[size];
        for (int i=0;i<size;i++ ){
            arr[i]=findInt();
        }
        return arr;
    }

}
