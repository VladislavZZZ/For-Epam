package by.javatr.controller.exception;

public class WrongRequestControllerException extends Exception {
    public WrongRequestControllerException() {
    }

    public WrongRequestControllerException(String message) {
        super(message);
    }

    public WrongRequestControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongRequestControllerException(Throwable cause) {
        super(cause);
    }

    public WrongRequestControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
