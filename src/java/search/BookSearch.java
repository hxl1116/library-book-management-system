package search;


import temps.Book;

import java.util.ArrayList;

public interface BookSearch {

    ArrayList<Book> search(ArrayList<Book> books, String searchParam);
}
