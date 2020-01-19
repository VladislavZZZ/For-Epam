package by.javatr.command.day2.task4.runner;

import by.javatr.command.day2.scanner.DataScanner;
import by.javatr.command.day2.task4.password.Password;

public class Main {
    public static void main(String[] args) {
        DataScanner dataScanner=new DataScanner();
        System.out.print("Write a password: ");
        if (Password.isEqual(dataScanner.findString())){
            System.out.println("Password is correct, welcome!");
        }else{
            System.out.print("Password is incorrect, try again");
        }
    }
}
