package by.javatr.task3.service.exception;

public class InvalidOrdinaryNumberException extends Exception{
    public InvalidOrdinaryNumberException() {
    }

    public InvalidOrdinaryNumberException(String message) {
        super(message);
    }

    public InvalidOrdinaryNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidOrdinaryNumberException(Throwable cause) {
        super(cause);
    }

    public InvalidOrdinaryNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
