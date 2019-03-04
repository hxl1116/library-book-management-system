package Requests.Book;

import Requests.LibraryRequest;

/**
 * Borrows a book for a visitor;
 * uses the ID of a specific book or books returned in the most recent library book search.
 *
 * @author Henry Larson
 */
public class BorrowBookRequest extends LibraryRequest {
    private String visitorID;
    private int[] ids;

    public BorrowBookRequest(String visitorID, int... ids) {
        this.visitorID = visitorID;
        this.ids = ids;
    }

    public String getVisitorID() {
        return visitorID;
    }

    public int[] getIds() {
        return ids;
    }
}
