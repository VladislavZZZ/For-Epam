package by.javatr.day1.task2.logic;

import by.javatr.day1.task2.exceptions.DateIncorrectFormatException;

import java.util.Calendar;

public class CountDaysOfMonthFinder {


    public static int findNumberOfDaysInMonth(int year,int month)throws DateIncorrectFormatException{
        Calendar calendar=Calendar.getInstance();
        if (!isValidData(year,month))
            throw new DateIncorrectFormatException("Incorrect input format of date");

        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    private static boolean isValidData(int year,int month){
        return isValidYear(year)&&isValidMonth(month);
    }

    private static boolean isValidYear(int year){
            return year>0 && year<2020;
    }

    private static boolean isValidMonth(int month){
        return month>=Calendar.JANUARY&&month<=Calendar.DECEMBER;
    }

}
