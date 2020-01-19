package by.javatr.command.day2.task1.runner;

import by.javatr.command.day2.scanner.DataScanner;

public class Hello {

    public static void main(String[] args) {
        DataScanner dataScanner=new DataScanner();
        System.out.print("Write your name: ");
        System.out.println("Hello, "+dataScanner.findString());
    }
}
