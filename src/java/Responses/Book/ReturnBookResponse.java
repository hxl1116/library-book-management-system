package java.Responses.Book;

/**
 * Returns a book borrowed by a library visitor.
 *
 * @author Henry Larson
 */
public class ReturnBookResponse {
    private boolean success;
    private boolean overdue;
    private double fine;
    private int id;
    private int[] ids;

    public ReturnBookResponse(boolean success, boolean overdue, double fine, int id, int... ids) {
        this.success = success;
        this.overdue = overdue;
        this.fine = fine;
        this.id = id;
        this.ids = ids;
    }

    public boolean isSuccess() {
        return success;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public double getFine() {
        return fine;
    }

    public int getId() {
        return id;
    }

    public int[] getIds() {
        return ids;
    }

    // TODO - create response format
    public String toString() {
        return "";
    }
}
