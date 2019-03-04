package LoanReturnCommand;

import LibrarySystem.Library;
import LoanReturnCommand.Command;
import Model.Book;
import java.util.ArrayList;

/**
 * Concrete command that implements the Command interface. Used to return a loaned book to the
 * library.
 */
public class ReturnCommand implements Command {

  private Library library;

  public ReturnCommand(Library library) {
    this.library = library;
  }

  /**
   *
   * @param visitorID unique ID of visitor being loaned to or returning
   * @param bookID location of the book in the book list
   * @param books list of books that could be returned
   */
  public void execute(String visitorID, int bookID, ArrayList<Book> books) {
    try {
      library.returnBook(visitorID, bookID);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
