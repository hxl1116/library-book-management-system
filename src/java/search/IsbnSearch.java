package search;



import Model.Book;

import java.util.ArrayList;

public class IsbnSearch implements BookSearch {
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


