package by.javatr.task3.service.exception;

public class ErrorDataConnectionException extends Exception {
    public ErrorDataConnectionException() {
    }

    public ErrorDataConnectionException(String message) {
        super(message);
    }

    public ErrorDataConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorDataConnectionException(Throwable cause) {
        super(cause);
    }

    public ErrorDataConnectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
