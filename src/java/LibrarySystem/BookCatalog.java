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
 * @author Jimmy Dugan
 */
public class BookCatalog implements Serializable {

    /**
     * HashMap of available books
     */
    HashMap<Book,Integer> available = new HashMap<>();

    /**
     * HashMap of unavailable books
     */
    HashMap<Book,Integer> unavailable = new HashMap<>();

    /**
     * ArrayList of books
     */
    private ArrayList<Book> books;

    /**
     * book store search request
     */
    private BookStoreSearchRequest bookStoreSearchRequest;

    /**
     *  book purchase request
     */
    private BookPurchaseRequest bookPurchaseRequest;

    /**
     * book catalog
     * @param books
     */
    public BookCatalog(ArrayList<Book> books){
        this.books = books;

    }

    /**
     * constructor for book catalog
     * @param books
     * @param bookStoreSearchRequest
     */
    public BookCatalog(ArrayList<Book> books, BookStoreSearchRequest bookStoreSearchRequest){
        this.books = books;
        this.bookStoreSearchRequest = bookStoreSearchRequest;
    }

    public BookCatalog(ArrayList<Book> books, BookPurchaseRequest bookPurchaseRequest){
        this.books = books;
        this.bookPurchaseRequest = bookPurchaseRequest;
    }

    /**
     * makes books available
     * @param book
     * @param copies
     */
    public void makeAvailable(Book book, int copies){
        available.put(book, available.get(book) + copies);

    }

    /**
     * adds a new book
     * @param book
     * @param copies
     */
    public void addNewBook(Book book, int copies) {
        available.put(book, copies);
    }

    /**
     * makes book unavialable
     * @param book
     */
    public void makeUnavailable(Book book){
        available.put(book, available.get(book) - 1);
        unavailable.put(book, unavailable.get(book) + 1);
    }

    /**
     * checks if book is avaliable
     * @param book
     * @return
     */
    public boolean isAvailable(Book book) {
        return available.get(book) > 0;
    }


    /**
     * gets number of available books
     * @param book
     * @return
     */
    public int getNumberOfAvailableCopies(Book book){
        return available.get(book);
    }

    /**
     * gets the number of unavailable books
     * @param book
     * @return
     */
    public int getNumberOfUnavailableCopies(Book book){
        return unavailable.get(book);
    }

    /**
     * gets available books from HashMap
     * @return
     */
    public HashMap<Book, Integer> getAvailable() {
        return available;
    }

    /**
     * gets unavilable books from HashMap
     * @return
     */
    public HashMap<Book, Integer> getUnavailable() {
        return unavailable;

    }


    /**
     * executes searching
     * @return
     */
    public Object executeSearchAndSortRequest() {


        //Search context
        SearchContext context = new SearchContext();
        //Sort context
        SortContext sortContext = new SortContext();


        ArrayList<Book> searchResults;
        searchResults = books;

        if (!(bookStoreSearchRequest.getTitle().equals("*"))) {
            context.setSearch(new TitleSearch());
            searchResults = context.search(searchResults, bookStoreSearchRequest.getTitle());
        }

        if (!(bookStoreSearchRequest.getAuthors()[0].equals("*"))) {
            context.setSearch(new AuthorsSearch());
            searchResults = context.search(searchResults, Arrays.toString(bookStoreSearchRequest.getAuthors()));
        }
        String requestIsbn = Long.toString(bookStoreSearchRequest.getIsbn());
        if (!(requestIsbn.equals("*"))) {
            context.setSearch(new IsbnSearch());
            searchResults = context.search(searchResults, requestIsbn);
        }
        if (!(bookStoreSearchRequest.getPublisher().equals("*"))) {
            context.setSearch(new PublishDateSearch());
            searchResults = context.search(searchResults, bookStoreSearchRequest.getPublisher());
        }

        if(!bookStoreSearchRequest.getSortOrder().equals("title") || !bookStoreSearchRequest.getSortOrder().equals("publish-date") || !bookStoreSearchRequest.getSortOrder().equals("book-status")){
            //returns an error is user enters invalid Sort type
            return Error.InvalidSortOrder;
        }

        else{

            switch (bookStoreSearchRequest.getSortOrder()) {

            case "title":
                sortContext.setBookSort(new TitleSort());
                sortContext.makeSort(searchResults);
            case "publish-date":
                sortContext.setBookSort(new PublishDateSort());
                sortContext.makeSort(searchResults);
            case "book-status":
                sortContext.setBookSort(new AvailableSort());
                sortContext.makeSort(searchResults);

        }
        //returns a list of searched and sorted books (if any)
        return searchResults;
        }
    }

    /**
     * Makes a book purchase
     */
    public void makePurchase(){
        int[] iDList = bookPurchaseRequest.getIds();
        int quantity = bookPurchaseRequest.getQuantity();
        for(Integer id: iDList){
            for(Book book: books){
                if(book.getTempID() == id){
                    if(available.containsKey(book))
                        available.put(book, available.get(book) + quantity);
                    else
                        available.put(book, quantity);
                }
            }
        }
   }
}
