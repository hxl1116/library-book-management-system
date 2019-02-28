package model;

public class Loan {


    /**
     * library visitor
     */
    private Visitor visitor;

    /**
     * book being loaned out
     */
    private Book book;

    /**
     * fine
     */
    private Fine fine;

    /**
     * date booked was checked out
     */
    private String dateOut;

    /**
     * date the book was returned
     */
    private String dateIn;


    /**
     * Constructor for loan
     *
     * @param visitor
     * @param book
     * @param fine
     * @param dateOut
     * @param dateIn
     */
    public Loan(Visitor visitor, Book book, Fine fine,
                String dateOut, String dateIn){
        this.visitor = visitor;
        this.book = book;
        this.fine = fine;
        this.dateOut = dateOut;
        this.dateIn = dateIn;

    }


    /**
     * gets the visitor
     * @return
     */
    public Visitor getVisitor() {
        return visitor;
    }

    /**
     * sets the visitor
     * @param visitor
     */
    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    /**
     * gets the book
     * @return
     */
    public Book getBook() {
        return book;
    }

    /**
     * sets the book
     * @param book
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * gets the fine
     * @return
     */
    public Fine getFine() {
        return fine;
    }

    /**
     * sets the fine
     * @param fine
     */
    public void setFine(Fine fine) {
        this.fine = fine;
    }

    /**
     * gets the date book was checked out
     * @return
     */
    public String getDateOut() {
        return dateOut;
    }

    /**
     * sets the date the book was checked out
     * @param dateOut
     */
    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    /**
     * gets the date the book was returned
     * @return
     */
    public String getDateIn() {
        return dateIn;
    }

    /**
     * sets the date the book was checked in
     * @param dateIn
     */
    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }
}
