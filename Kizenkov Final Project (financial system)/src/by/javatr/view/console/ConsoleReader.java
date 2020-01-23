package by.javatr.view.console;

import by.javatr.view.console.exception.NoInputInLineException;
import by.javatr.view.console.exception.NoNumberInLineException;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleReader {
    private static final ConsoleReader instance = new ConsoleReader();

    private ConsoleReader(){}

    public int scanInt(InputStream source) throws NoNumberInLineException {
        Scanner sc = new Scanner(source);
        int scannedValue = 0;
        while(sc.hasNext()){
            if(sc.hasNextInt()){
                scannedValue = sc.nextInt();
                return scannedValue;
            }
            sc.next();
        }
        throw new NoNumberInLineException();
    }

    public double scanDouble(InputStream source) throws NoNumberInLineException {
        Scanner sc = new Scanner(source);
        double scannedValue = 0;
        while(sc.hasNext()){
            if(sc.hasNextDouble()){
                scannedValue = sc.nextDouble();
                return scannedValue;
            }
            sc.next();
        }
        throw new NoNumberInLineException();
    }

    public String scanLine(InputStream source) throws NoInputInLineException {
        Scanner sc = new Scanner(source);
        if(sc.hasNext()){
            return sc.nextLine();
        }
        throw new NoInputInLineException();
    }

    public static ConsoleReader getInstance(){
        return instance;
    }
}
