package java;

import java.util.ArrayList;
import java.util.Date;

public class Visitor {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private int booksChecked;
    private ArrayList<Loan> loans;

    public Visitor(int id, String firstName, String lastName, String address,
        String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.booksChecked = 0;
        this.loans = new ArrayList<Loan>();
    }

    public void loan(Book book, Date currentDate, Date dueDate) {
        this.booksChecked++;
        this.loans.add(new Loan(this, book, currentDate, dueDate));
    }

    public boolean canLoan() {
        return this.booksChecked < 5;
    }

    public int getID() {
        return this.id;
    }

    public ArrayList<Loan> getLoans() {
        return this.loans;
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }
}
