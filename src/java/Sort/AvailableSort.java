package Sort;



import LibrarySystem.BookCatalog;
import LibrarySystem.Library;
import Model.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AvailableSort implements BookSort {

    private Comparator<Book> NumAvailComparator = new Comparator<Book>() {
        @Override
        public int compare(Book book1, Book book2) {
            Library library = new Library();
            return library.getNumAvailable(book1).compareTo(library.getNumAvailable(book2));
        }
    };

    @Override
    public void sort(ArrayList<Book> books) {
        Collections.sort(books, NumAvailComparator);
    }
}
