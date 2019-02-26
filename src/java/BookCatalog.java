package java;

import java.util.HashMap;
import java.util.List;

public class BookCatalog {

    HashMap<Book,Integer> available = new HashMap<>();
    HashMap<Book,Integer> unavailable = new HashMap<>();
    private List<Book> books;

    public BookCatalog(List<Book> books){
        this.books = books;

    }

    public void makeAvailable(String bookName){

    }

    public void makeUnavailable(String bookName){


    }



}
