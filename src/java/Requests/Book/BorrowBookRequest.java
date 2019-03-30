package Requests.Book;

import LibrarySystem.Library;
import Requests.LibraryRequest;
import Responses.Book.BorrowBookResponse;
import Responses.LibraryResponse;

/**
 * Borrows a book for a visitor;
 * uses the ID of a specific book or books returned in the most recent library book search.
 *
 * @author Henry Larson
 */
public class BorrowBookRequest extends LibraryRequest {
    private String visitorID;
    private int[] ids;

    public BorrowBookRequest(String parameters) {
        if (parameters.contains(",")) {
            String[] params = parameters.split(",");
            visitorID = params[0];
            ids = new int[params.length - 1];
            for (int i = 0; i < ids.length; i++) {
                ids[i] = Integer.parseInt(params[i + 1]);
            }
        }
    }

    @Override
    public LibraryResponse execute() {
        return new BorrowBookResponse(Library.loan(visitorID, ids[0]));
    }
}
