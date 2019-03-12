package Requests.Book;

import LibrarySystem.Library;
import Requests.LibraryRequest;
import Responses.Book.BookPurchaseResponse;
import Responses.LibraryResponse;

/**
 * Purchases one or more books returned from the last book store search. Purchased books are added to the library's
 * collection. If the books already exist in the collection, the available quantity of each book is updated to reflect
 * the newly purchased books. For the purpose of this simulation it should be assumed that infinite quantities of each
 * book are available for purchase.
 *
 * @author Henry Larson
 */
// TODO - Refactor for parameter parsing
public class BookPurchaseRequest extends LibraryRequest {
    private int quantity;
    private int[] ids;

    public BookPurchaseRequest(int quantity, int... ids) {
        this.quantity = quantity;
        this.ids = ids;
    }

    @Override
    public LibraryResponse execute() {
        Object[] purchasedBooks = Library.initiatePurchase(quantity, ids);
        return new BookPurchaseResponse(purchasedBooks);
    }
}
