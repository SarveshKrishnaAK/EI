package src.util;

public class TransientException extends Exception {
    public TransientException(String message) {
        super(message);
    }
    public TransientException(String message, Throwable cause) {
        super(message, cause);
    }
}
