package Responses.Library;

import Model.Book;
import Responses.LibraryResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Searches for books owned by the library and available for borrowing by visitors. A "*" may be specified in place of
 * any search parameter; any such parameter should be ignored for the purpose of query matching. For example: info,*,
 * {J.K. Rowling} should return any books written by J.K. Rowling, regardless of the title of the book.
 *
 * @author Henry Larson
 */
public class LibraryBookSearchResponse extends LibraryResponse {
    private int numberOfBooks;
    private HashMap<Book, Integer> books;

    public LibraryBookSearchResponse(int numberOfBooks, HashMap<Book, Integer> books) {
        this.numberOfBooks = numberOfBooks;
        this.books = books;
    }

    @SuppressWarnings("Duplicates")
    public String toString() {
        StringBuilder searchedBooks = new StringBuilder();
        for (Map.Entry<Book, Integer> book : books.entrySet()) {
            searchedBooks.append(book.getValue())
                    .append(",")
                    .append(book.getKey().libraryBookSearchFormat())
                    .append("\n");
        }

        return String.format("search,%d,\n%s", books.size(), searchedBooks.toString());
    }
}
