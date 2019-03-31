package LibrarySystem;

//import temps.TempPurchaseRequest;

import Model.Book;
import Requests.Book.BookPurchaseRequest;
import Requests.Book.BookStoreSearchRequest;
import Search.*;
import Search.Error;
import Sort.AvailableSort;
import Sort.PublishDateSort;
import Sort.SortContext;
import Sort.TitleSort;
//import Sort.AvailableSort;
//import temps.TempSearchRequest;

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
public class BookCatalog implements Serializable, SearchProxy {

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

    @Override
    public ArrayList<Book> search(BookStoreSearchRequest bookStoreSearchRequest) {

        SearchStateContext searchStateContext = new SearchStateContext();

        if(bookStoreSearchRequest.getSearchType().equals("FILE")){
            searchStateContext.setSearchState(new FileState());
        }else{
            searchStateContext.setSearchState(new APIState());
        }
        return searchStateContext.searchWithState(books,bookStoreSearchRequest);

    }
}