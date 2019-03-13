package Responses.Book;

import Model.Book;
import Responses.LibraryResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private List<Book> books;
    private int quantity;

    public BookPurchaseResponse(Object[] purchaseData) {
        books = (ArrayList<Book>) purchaseData[0];
        quantity = (int) purchaseData[1];
    }

    public String toString() {
        StringBuilder purchasedBooks = new StringBuilder();
        for (Book book : books) {
            purchasedBooks.append(book.purchaseFormat()).append(",").append(quantity).append("\n");
        }

        return String.format("buy,success,%d,%s", books.size(), purchasedBooks.toString());
    }
}
