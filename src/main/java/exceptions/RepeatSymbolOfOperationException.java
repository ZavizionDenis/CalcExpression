package exceptions;

public class RepeatSymbolOfOperationException extends Exception{
    public RepeatSymbolOfOperationException() {
    }

    public RepeatSymbolOfOperationException(String message) {
        super(message);
    }

    public RepeatSymbolOfOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepeatSymbolOfOperationException(Throwable cause) {
        super(cause);
    }
}
