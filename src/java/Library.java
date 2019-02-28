package java;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Library {

    private BookCatalog bookCatalog;
    private VisitorTracker visitorTracker;
    private String currentDate;
    private Integer currentTime;

    public Library() {
        this.currentDate = "01/01/2019";
        this.visitorTracker = new VisitorTracker();
        this.bookCatalog = new BookCatalog();
    }

    public void loadData(String filename){

    }


    public void saveData(String filename){


    }

    public void loan(Visitor visitor, Book book) throws Exception {
        if (!bookCatalog.isAvailable(book) || !visitor.canLoan()) {
            System.out.println("Book unavailable or max loans reached.");
        }
        else {
            bookCatalog.makeUnavailable(book);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(currentDate);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, 7);
            Date dueDate = c.getTime();
            date = sdf.parse(currentDate);
            visitor.loan(book, date, dueDate);
        }
    }

    public void printLoans(int visitorID) {
        ArrayList<Loan> loans = visitorTracker.findVisitorByID(visitorID).getLoans();
        int i = 0;
        for (Loan loan : loans) {
            i++;
            System.out.println(Integer.toString(i) + "," + loan.toString());
        }

    }

    public void returnBook(int visitorID, int bookID) {
        Visitor visitor = visitorTracker.findVisitorByID(visitorID);
        ArrayList<Loan> loans = visitor.getLoans();
        try {
            Loan loan = loans.get(bookID - 1);
            Book book = loan.getBook();
            visitor.removeLoan(loan);
            bookCatalog.makeAvailable(book, 1);

        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid ID");
        }

    }



}
