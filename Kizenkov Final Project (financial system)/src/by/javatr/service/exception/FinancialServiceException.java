package by.javatr.service.exception;

public class FinancialServiceException extends Exception {
    public FinancialServiceException() {
    }

    public FinancialServiceException(String message) {
        super(message);
    }

    public FinancialServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public FinancialServiceException(Throwable cause) {
        super(cause);
    }

    public FinancialServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
