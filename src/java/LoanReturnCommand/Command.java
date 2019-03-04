package LoanReturnCommand;

import Model.Book;
import java.util.ArrayList;

/**
 * Interface for the Loan and Return commands
 */
public interface Command {

  /**
   * Method that will be implemented by the concrete classes
   * @param visitorID unique ID of visitor being loaned to or returning
   * @param bookID location of the book in the book list
   * @param books list of books that could be loaned/returned
   */
  public void execute(String visitorID, int bookID, ArrayList<Book> books);

}
