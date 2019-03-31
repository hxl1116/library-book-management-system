package Sort;

public class SortException extends Exception {
    private String message;

    public SortException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
