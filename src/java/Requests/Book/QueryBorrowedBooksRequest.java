package Requests.Book;

import Requests.LibraryRequest;
import Responses.Book.QueryBorrowedBooksResponse;
import Responses.LibraryResponse;

/**
 * Queries for a list of books currently borrowed by a specific visitor.
 *
 * @author Henry Larson
 */
public class QueryBorrowedBooksRequest extends LibraryRequest {
    private String visitorID;

    public QueryBorrowedBooksRequest(String parameters) {
        visitorID = parameters;
    }

    public String getVisitorID() {
        return visitorID;
    }

    @Override
    // TODO - Create method call for response data
    public LibraryResponse execute() {
        return new QueryBorrowedBooksResponse(null);
    }

    @Override
    // TODO - Create method call for undoing request
    public LibraryRequest undo() {
        return null;
    }
}
