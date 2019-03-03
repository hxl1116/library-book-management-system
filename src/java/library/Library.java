package library;


import search.TempSearchRequest;

public class Library {

    private BookCatalog bookCatalog;
    private VisitorTracker visitorTracker;
    private String currentDate;
    private Integer currentTime;


    public void loadData(String filename){

    }

    public void saveData(String filename){

    }

    public Integer getNumAvailable(Book book){
        return bookCatalog.getAvailable().get(book);
    }

    public Integer getNumUnvailable(Book book){
        return bookCatalog.getUnavailable().get(book);
    }

    public Integer getTotalNumAvailable(Book book){
        return this.getNumAvailable(book)+this.getNumUnvailable(book);
    }










}
