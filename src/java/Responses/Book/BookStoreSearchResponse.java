package java.Responses.Book;

import java.Model.Book;
import java.util.List;

/**
 * Searches for books that may be purchased by the library and added to its collection. The books included in the search
 * results should be determined by the contents of books.txt. A "*" may be specified in place of any search parameter;
 * any such parameter should be ignored for the purpose of query matching. For example: search,*, {J.K. Rowling} should
 * return any books written by J.K. Rowling, regardless of the title of the book.
 *
 * @author Henry Larson
 */
public class BookStoreSearchResponse {
    private int numberOfBooks;
    private List<Book> books;

    public BookStoreSearchResponse(int numberOfBooks, List<Book> books) {
        this.numberOfBooks = numberOfBooks;
        this.books = books;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    @SuppressWarnings("Duplicates")
    public String getBooks() {
        StringBuilder bookList = new StringBuilder();
        for (Book book : books) {
            // ISBN, Title, Authors, Publish-Date, Quantity
            bookList.append(book.getIsbn()).append(",")
                    .append(book.getTitle()).append(",")
                    .append(book.getAuthorsAsString()).append(",")
                    .append(book.getDatePublished()).append(",")
                    .append(books.size()).append("\n");
        }

        return bookList.toString();
    }

    // TODO - create response format
    public String toString() {
        return "";
    }
}
