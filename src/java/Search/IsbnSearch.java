package Search;



import Model.Book;

import java.util.ArrayList;

/**
 * This class is responsible for the algorithm for searching for a book based on the isbn
 */

public class IsbnSearch implements BookSearch {
    /**
     * @param books
     * @param searchData
     * @return ArrayList<Book>
     */
    @Override
    public ArrayList<Book> search(ArrayList<Book> books, String searchData){
        ArrayList<Book> newBooks = new ArrayList<>();
        for(Book book: books){
            if(book.getIsbn()== Integer.parseInt(searchData)){
                newBooks.add(book);
            }
        }
        return newBooks;
    }
}


