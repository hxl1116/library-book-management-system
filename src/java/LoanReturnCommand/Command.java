package LoanReturnCommand;

import Model.Book;
import java.util.ArrayList;

public interface Command {

  public void execute(String visitorID, int bookID, ArrayList<Book> books);

}
