package Sort;

import Model.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class is responsible for the algorithm for sorting books based on the publish date
 * @author Jimmy Dugan
 */

public class PublishDateSort implements BookSort {

    private Comparator<Book> PubDateComparator = new Comparator<Book>() {
        /**
         * @param book1
         * @param book2
         * @return int
         */
        @Override
        public int compare(Book book1, Book book2) {
            return book1.getDatePublished().compareTo(book2.getDatePublished());
        }
    };

    /**
     * sorting
     * @param books
     */
    @Override
    public void sort(ArrayList<Book> books) {
        Collections.sort(books, PubDateComparator);
    }
}
