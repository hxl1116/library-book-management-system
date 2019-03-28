package Responses.Book;

import Model.Book;
import Responses.LibraryResponse;

import java.util.List;

/**
 * Searches for books that may be purchased by the library and added to its collection. The books included in the search
 * results should be determined by the contents of books.txt. A "*" may be specified in place of any search parameter;
 * any such parameter should be ignored for the purpose of query matching. For example: search,*, {J.K. Rowling} should
 * return any books written by J.K. Rowling, regardless of the title of the book.
 *
 * @author Henry Larson
 */
public class BookStoreSearchResponse extends LibraryResponse {
    private List<Book> books;

    public BookStoreSearchResponse(List<Book> books) {
        this.books = books;
    }

    @SuppressWarnings("Duplicates")
    public String toString() {
        StringBuilder searchedBooks = new StringBuilder();
        for (Book book : books) {
            searchedBooks.append(book.searchFormat()).append("\n");
        }

        return String.format("search,%d,\n%s", books.size(), searchedBooks.toString());
    }
}
