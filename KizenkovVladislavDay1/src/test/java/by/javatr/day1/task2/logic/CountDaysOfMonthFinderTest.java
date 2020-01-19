package by.javatr.day1.task2.logic;

import by.javatr.day1.task2.exceptions.DateIncorrectFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountDaysOfMonthFinderTest {

    @Test
    void findNumberOfDaysInMonth_Common_Variant()throws DateIncorrectFormatException {
        int actual=CountDaysOfMonthFinder.findNumberOfDaysInMonth(2019,12);
        int expected=31;
        assertEquals(expected,actual);
    }
}