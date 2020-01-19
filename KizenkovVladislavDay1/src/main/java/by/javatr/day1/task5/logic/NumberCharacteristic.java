package by.javatr.day1.task5.logic;

public class NumberCharacteristic {

    public static boolean isPerfect(int number){
        int absoluteValue=Math.abs(number);
        return absoluteValue==sumOfAllDivisors(absoluteValue);
    }

    private static int sumOfAllDivisors(int number){
        int sum=1;
        for (int i=2;i<=number/2;i++){
            if (number%i==0){
                sum+=i;
            }
        }
        return sum;
    }
}
