package Responses.Book;

import Model.Book;
import Responses.LibraryResponse;

import java.util.List;

/**
 * Queries for a list of books currently borrowed by a specific visitor.
 *
 * @author Henry Larson
 */
public class QueryBorrowedBooksResponse extends LibraryResponse {
    private List<Book> books;

    public QueryBorrowedBooksResponse(List<Book> books) {
        this.books = books;
    }

    public String toString() {
        StringBuilder queriedBooks = new StringBuilder();
        for (Book book : books) {
            queriedBooks.append(book.queryFormat()).append("\n");
        }

        return String.format("borrowed,%s", queriedBooks.toString());
    }
}
