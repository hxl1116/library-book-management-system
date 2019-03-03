package LibrarySystem;

import java.util.ArrayList;

public class Book {

    private int isbn;
    private String title;
    private ArrayList<String> authors;
    private String publisher;
    private String datePublished;
    private int pageCount;
  

    private int bookID;



    public Book(int isbn, String title, ArrayList<String> authors, String publisher, String datePublished, int pageCount){

        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.datePublished = datePublished;
        this.pageCount = pageCount;


    }

    public String getPublishDate(){
        return datePublished;
    }

    public String getTitle(){
        return title;
    }


    public ArrayList<String> getAuthors() {
        return authors;
    }


    public int getIsbn() {
        return isbn;
    }

    public int getBookID() {
        return bookID;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getPublisher() {
        return publisher;
    }

}
