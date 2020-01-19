package by.javatr.task1.bean.exception;

public class SimpleArrayIncorrectSizeException extends Exception {
    public SimpleArrayIncorrectSizeException() {
    }

    public SimpleArrayIncorrectSizeException(String message) {
        super(message);
    }

    public SimpleArrayIncorrectSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SimpleArrayIncorrectSizeException(Throwable cause) {
        super(cause);
    }

    public SimpleArrayIncorrectSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
