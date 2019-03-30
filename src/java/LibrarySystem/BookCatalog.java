package LibrarySystem;

import Model.Book;
import Requests.Book.BookPurchaseRequest;
import Requests.Book.BookStoreSearchRequest;
import Search.*;
import Sort.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Responsible for searching and sorting through the books
 *
 * @author Jimmy Dugan
 */
public class BookCatalog implements Serializable {

    /**
     * HashMap of available books
     */
    HashMap<Book, Integer> available = new HashMap<>();

    /**
     * HashMap of unavailable books
     */
    HashMap<Book, Integer> unavailable = new HashMap<>();

    /**
     * ArrayList of books
     */
    private ArrayList<Book> books;

    /**
     * book store search request
     */
    private BookStoreSearchRequest bookStoreSearchRequest;

    /**
     * book purchase request
     */
    private BookPurchaseRequest bookPurchaseRequest;

    /**
     * book catalog
     *
     * @param books
     */
    public BookCatalog(ArrayList<Book> books) {
        this.books = books;

    }

    /**
     * constructor for book catalog
     *
     * @param books
     * @param bookStoreSearchRequest
     */
    public BookCatalog(ArrayList<Book> books, BookStoreSearchRequest bookStoreSearchRequest) {
        this.books = books;
        this.bookStoreSearchRequest = bookStoreSearchRequest;
    }

    public BookCatalog(ArrayList<Book> books, BookPurchaseRequest bookPurchaseRequest) {
        this.books = books;
        this.bookPurchaseRequest = bookPurchaseRequest;
    }

    /**
     * makes books available
     *
     * @param book
     * @param copies
     */
    public void makeAvailable(Book book, int copies) {
        available.put(book, available.get(book) + copies);

    }

    /**
     * adds a new book
     *
     * @param book
     * @param copies
     */
    public void addNewBook(Book book, int copies) {
        available.put(book, copies);
    }

    /**
     * makes book unavailable
     *
     * @param book
     */
    public void makeUnavailable(Book book) {
        available.put(book, available.get(book) - 1);
        unavailable.put(book, unavailable.get(book) + 1);
    }

    /**
     * checks if book is available
     *
     * @param book
     * @return
     */
    public boolean isAvailable(Book book) {
        return available.get(book) > 0;
    }


    /**
     * gets number of available books
     *
     * @param book
     * @return
     */
    public int getNumberOfAvailableCopies(Book book) {
        return available.get(book);
    }

    /**
     * gets the number of unavailable books
     *
     * @param book
     * @return
     */
    public int getNumberOfUnavailableCopies(Book book) {
        return unavailable.get(book);
    }

    /**
     * gets available books from HashMap
     *
     * @return
     */
    public HashMap<Book, Integer> getAvailable() {
        return available;
    }

    /**
     * gets unavailable books from HashMap
     *
     * @return
     */
    public HashMap<Book, Integer> getUnavailable() {
        return unavailable;

    }


    /**
     * Executes searching
     *
     * @return
     */
    public ArrayList<Book> executeSearchAndSortRequest(String title,
                                                       String[] authors,
                                                       long isbn,
                                                       String publisher,
                                                       String sortOrder) throws SortException {
        //Search context
        SearchContext context = new SearchContext();
        //Sort context
        SortContext sortContext = new SortContext();

        ArrayList<Book> searchResults = books;

        if (!(title.equals("*"))) {
            context.setSearch(new TitleSearch());
            searchResults = context.search(searchResults, title);
        }

        if (!(authors[0].equals("*"))) {
            context.setSearch(new AuthorsSearch());
            searchResults = context.search(searchResults, Arrays.toString(authors));
        }
        String requestIsbn = Long.toString(isbn);
        if (!(requestIsbn.equals("*"))) {
            context.setSearch(new IsbnSearch());
            searchResults = context.search(searchResults, requestIsbn);
        }
        if (!(publisher.equals("*"))) {
            context.setSearch(new PublishDateSearch());
            searchResults = context.search(searchResults, publisher);
        }

        switch (sortOrder) {
            case "title":
                sortContext.setBookSort(new TitleSort());
                sortContext.makeSort(searchResults);
                break;
            case "publish-date":
                sortContext.setBookSort(new PublishDateSort());
                sortContext.makeSort(searchResults);
                break;
            case "book-status":
                sortContext.setBookSort(new AvailableSort());
                sortContext.makeSort(searchResults);
                break;
            default:
                throw new SortException("Invalid Sort Order");
        }

        return searchResults;
    }

    /**
     * Makes a book purchase
     */
    public Object[] makePurchase(int quantity, int[] ids) {
        Object[] purchaseData = new Object[2];
        List<Book> purchasedBooks = new ArrayList<>();

        for (Integer id : ids) {
            for (Book book : books) {
                if (book.getTempID() == id) {
                    if (available.containsKey(book))
                        available.put(book, available.get(book) + quantity);
                    else
                        available.put(book, quantity);
                    purchasedBooks.add(book);
                }
            }
        }

        purchaseData[0] = purchasedBooks;
        purchaseData[1] = quantity;

        return purchaseData;
    }
}
