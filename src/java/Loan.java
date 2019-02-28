package java;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Loan {

  private Visitor visitor;
  private Book book;
  private Date dateOut;
  private Date dateDue;

  public Loan(Visitor visitor, Book book, Date dateOut, Date dateDue) {
    this.visitor = visitor;
    this.book = book;
    this.dateOut = dateOut;
    this.dateDue = dateDue;
  }

  public Book getBook() {
    return this.book;
  }

  public Visitor getVisitor() {
    return this.visitor;
  }

  public String toString() {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    return book.toStringBorrowed() + "," + dateFormat.format(dateOut);
  }
}
