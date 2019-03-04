package java;

import java.util.ArrayList;
import java.util.List;

public class LoanCommand implements Command {

  private Library library;

  public LoanCommand(Library library) {
    this.library = library;
  }

  public void execute(int visitorID, int bookID, ArrayList<Book> books) {
    try {
      library.loan(visitorID, bookID, books);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
