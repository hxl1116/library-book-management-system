package LibrarySystem;

import Model.Book;
import Requests.Book.BookStoreSearchRequest;

import java.util.ArrayList;

public interface SearchState {


    ArrayList<Book> searchWithState (SearchStateContext context, ArrayList<Book> books, BookStoreSearchRequest bookStoreSearchRequest);

}
