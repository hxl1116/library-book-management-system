package Requests.Book;

import Requests.LibraryRequest;
import Responses.LibraryResponse;

/**
 * Returns a book borrowed by a library visitor.
 *
 * @author Henry Larson
 */
public class ReturnBookRequest extends LibraryRequest {
    private String visitorID;
    private int[] ids;

    public ReturnBookRequest(String visitorID, int[] ids) {
        this.visitorID = visitorID;
        this.ids = ids;
    }

    public String getVisitorID() {
        return visitorID;
    }

    public int[] getIds() {
        return ids;
    }

    @Override
    public LibraryResponse execute() {
        return null;
    }
}
