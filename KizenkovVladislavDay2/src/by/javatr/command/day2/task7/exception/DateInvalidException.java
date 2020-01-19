package by.javatr.command.day2.task7.exception;

public class DateInvalidException extends Exception {
    public DateInvalidException() {
    }

    public DateInvalidException(String message) {
        super(message);
    }

    public DateInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public DateInvalidException(Throwable cause) {
        super(cause);
    }
}
