package Model;

import LibrarySystem.Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Book {
    private int tempID;
    private long isbn;
    private String title;
    private String authors;
    private String publisher;
    private String datePublished;
    private int pageCount;
    private Date dateBorrowed;
    private Date dueDate;

    public Book(long isbn, String title, String authors, String publisher, String datePublished, int pageCount) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.datePublished = datePublished;
        this.pageCount = pageCount;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public ArrayList<String> getAuthorsAsList() {
        return (ArrayList<String>) Arrays.asList(authors.split(","));
    }

    public String purchaseFormat() {
        return String.format("%s,%s,%s,%s", isbn, title, authors, Library.DATE_FORMAT.format(datePublished));
    }

    public String searchFormat() {
        return String.format("%d,%d,%s,%s,%s", tempID, isbn, title, authors,
                Library.DATE_FORMAT.format(datePublished));
    }

    public String queryFormat() {
        return String.format("%d,%d,%s,%s", tempID, isbn, title, Library.DATE_FORMAT.format(dateBorrowed));
    }
}
