package by.javatr.day1.task6.logic;

import by.javatr.day1.task6.Exceptions.InvalidTimeException;

public class CurrentTime {

    private static final int MIN_MILLIS=0;
    private static final int MAX_MILLIS=86400;

    public static int countOfHours(int millis)throws InvalidTimeException{
        if (!isValidTime(millis)) throw new InvalidTimeException("Incorrect input data");
        return countOfMinutes(millis)/60;
    }

    public static int countOfMinutes(int millis)throws InvalidTimeException{
        if (!isValidTime(millis)) throw new InvalidTimeException("Incorrect input data");
        return millis/60;
    }

    private static boolean isValidTime(int millis){
        return millis>=MIN_MILLIS && millis<MAX_MILLIS;
    }
}
