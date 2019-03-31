package LibrarySystem;

import Model.Book;
import Requests.Book.BookStoreSearchRequest;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

import static LibrarySystem.GoogleBooksAPI.makeUrlQuery;
import static LibrarySystem.GoogleBooksAPI.retrieveJson;

public class APISearch implements SearchProxy{


    private ArrayList<Book> googleBooks = new ArrayList<>();

    @Override
    public ArrayList<Book> search(BookStoreSearchRequest bookStoreSearchRequest){

        GoogleBooksAPI google = new GoogleBooksAPI();

        ArrayList<String> authors = new ArrayList<>();

        String url = makeUrlQuery(bookStoreSearchRequest.getTitle(), bookStoreSearchRequest.getAuthors(), Integer.toString(bookStoreSearchRequest.getIsbn()),bookStoreSearchRequest.getPublisher());

        try {
            googleBooks.addAll(google.booksFromAPI(retrieveJson(url)));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return googleBooks;

    }
}
