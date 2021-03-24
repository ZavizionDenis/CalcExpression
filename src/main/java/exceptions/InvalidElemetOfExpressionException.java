package exceptions;

public class InvalidElemetOfExpressionException extends Exception {
    public InvalidElemetOfExpressionException() {
    }

    public InvalidElemetOfExpressionException(String message) {
        super(message);
    }

    public InvalidElemetOfExpressionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidElemetOfExpressionException(Throwable cause) {
        super(cause);
    }
}
