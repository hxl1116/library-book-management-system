package LoanReturnCommand;

import LibrarySystem.Library;
import LoanReturnCommand.Command;
import Model.Book;
import java.util.ArrayList;

/**
 * Concrete command that implements the Command interface. Used to loan a book to a visitor
 */
public class LoanCommand implements Command {

  private Library library;

  public LoanCommand(Library library) {
    this.library = library;
  }

  /**
   *
   * @param visitorID unique ID of visitor being loaned to or returning
   * @param bookID location of the book in the book list
   * @param books list of books that could be loaned
   */
  public void execute(String visitorID, int bookID, ArrayList<Book> books) {
    try {
      library.loan(visitorID, bookID, books);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
