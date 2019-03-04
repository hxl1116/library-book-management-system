package Model;

import LibrarySystem.Library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Book implements Serializable {
    private int tempID;
    private long isbn;
    private String title;
    private String authors;
    private String publisher;
    private String datePublished;
    private int pageCount;
    private Date dateBorrowed;
    private Date dueDate;

    /**
     * Constructor for book
     *
     * @param isbn
     * @param title
     * @param authors
     * @param publisher
     * @param datePublished
     * @param pageCount
     */
    public Book(long isbn, String title, String authors, String publisher, String datePublished, int pageCount) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.datePublished = datePublished;
        this.pageCount = pageCount;
    }

    /**
     * gets book temp id
     *
     * @return
     */
    public int getTempID() {
        return tempID;
    }

    public void setTempID(int tempID) {
        this.tempID = tempID;
    }

    /**
     * gets book Isbn number
     * @return
     */
    public long getIsbn() {
        return isbn;
    }

    /**
     * gets the book title
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * gets the book publish date
     * @return
     */
    public String getDatePublished() {
        return datePublished;
    }

    /**
     * gets list of authors
     * @return
     */
    public ArrayList<String> getAuthorsAsList() {
        return (ArrayList<String>) Arrays.asList(authors.split(","));
    }

    /**
     * format of a purchase
     * @return
     */
    public String purchaseFormat() {
        return String.format("%s,%s,%s,%s", isbn, title, authors, Library.DATE_FORMAT.format(datePublished));
    }

    /**
     * format of a search
     * @return
     */
    public String searchFormat() {
        return String.format("%d,%d,%s,%s,%s", tempID, isbn, title, authors,
                Library.DATE_FORMAT.format(datePublished));
    }

    /**
     * format of a query
     * @return
     */
    public String queryFormat() {
        return String.format("%d,%d,%s,%s", tempID, isbn, title, Library.DATE_FORMAT.format(dateBorrowed));
    }

    /**
     * Turns this book into a String for when it has been loaned.
     * @return String form of book
     */
    public String toStringBorrowed() {
        return Long.toString(isbn) + "," + title;
    }
}
