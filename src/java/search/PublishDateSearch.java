package search;


import library.Book;

import java.util.ArrayList;

public class PublishDateSearch implements BookSearch {
    @Override
    public ArrayList<Book> search(ArrayList<Book> books, String searchData){
        ArrayList<Book> newBooks = new ArrayList<>();
        for(Book book: books){
            if(book.getPublishDate().equals(searchData)){
                newBooks.add(book);

            }
        }
        return newBooks;
    }



}


