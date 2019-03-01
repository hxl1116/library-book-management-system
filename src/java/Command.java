package java;

import java.util.ArrayList;
import java.util.List;

public interface Command {

  public void execute(int visitorID, int bookID, ArrayList<Book> books);

}
