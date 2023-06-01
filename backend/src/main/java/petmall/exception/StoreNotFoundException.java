package petmall.exception;

public class StoreNotFoundException extends RuntimeException {
    public StoreNotFoundException(String message) {
        super(message);
    }
    public StoreNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
