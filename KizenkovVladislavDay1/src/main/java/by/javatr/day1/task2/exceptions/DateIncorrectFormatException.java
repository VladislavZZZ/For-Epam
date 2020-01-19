package by.javatr.day1.task2.exceptions;

public class DateIncorrectFormatException extends Exception {

    public DateIncorrectFormatException(String message){
        super(message);
    }

    public DateIncorrectFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public DateIncorrectFormatException(Throwable cause) {
        super(cause);
    }

    public DateIncorrectFormatException() {
    }
}
