package Responses.Book;

import Responses.LibraryResponse;

/**
 * Returns a book borrowed by a library visitor.
 *
 * @author Henry Larson
 */
public class ReturnBookResponse extends LibraryResponse {
    private double fine;
    private int[] ids;

    public ReturnBookResponse(double fine, int... ids) {
        this.fine = fine;
        this.ids = ids;
    }

    public String toString() {
        StringBuilder bookIds = new StringBuilder();
        for (int id : ids) {
            bookIds.append(",").append(id);
        }

        return (fine == 0) ? "success" : String.format("overdue,$%.2f,%s", fine, bookIds.toString());
    }
}
