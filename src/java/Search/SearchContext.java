package Search;



import Model.Book;

import java.util.ArrayList;

/**
 * This class is responsible for the execution of the particular search strategy which is set by setSearch
 * @author Jimmy Dugan
 */

public class SearchContext {

    private BookSearch search;

    /**
     * @param search
     */
    public void setSearch(BookSearch search){
        this.search = search;
    }


    /**
     * @param books
     * @param peram
     * @return ArrayList<Book>
     */
    public ArrayList<Book> search(ArrayList<Book> books, String peram){
        return search.search(books, peram);
    }
}
