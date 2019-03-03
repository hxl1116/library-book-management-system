package Model;

import Responses.LibraryResponse;

import java.util.Date;

// TODO - provide Response formatting methods in Book class
public class Book {
    private int tempID;
    private int isbn;
    private String title;
    private String authors;
    private String publisher;
    private String datePublished;
    private int pageCount;
    private Date dateBorrowed;
    private Date dueDate;

    public Book(int isbn, String title, String authors, String publisher, String datePublished, int pageCount) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.datePublished = datePublished;
        this.pageCount = pageCount;
    }

    public String purchaseFormat() {
        return String.format("%s,%s,%s,%s", isbn, title, authors, LibraryResponse.DATE_FORMAT.format(datePublished));
    }

    public String searchFormat() {
        return String.format("%d,%d,%s,%s,%s", tempID, isbn, title, authors,
                LibraryResponse.DATE_FORMAT.format(datePublished));
    }

    public String queryFormat() {
        return String.format("%d,%d,%s,%s", tempID, isbn, title, LibraryResponse.DATE_FORMAT.format(dateBorrowed));
    }
}
