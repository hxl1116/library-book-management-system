package java.Requests.Library;

/**
 * Searches for books owned by the library and available for borrowing by visitors. A "*" may be specified in place of
 * any search parameter; any such parameter should be ignored for the purpose of query matching. For example: info,*,
 * {J.K. Rowling} should return any books written by J.K. Rowling, regardless of the title of the book.
 *
 * @author Henry Larson
 */
public class LibraryBookSearchRequest {
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

    public String getTitle() {
        return title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getSortOrder() {
        return sortOrder;
    }
}
