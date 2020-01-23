package by.javatr.controller.exception;

public class DeleteUserControllerException extends Exception {
    public DeleteUserControllerException() {
    }

    public DeleteUserControllerException(String message) {
        super(message);
    }

    public DeleteUserControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteUserControllerException(Throwable cause) {
        super(cause);
    }

    public DeleteUserControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
