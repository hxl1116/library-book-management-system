package LibrarySystem;

import Model.Book;
import Requests.Book.BookStoreSearchRequest;

import java.util.ArrayList;

public class SearchStateContext {

    private SearchState searchState;

    public SearchStateContext(){

        searchState= new FileState();
    }

    void setSearchState(SearchState newState){
        searchState = newState;
    }

    public ArrayList<Book> searchWithState(ArrayList<Book> books, BookStoreSearchRequest bookStoreSearchRequest){
        return searchState.searchWithState(this, books, bookStoreSearchRequest);
    }

}
