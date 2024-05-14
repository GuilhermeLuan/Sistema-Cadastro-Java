package entities.exceptions;

public class AgeException extends Exception {
    public AgeException(String message) {
        super(message);
    }
    public AgeException(String message, Throwable cause) {
        super(message, cause);
    }
}
