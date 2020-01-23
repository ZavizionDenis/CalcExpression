package exceptions;

public class NotFoundOpenBraketException extends Exception {
    public NotFoundOpenBraketException() {
    }

    public NotFoundOpenBraketException(String message) {
        super(message);
    }

    public NotFoundOpenBraketException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundOpenBraketException(Throwable cause) {
        super(cause);
    }
}
