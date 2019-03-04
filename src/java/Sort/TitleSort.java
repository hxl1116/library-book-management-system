package Sort;

import Model.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class is responsible for the algorithm for sorting books based on the title
 */

public class TitleSort implements BookSort {

    private Comparator<Book> TitleComparator = new Comparator<Book>() {

        /**
         * @param book1
         * @param book2
         * @return
         */
        @Override
        public int compare(Book book1, Book book2) {
            return book1.getTitle().toUpperCase().compareTo(book2.getTitle().toUpperCase());
        }
    };

    /**
     * @param books
     */
    @Override
    public void sort(ArrayList<Book> books) {
        Collections.sort(books, TitleComparator);
    }}



