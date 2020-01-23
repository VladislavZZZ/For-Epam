package by.javatr.controller.exception;

public class ChangeGainControllerException extends Exception {
    public ChangeGainControllerException() {
    }

    public ChangeGainControllerException(String message) {
        super(message);
    }

    public ChangeGainControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChangeGainControllerException(Throwable cause) {
        super(cause);
    }

    public ChangeGainControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
