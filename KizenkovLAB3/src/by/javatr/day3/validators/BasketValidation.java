package by.javatr.day3.validators;

public class BasketValidation {
    public static boolean isValidSize(int size){
        return size>0;
    }

    public static boolean isOverloaded(int size, int countOfBalls){
        return size<countOfBalls;
    }
}
