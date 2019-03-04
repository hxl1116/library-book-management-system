package Sort;

import Model.Book;

import java.util.ArrayList;

/**
 * Interface to outline the method to be used in the sorting strategies
 * @author Jimmy Dugan
 */

public interface BookSort {

    /**
     * @param books
     */
    void sort(ArrayList<Book> books);
}
