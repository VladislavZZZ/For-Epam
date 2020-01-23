package by.javatr.controller.exception;

public class SignUpControllerException extends Exception {
    public SignUpControllerException() {
    }

    public SignUpControllerException(String message) {
        super(message);
    }

    public SignUpControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public SignUpControllerException(Throwable cause) {
        super(cause);
    }

    public SignUpControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
