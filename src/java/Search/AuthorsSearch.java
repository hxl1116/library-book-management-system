package Search;


import Model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class is responsible for the algorithm for searching for a book based on the author(s)
 */


public class AuthorsSearch implements BookSearch {
    /**
     * @param books
     * @param searchParam
     * @return ArrayList<Book>
     */
    @Override
    public ArrayList<Book> search(ArrayList<Book> books, String searchParam) {
        ArrayList<Book> newBooks = new ArrayList<>();
        for (Book book : books) {
            String replace = searchParam.replace("{", "");
            String replace1 = replace.replace("}", "");
            List<String> searchList = new ArrayList<String>(Arrays.asList(replace1.split(",")));

            if (Collections.indexOfSubList(book.getAuthorsAsList(), searchList) != -1) {
                newBooks.add(book);
            }
        }
        return newBooks;
    }
}
