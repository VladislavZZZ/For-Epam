package by.javatr.command.day2.task3.runner;

import by.javatr.command.day2.printer.Printer;
import by.javatr.command.day2.scanner.DataScanner;

public class Main {
    public static final String TRUE="true";
    public static final String FALSE="false";

    public static void main(String[] args) {
        DataScanner dataScanner=new DataScanner();
        try {
            int n=dataScanner.findInt(args[0]);
            switch (args[1]){
                case TRUE:{
                    Printer.printRandom(n,true);
                    break;
                }
                case FALSE:{
                    Printer.printRandom(n,false);
                } default:{
                    System.out.print("second parameter is incorrect");
                }
            }
        }catch (NumberFormatException ex){
            System.out.println("The number is incorrect");
        }

    }
}
