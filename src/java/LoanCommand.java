package java;

public class LoanCommand implements Command {

  private Library library;

  public LoanCommand(Library library) {
    this.library = library;
  }

  public void execute(int visitorID, int bookID) {
    try {
      library.loan(visitorID, bookID);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
