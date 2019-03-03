package java;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;

public class BookCatalog {

    HashMap<Book,Integer> available = new HashMap<>();
    HashMap<Book,Integer> unavailable = new HashMap<>();
    private List<Book> books;

    public BookCatalog(List<Book> books){
        this.books = books;

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



}
