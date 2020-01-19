package by.javatr.task3.runner;

import by.javatr.task3.service.StringEditor;
import by.javatr.task3.service.exception.ErrorDataConnectionException;
import by.javatr.task3.service.exception.InvalidOrdinaryNumberException;

public class Main {
    public static void main(String[] args) {
        StringEditor stringEditor=new StringEditor();
        try {
            stringEditor.fillFromFile("src/by/javatr/task3/input.txt");
        }catch (ErrorDataConnectionException ex){
            System.out.println("Cannot read from file");
        }
        stringEditor.fixText(true);
        stringEditor.fillFromConsole();
        try {
            stringEditor.replaceSymbol('a', 3, true);
        }catch (InvalidOrdinaryNumberException ex){
            System.out.println("Invalid number");
        }
        System.out.print(stringEditor.toString());
    }
}
