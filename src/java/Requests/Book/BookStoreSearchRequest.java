package Requests.Book;

import LibrarySystem.Library;
import Requests.LibraryRequest;
import Responses.Book.BookStoreSearchResponse;
import Responses.LibraryResponse;

/**
 * Searches for books that may be purchased by the library and added to its collection. The books included in the search
 * results should be determined by the contents of books.txt. A "*" may be specified in place of any search parameter;
 * any such parameter should be ignored for the purpose of query matching. For example: search,*, {J.K. Rowling} should
 * return any books written by J.K. Rowling, regardless of the title of the book.
 *
 * @author Henry Larson
 */
public class BookStoreSearchRequest extends LibraryRequest {
    private String title;
    private String[] authors;
    private long isbn;
    private String publisher;
    private String sortOrder;

    public BookStoreSearchRequest(String title, String authors, long isbn, String publisher, String sortOrder) {
        this.title = title;
        this.authors = authors.split(",");
        this.isbn = isbn;
        this.publisher = publisher;
        this.sortOrder = sortOrder;
    }

    @Override
    public LibraryResponse execute() {
        return new BookStoreSearchResponse(Library.searchAndSort(title, authors, isbn, publisher, sortOrder));
    }
}
