package by.javatr.day1.task1.logic;

import by.javatr.day1.scanner.DataScanner;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class LastDigitOfNumberFoundingTest {

    @Test
    void getLastDigitOfSquare_Common_Variant() {
        int actual=LastDigitOfNumberFounding.getLastDigitOfSquare(5);
        int expected=5;
        assertEquals(expected,actual);
    }

    @Test
    void getLastDigitOfSquare_Negative_Variant() {
        int actual=LastDigitOfNumberFounding.getLastDigitOfSquare(-5);
        int expected=5;
        assertEquals(expected,actual);
    }

    @Test
    void getLastDigitOfSquare_Zero_Variant() {
        int actual=LastDigitOfNumberFounding.getLastDigitOfSquare(0);
        int expected=0;
        assertEquals(expected,actual);
    }
}