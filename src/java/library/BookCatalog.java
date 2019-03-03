package library;

import purchase.TempPurchaseRequest;
import search.*;
import search.Error;
import sort.AvailableSort;
import sort.PublishDateSort;
import sort.SortContext;
import sort.TitleSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookCatalog {

    HashMap<Book,Integer> available = new HashMap<>();
    HashMap<Book,Integer> unavailable = new HashMap<>();
    private ArrayList<Book> books;
    private TempSearchRequest tempSearchRequest;
    private TempPurchaseRequest tempPurchaseRequest;

    public BookCatalog(ArrayList<Book> books, TempSearchRequest tempSearchRequest){
        this.books = books;
        this.tempSearchRequest = tempSearchRequest;

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


        //search context
        SearchContext context = new SearchContext();
        //sort context
        SortContext sortContext = new SortContext();

        ArrayList<Book> searchResults;
        searchResults = books;

        if (!(tempSearchRequest.getTitle().equals("*"))) {
            context.setSearch(new TitleSearch());
            searchResults = context.search(searchResults, tempSearchRequest.getTitle());
        }
        if (!(tempSearchRequest.getAuthors().get(0).equals("*"))) {
            context.setSearch(new AuthorsSearch());
            searchResults = context.search(searchResults, tempSearchRequest.getAuthors().toString());
        }
        if (!(tempSearchRequest.getIsbn().equals("*"))) {
            context.setSearch(new IsbnSearch());
            searchResults = context.search(searchResults, tempSearchRequest.getIsbn());
        }
        if (!(tempSearchRequest.getPublisher().equals("*"))) {
            context.setSearch(new PublishDateSearch());
            searchResults = context.search(searchResults, tempSearchRequest.getIsbn());
        }

        if(!tempSearchRequest.getSortType().equals("title") || !tempSearchRequest.getSortType().equals("publish-date") || !tempSearchRequest.getSortType().equals("book-status")){
            //returns an error is user enters invalid sort type
            return Error.InvalidSortOrder;
        }

        else{

            switch (tempSearchRequest.getSortType()) {

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
        List<Integer> iDList = tempPurchaseRequest.getBooksIDs();
        int quantity = tempPurchaseRequest.getQuantity();
        for(Integer id: iDList){
            for(Book book: books){
                if(book.getBookID() == id){
                    if(available.containsKey(book))
                        available.put(book, available.get(book) + quantity);
                    else
                        available.put(book, quantity);
                }
            }
        }
    }
}