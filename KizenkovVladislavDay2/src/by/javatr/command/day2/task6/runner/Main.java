package by.javatr.command.day2.task6.runner;

import by.javatr.command.day2.scanner.DataScanner;
import by.javatr.command.day2.calendar.CalendarMethods;
import by.javatr.command.day2.task6.exceptions.NegativeDayException;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        DataScanner dataScanner=new DataScanner();
        System.out.print("Write your surname: ");
        try {
            String surname = dataScanner.findString();
            System.out.print("what number of days do you need: ");
            int dayCount = dataScanner.findInt();
            System.out.println("Dear "+surname+", your deadline will be in "+ CalendarMethods.getDeadlineTimeFromNow(dayCount).toString());
        }catch (InputMismatchException ex){
            System.out.println("Incorrect data");
        }catch (NegativeDayException ex){
            System.out.println("day can be only positive");
        }
    }
}
