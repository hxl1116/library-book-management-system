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

public class BookCatalog implements Serializable {

    HashMap<Book,Integer> available = new HashMap<>();
    HashMap<Book,Integer> unavailable = new HashMap<>();
    private ArrayList<Book> books;
    private BookStoreSearchRequest bookStoreSearchRequest;
    private BookPurchaseRequest bookPurchaseRequest;

    public BookCatalog(ArrayList<Book> books){
        this.books = books;

    }

    public BookCatalog(ArrayList<Book> books, BookStoreSearchRequest bookStoreSearchRequest){
        this.books = books;
        this.bookStoreSearchRequest = bookStoreSearchRequest;
    }

    public void makeAvailable(Book book, int copies){
        available.put(book, available.get(book) + copies);

    }

    public void addNewBook(Book book, int copies) {
        available.put(book, copies);
    }

    public void makeUnavailable(Book book){
        available.put(book, available.get(book) - 1);
        unavailable.put(book, unavailable.get(book) + 1);
    }

    public boolean isAvailable(Book book) {
        return available.get(book) > 0;
    }

    public int getNumberOfAvailableCopies(Book book){
        return available.get(book);
    }

    public int getNumberOfUnavailableCopies(Book book){
        return unavailable.get(book);
    }

    public HashMap<Book, Integer> getAvailable() {
        return available;
    }

    public HashMap<Book, Integer> getUnavailable() {
        return unavailable;

    }


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
