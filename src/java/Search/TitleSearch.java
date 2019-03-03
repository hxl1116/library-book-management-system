package Search;




import Model.Book;

import java.util.ArrayList;

public class TitleSearch implements BookSearch {
    @Override
    public ArrayList<Book> search(ArrayList<Book> books, String searchData){
        ArrayList<Book> newBooks = new ArrayList<>();
        for(Book book: books){
            if(book.getTitle().equals(searchData)){
                newBooks.add(book);
            }
        }
        return newBooks;
    }
}


