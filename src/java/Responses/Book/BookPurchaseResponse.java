package Responses.Book;

import Model.Book;
import Responses.LibraryResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Purchases one or more books returned from the last book store search. Purchased books are added to the library's
 * collection. If the books already exist in the collection, the available quantity of each book is updated to reflect
 * the newly purchased books. For the purpose of this simulation it should be assumed that infinite quantities of each
 * book are available for purchase.
 *
 * @author Henry Larson
 */
public class BookPurchaseResponse extends LibraryResponse {
    private HashMap<Book, Integer> books;

    public BookPurchaseResponse(HashMap<Book, Integer> books) {
        this.books = books;
    }

    public String toString() {
        StringBuilder purchasedBooks = new StringBuilder();
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            purchasedBooks.append(entry.getKey().purchaseFormat()).append(",").append(entry.getValue()).append("\n");
        }

        return String.format("buy,success,%d,%s", books.size(), purchasedBooks.toString());
    }
}
