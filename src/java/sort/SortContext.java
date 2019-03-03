package sort;

import library.Book;

import java.util.ArrayList;

public class SortContext {

    BookSort bookSort;

    public void setBookSort(BookSort bookSort){
        this.bookSort = bookSort;
    }

    public void makeSort(ArrayList<Book> books){
        bookSort.sort(books);
    }


}
