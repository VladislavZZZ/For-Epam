package by.javatr.command.day2.task7.validation;

public class DateValidation {
    public static boolean isValidDate(int year,int month,int day){
        return isValidDay(day)&&isValidMonth(month)&&isValidYear(year);
    }
    private static boolean isValidYear(int year){
        return year>0&&year<2020;
    }
    private static boolean isValidMonth(int month){
        return month>0&&month<13;
    }
    public static boolean isValidDay(int day){
        return day>0&&day<32;
    }
}
