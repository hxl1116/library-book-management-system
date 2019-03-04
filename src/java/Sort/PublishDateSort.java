package Sort;




import Model.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PublishDateSort implements BookSort {

    private Comparator<Book> PubDateComparator = new Comparator<Book>() {
        @Override
        public int compare(Book book1, Book book2) {
            return book1.getDatePublished().compareTo(book2.getDatePublished());
        }
    };

    @Override
    public void sort(ArrayList<Book> books) {
        Collections.sort(books, PubDateComparator);
    }
}
