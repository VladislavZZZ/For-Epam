package by.javatr.command.day2.task2.runner;

import by.javatr.command.day2.printer.Printer;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Collections.reverse(Arrays.asList(args));
        Printer.printArray(args);
    }
}
