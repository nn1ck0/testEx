public class RomanNumException extends Exception{

    public RomanNumException() {
    }

    public RomanNumException(String message) {
        super(message);
    }

    public RomanNumException(String message, Throwable cause) {
        super(message, cause);
    }

    public RomanNumException(Throwable cause) {
        super(cause);
    }

    public RomanNumException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
