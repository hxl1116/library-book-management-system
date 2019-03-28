package Requests.Book;

import Requests.LibraryRequest;
import Responses.Book.ReturnBookResponse;
import Responses.LibraryResponse;

/**
 * Returns a book borrowed by a library visitor.
 *
 * @author Henry Larson
 */
public class ReturnBookRequest extends LibraryRequest {
    private String visitorID;
    private int[] ids;

    public ReturnBookRequest(String parameters) {
        String[] params = parameters.split(",");
        visitorID = params[0];
        ids = new int[params.length - 1];
        for (int i = 1; i < ids.length; i++) {
            ids[i] = Integer.parseInt(params[i + 1]);
        }
    }

    @Override
    // TODO - Create method call for response data
    public LibraryResponse execute() {
        return new ReturnBookResponse(0.0, 0);
    }

    @Override
    // TODO - Create method call for undoing request
    public LibraryRequest undo() {
        return null;
    }
}
