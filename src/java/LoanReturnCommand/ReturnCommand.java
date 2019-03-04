package LoanReturnCommand;

import LibrarySystem.Library;
import LoanReturnCommand.Command;
import Model.Book;
import java.util.ArrayList;

public class ReturnCommand implements Command {

  private Library library;

  public ReturnCommand(Library library) {
    this.library = library;
  }

  public void execute(String visitorID, int bookID, ArrayList<Book> books) {
    try {
      library.returnBook(visitorID, bookID);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
