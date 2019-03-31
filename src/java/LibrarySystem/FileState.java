package LibrarySystem;

import Model.Book;
import Requests.Book.BookStoreSearchRequest;
import Search.*;
import Sort.AvailableSort;
import Sort.PublishDateSort;
import Sort.SortContext;
import Sort.TitleSort;

import java.util.ArrayList;
import java.util.Arrays;

public class FileState implements SearchState {


    @Override
    public ArrayList<Book> searchWithState(SearchStateContext context, ArrayList<Book> books, BookStoreSearchRequest bookStoreSearchRequest) {

        //Search context
        SearchContext searchContext = new SearchContext();
        //Sort context
        SortContext sortContext = new SortContext();

        ArrayList<Book> searchResults;
        searchResults = books;

        if (!(bookStoreSearchRequest.getTitle().equals("*"))) {
            searchContext.setSearch(new TitleSearch());
            searchResults = searchContext.search(searchResults, bookStoreSearchRequest.getTitle());
        }

        if (!(bookStoreSearchRequest.getAuthors()[0].equals("*"))) {
            searchContext.setSearch(new AuthorsSearch());
            searchResults = searchContext.search(searchResults, Arrays.toString(bookStoreSearchRequest.getAuthors()));
        }

        String requestIsbn = Long.toString(bookStoreSearchRequest.getIsbn());
        if (!(requestIsbn.equals("*"))) {
            searchContext.setSearch(new IsbnSearch());
            searchResults = searchContext.search(searchResults, requestIsbn);
        }

        if (!(bookStoreSearchRequest.getPublisher().equals("*"))) {
            searchContext.setSearch(new PublishDateSearch());
            searchResults = searchContext.search(searchResults, bookStoreSearchRequest.getPublisher());
        }

        if (!bookStoreSearchRequest.getSortOrder().equals("title") || !bookStoreSearchRequest.getSortOrder().equals("publish-date") || !bookStoreSearchRequest.getSortOrder().equals("book-status")) {
            //returns an error is user enters invalid Sort type
            return null;
        } else {

            switch (bookStoreSearchRequest.getSortOrder()) {

                case "title":
                    sortContext.setBookSort(new TitleSort());
                    sortContext.makeSort(searchResults);
                case "publish-date":
                    sortContext.setBookSort(new PublishDateSort());
                    sortContext.makeSort(searchResults);
                case "book-status":
                    sortContext.setBookSort(new AvailableSort());
                    sortContext.makeSort(searchResults);

            }
            //returns a list of searched and sorted books (if any)
            return searchResults;
        }
    }



}
