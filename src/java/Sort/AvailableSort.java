package Sort;

import LibrarySystem.Library;
import Model.Book;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class is responsible for the algorithm for sorting books based on the availability
 */

public class AvailableSort implements BookSort {
    /**
     * @param books
     */
    @Override
    public void sort(ArrayList<Book> books) {
        books.sort(Comparator.comparing(Library::getNumAvailable));
    }
}
