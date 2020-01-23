package by.javatr.controller.exception;

public class LogInControllerException extends  Exception {
    public LogInControllerException() {
    }

    public LogInControllerException(String message) {
        super(message);
    }

    public LogInControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogInControllerException(Throwable cause) {
        super(cause);
    }

    public LogInControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
