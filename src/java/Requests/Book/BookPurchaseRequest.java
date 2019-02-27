package java.Requests.Book;

/**
 * Purchases one or more books returned from the last book store search. Purchased books are added to the library's
 * collection. If the books already exist in the collection, the available quantity of each book is updated to reflect
 * the newly purchased books. For the purpose of this simulation it should be assumed that infinite quantities of each
 * book are available for purchase.
 *
 * @author Henry Larson
 */
public class BookPurchaseRequest {
    private int quantity;
    private int id;
    private int[] ids;

    public BookPurchaseRequest(int quantity, int id) {
        this.quantity = quantity;
        this.id = id;
    }

    public BookPurchaseRequest(int quantity, int id, int... ids) {
        this.quantity = quantity;
        this.id = id;
        this.ids = ids;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getId() {
        return id;
    }

    public int[] getIds() {
        return ids;
    }
}
