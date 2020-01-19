package by.javatr.exception;

public class ArrayNullPointerException extends Exception {
    public ArrayNullPointerException() {
    }

    public ArrayNullPointerException(String message) {
        super(message);
    }

    public ArrayNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayNullPointerException(Throwable cause) {
        super(cause);
    }

    public ArrayNullPointerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
