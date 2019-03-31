package LibrarySystem;

import Model.Book;
import Requests.Book.BookStoreSearchRequest;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

public interface SearchProxy {

    ArrayList<Book> search(BookStoreSearchRequest bookStoreSearchRequest);


}
