package by.javatr.command.day2.task6.exceptions;

public class NegativeDayException extends Exception{
    public NegativeDayException() {
    }

    public NegativeDayException(String message) {
        super(message);
    }

    public NegativeDayException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeDayException(Throwable cause) {
        super(cause);
    }
}
