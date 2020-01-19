package by.javatr.command.day2.calendar;

import by.javatr.command.day2.task6.exceptions.NegativeDayException;
import by.javatr.command.day2.task7.exception.DateInvalidException;
import by.javatr.command.day2.task7.validation.DateValidation;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class CalendarMethods {
    public static Date getDeadlineTimeFromNow(int nextDays)throws NegativeDayException{
        if (!DateValidation.isValidDay(nextDays))throw new NegativeDayException();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR,nextDays);
        return calendar.getTime();
    }

    public static int fullAge(int year,int month,int day)throws DateInvalidException{
        if (!DateValidation.isValidDate(year,month,day))throw new DateInvalidException();
        LocalDate birthDay=LocalDate.of(year,month,day);
        LocalDate currDay=LocalDate.now();
        return Period.between(birthDay,currDay).getYears();
    }
    public static boolean isBirthday(int year,int month,int day)throws DateInvalidException{
        if(!DateValidation.isValidDate(year,month,day))throw new DateInvalidException();
        Calendar birthday=Calendar.getInstance();
        birthday.setTime(new Date());
        return birthday.get(Calendar.MONTH)+1==month&& birthday.get(Calendar.DAY_OF_MONTH)==day;
    }
}
