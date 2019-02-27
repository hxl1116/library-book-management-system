package java.Responses.Book;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Borrows a book for a visitor; uses the ID of a specific book or books returned in the most recent library book
 * search.
 *
 * @author Henry Larson
 */
public class BorrowBookResponse {
    // YYYY/MM/DD format
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    private Date dueDate;

    public BorrowBookResponse(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    // TODO - create response format
    public String toString() {
        return "";
    }
}
