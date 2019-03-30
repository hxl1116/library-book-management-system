package Sort;

public class SortException extends Throwable {
    private String message;

    public SortException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
