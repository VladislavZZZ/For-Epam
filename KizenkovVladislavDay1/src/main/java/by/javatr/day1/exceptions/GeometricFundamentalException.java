package by.javatr.day1.exceptions;

public class GeometricFundamentalException extends  Exception{
    public GeometricFundamentalException(String message){
        super(message);
    }

    public GeometricFundamentalException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeometricFundamentalException(Throwable cause) {
        super(cause);
    }

    public GeometricFundamentalException() {
    }
}
