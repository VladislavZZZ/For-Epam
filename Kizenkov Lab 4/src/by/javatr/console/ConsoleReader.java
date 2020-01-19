package by.javatr.console;

import java.util.Scanner;

public class ConsoleReader {
    private Scanner sc;

    public ConsoleReader(){
        sc=new Scanner(System.in);
    }

    public int readInt(){
        return sc.nextInt();
    }

    public String readString(){
        return sc.next();
    }
}
