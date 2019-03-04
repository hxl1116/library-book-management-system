package Search;

import Model.Book;

import java.util.ArrayList;

/**
 * Interface responsible for outlining the search method which will be used in the algorithm implementations
 */

public interface BookSearch {
    /**
     * @param books
     * @param searchParam
     * @return
     */
    ArrayList<Book> search(ArrayList<Book> books, String searchParam);
}
