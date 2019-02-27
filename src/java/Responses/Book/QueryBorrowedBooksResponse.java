package java.Responses.Book;

import java.Model.Book;
import java.util.List;

/**
 * Queries for a list of books currently borrowed by a specific visitor.
 *
 * @author Henry Larson
 */
public class QueryBorrowedBooksResponse {
    private int numberOfBooks;
    private List<Book> books;

    public QueryBorrowedBooksResponse(int numberOfBooks, List<Book> books) {
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
            bookList.append(book.getTempID()).append(",")
                    .append(book.getIsbn()).append(",")
                    .append(book.getTitle()).append(",")
                    .append(book.getDateBorrowed()).append("\n");
        }

        return bookList.toString();
    }

    // TODO - create response format
    public String toString() {
        return "";
    }
}
