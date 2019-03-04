package Sort;

import LibrarySystem.Library;
import Model.Book;

import java.util.ArrayList;
import java.util.Comparator;

public class AvailableSort implements BookSort {
    @Override
    public void sort(ArrayList<Book> books) {
        books.sort(Comparator.comparing(Library::getNumAvailable));
    }
}
