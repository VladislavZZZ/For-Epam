package by.javatr.view.console.exception;

public class NoNumberInLineException extends Throwable {
    public NoNumberInLineException() {
    }

    public NoNumberInLineException(String message) {
        super(message);
    }

    public NoNumberInLineException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoNumberInLineException(Throwable cause) {
        super(cause);
    }

    public NoNumberInLineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
