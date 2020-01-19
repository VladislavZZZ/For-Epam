package by.javatr.task2.runner;

import by.javatr.console.ConsoleReader;
import by.javatr.exception.ArrayNullPointerException;
import by.javatr.task2.sevice.JaggedArrayMethods;

public class Main {
    public static void main(String[] args) {
        ConsoleReader consoleReader=new ConsoleReader();
        System.out.print("write number of lines: ");
        int[][] jaggedArray=new int[consoleReader.readInt()][];
        for (int i=0;i<jaggedArray.length;i++){
            System.out.print("write number of digits: ");
            jaggedArray[i]=new int[consoleReader.readInt()];
            System.out.println("Write all digits in line");
            for (int j=0;j<jaggedArray[i].length;j++){
                jaggedArray[i][j]=consoleReader.readInt();
            }
        }
        System.out.println("jagged array: ");
        printArray(jaggedArray);
        JaggedArrayMethods jAM;
        try {
            jAM = new JaggedArrayMethods(jaggedArray);

            System.out.println("sorted by sum:");
            jAM.sortByMaxElementInLane(true);
            printArray(jaggedArray);

            System.out.println("sorted by max:");
            jAM.sortByMaxElementInLane(true);
            printArray(jaggedArray);

            System.out.println("sorted by min:");
            jAM.sortByMinElementInLane(true);
            printArray(jaggedArray);

        }catch (ArrayNullPointerException ex){
            System.out.println("array cannot be empty");
        }
    }

    private static void printArray(int[][] arr){
        for (int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
