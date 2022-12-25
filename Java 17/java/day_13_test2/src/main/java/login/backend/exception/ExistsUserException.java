package login.backend.exception;

public class ExistsUserException extends RuntimeException {
    public ExistsUserException(String message) {
        super(message);
    }
}
