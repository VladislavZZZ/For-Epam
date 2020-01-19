package by.javatr.day1.task10.exceptions;

public class IncorrectIntervalException extends Exception {
    public IncorrectIntervalException() {
    }

    public IncorrectIntervalException(String message) {
        super(message);
    }

    public IncorrectIntervalException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectIntervalException(Throwable cause) {
        super(cause);
    }
}
