package Requests.Library;

import Requests.LibraryRequest;
import Responses.LibraryResponse;

/**
 * Searches for books owned by the library and available for borrowing by visitors. A "*" may be specified in place of
 * any search parameter; any such parameter should be ignored for the purpose of query matching. For example: info,*,
 * {J.K. Rowling} should return any books written by J.K. Rowling, regardless of the title of the book.
 *
 * @author Henry Larson
 */
// TODO - Refactor for parameter parsing
public class LibraryBookSearchRequest extends LibraryRequest {
    private String title;
    private String[] authors;
    private int isbn;
    private String publisher;
    private String sortOrder;

    public LibraryBookSearchRequest(String title, String authors, int isbn, String publisher, String sortOrder) {
        this.title = title;
        this.authors = authors.split(",");
        this.isbn = isbn;
        this.publisher = publisher;
        this.sortOrder = sortOrder;
    }

    @Override
    public LibraryResponse execute() {
        return null;
    }
}
