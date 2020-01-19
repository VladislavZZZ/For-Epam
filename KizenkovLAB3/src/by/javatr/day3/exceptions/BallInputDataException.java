package by.javatr.day3.exceptions;

public class BallInputDataException extends Exception {
    public BallInputDataException() {
    }

    public BallInputDataException(String message) {
        super(message);
    }

    public BallInputDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public BallInputDataException(Throwable cause) {
        super(cause);
    }
}
