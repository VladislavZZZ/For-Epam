package by.javatr.day3.exceptions;

public class BasketOverloadedException extends Exception {
    public BasketOverloadedException() {
    }

    public BasketOverloadedException(String message) {
        super(message);
    }

    public BasketOverloadedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BasketOverloadedException(Throwable cause) {
        super(cause);
    }
}
