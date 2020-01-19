package by.javatr.task3.service.exception;

public class StringNullPointerException extends Exception{
    public StringNullPointerException() {
    }

    public StringNullPointerException(String message) {
        super(message);
    }

    public StringNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public StringNullPointerException(Throwable cause) {
        super(cause);
    }

    public StringNullPointerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
