package by.javatr.day3.exceptions;

public class BasketInputDataException extends Exception {
    public BasketInputDataException() {
    }

    public BasketInputDataException(String message) {
        super(message);
    }

    public BasketInputDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public BasketInputDataException(Throwable cause) {
        super(cause);
    }
}
