package Requests.Book;

import Requests.LibraryRequest;

/**
 * Queries for a list of books currently borrowed by a specific visitor.
 *
 * @author Henry Larson
 */
public class QueryBorrowedBooksRequest extends LibraryRequest {
    private int visitorID;

    public QueryBorrowedBooksRequest(int visitorID) {
        this.visitorID = visitorID;
    }

    public int getVisitorID() {
        return visitorID;
    }
}
