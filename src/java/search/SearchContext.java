package search;



import LibrarySystem.Book;

import java.util.ArrayList;

public class SearchContext {

    private BookSearch search;

    public void setSearch(BookSearch search){
        this.search = search;
    }

    public ArrayList<Book> search(ArrayList<Book> books, String peram){
        return search.search(books, peram);
    }
}
