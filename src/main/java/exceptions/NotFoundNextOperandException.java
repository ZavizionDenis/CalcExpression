package exceptions;

public class NotFoundNextOperandException extends Exception {
    public NotFoundNextOperandException() {
    }

    public NotFoundNextOperandException(String message) {
        super(message);
    }

    public NotFoundNextOperandException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundNextOperandException(Throwable cause) {
        super(cause);
    }
}
