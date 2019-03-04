package Responses.Library;

import Model.Book;

import java.util.HashMap;

/**
 * Searches for books owned by the library and available for borrowing by visitors. A "*" may be specified in place of
 * any search parameter; any such parameter should be ignored for the purpose of query matching. For example: info,*,
 * {J.K. Rowling} should return any books written by J.K. Rowling, regardless of the title of the book.
 *
 * @author Henry Larson
 */
public class LibraryBookSearchResponse {
    private int numberOfBooks;
    private HashMap<Book, Integer> books;

    public LibraryBookSearchResponse(int numberOfBooks, HashMap<Book, Integer> books) {
        this.numberOfBooks = numberOfBooks;
        this.books = books;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public HashMap<Book, Integer> getBooks() {
        return books;
    }

    // TODO - create response format
    public String toString() {
        return "";
    }
}
