package by.javatr.command.day2.task7.runner;

import by.javatr.command.day2.calendar.CalendarMethods;
import by.javatr.command.day2.scanner.DataScanner;
import by.javatr.command.day2.task7.exception.DateInvalidException;

import java.util.InputMismatchException;

public class Main  {
    public static void main(String[] args) {
        DataScanner dataScanner=new DataScanner();
        System.out.print("write /day month year/ by space: ");
        try {
            int[] date = dataScanner.findIntArray(3);
            System.out.println("you are " + CalendarMethods.fullAge(date[2], date[1], date[0]));
            if (CalendarMethods.isBirthday(date[2], date[1], date[0])) {
                System.out.print("HAPPY BIRTHDAY!!!");
            }
        }catch (InputMismatchException ex){
            System.out.print("format of data is incorrect");
        }catch (DateInvalidException ex){
            System.out.print("date is out of range");
        }
    }
}
