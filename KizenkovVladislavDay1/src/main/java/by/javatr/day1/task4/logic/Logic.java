package by.javatr.day1.task4.logic;

public class Logic {
    public static boolean hasTwoOrMoreEven(int[] arr){
        return countOfEven(arr)>1;
    }

    private static int countOfEven(int[]arr){
        int count=0;
        for (int digit:arr){
            if(digit%2==0)
                count++;
        }
        return count;
    }
}
