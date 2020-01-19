package by.javatr.day1.task1.logic;

public class LastDigitOfNumberFounding {
    public static int getLastDigitOfSquare(int number){
        return getLastDigitOfNumber((int)Math.pow(getLastDigitOfNumber(number)%10,2));
    }

    private static int getLastDigitOfNumber(int number){
        return number%10;
    }
}
