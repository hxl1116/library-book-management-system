package Sort;


import Model.Book;

import java.util.ArrayList;

/**
 * This class is responsible for the execution of the particular sort strategy which is set by setBookSort
 */

public class SortContext {

    BookSort bookSort;

    /**
     * @param bookSort
     */
    public void setBookSort(BookSort bookSort){
        this.bookSort = bookSort;
    }

    /**
     * @param books
     */
    public void makeSort(ArrayList<Book> books){
        bookSort.sort(books);
    }


}
