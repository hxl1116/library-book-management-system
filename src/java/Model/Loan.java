package Model;

import Model.Visitor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Loan {

  /**
   * Class that represents a loaned book
   */
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

  /**
   * Gets the book of this loan
   * @return Book object
   */
  public Book getBook() {
    return this.book;
  }

  /**
   * Gets the visitor that has made this loan
   * @return Visitor object
   */
  public Visitor getVisitor() {
    return this.visitor;
  }

  /**
   * Turns the loan into a String for printing
   * @return String format of loan
   */
  public String toString() {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    return book.toStringBorrowed() + "," + dateFormat.format(dateOut);
  }
}
