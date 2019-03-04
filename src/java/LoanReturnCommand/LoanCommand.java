package LoanReturnCommand;

import LibrarySystem.Library;
import LoanReturnCommand.Command;
import Model.Book;
import java.util.ArrayList;

public class LoanCommand implements Command {

  private Library library;

  public LoanCommand(Library library) {
    this.library = library;
  }

  public void execute(String visitorID, int bookID, ArrayList<Book> books) {
    try {
      library.loan(visitorID, bookID, books);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
