package java.Requests.Book;

/**
 * Returns a book borrowed by a library visitor.
 *
 * @author Henry Larson
 */
public class ReturnBookRequest {
    private int visitorID;
    private int id;
    private int[] ids;

    public ReturnBookRequest(int visitorID, int id) {
        this.visitorID = visitorID;
        this.id = id;
    }

    public ReturnBookRequest(int visitorID, int id, int... ids) {
        this.visitorID = visitorID;
        this.id = id;
        this.ids = ids;
    }

    public int getVisitorID() {
        return visitorID;
    }

    public int getId() {
        return id;
    }

    public int[] getIds() {
        return ids;
    }
}
