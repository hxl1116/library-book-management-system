package java.Requests.Book;

/**
 * Borrows a book for a visitor;
 * uses the ID of a specific book or books returned in the most recent library book search.
 *
 * @author Henry Larson
 */
public class BorrowBookRequest {
    private int visitorID;
    private int[] ids;

    public BorrowBookRequest(int visitorID, int... ids) {
        this.visitorID = visitorID;
        this.ids = ids;
    }

    public int getVisitorID() {
        return visitorID;
    }

    public int[] getIds() {
        return ids;
    }
}
