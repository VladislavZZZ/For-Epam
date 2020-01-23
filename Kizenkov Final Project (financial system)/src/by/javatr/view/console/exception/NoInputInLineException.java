package by.javatr.view.console.exception;

public class NoInputInLineException extends Throwable {
    public NoInputInLineException() {
    }

    public NoInputInLineException(String message) {
        super(message);
    }

    public NoInputInLineException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoInputInLineException(Throwable cause) {
        super(cause);
    }

    public NoInputInLineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
