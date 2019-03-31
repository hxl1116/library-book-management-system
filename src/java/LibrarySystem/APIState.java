package LibrarySystem;

import Model.Book;
import Requests.Book.BookStoreSearchRequest;

import java.util.ArrayList;

public class APIState implements SearchState{


    @Override
    public ArrayList<Book> searchWithState(SearchStateContext context, ArrayList<Book> books, BookStoreSearchRequest bookStoreSearchRequest) {

        ArrayList<Book> list = new ArrayList<>();


        SearchProxy searchProxy = new APISearch();
        try
        {
            return searchProxy.search(bookStoreSearchRequest);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());

        }

        return null;


    }
}
