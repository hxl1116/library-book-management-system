package sort;




import LibrarySystem.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TitleSort implements BookSort {

    private Comparator<Book> TitleComparator = new Comparator<Book>() {

        @Override
        public int compare(Book book1, Book book2) {
            return book1.getTitle().toUpperCase().compareTo(book2.getTitle().toUpperCase());
        }
    };

    @Override
    public void sort(ArrayList<Book> books) {
        Collections.sort(books, TitleComparator);
    }}



