package Requests.Library;

import LibrarySystem.Library;
import Requests.LibraryRequest;
import Responses.Library.CurrentTimeDateResponse;
import Responses.LibraryResponse;

/**
 * Displays the current date and time in the simulation. This should include any days that have been added to the
 * calendar using the command to advance time.
 *
 * @author Henry Larson
 */
public class CurrentDateTimeRequest extends LibraryRequest {

    @Override
    public LibraryResponse execute() {
        String[] date = Library.getCurrentDate();
        return new CurrentTimeDateResponse(date[0], date[1]);
    }

    @Override
    // TODO - Create method call for undoing request (not undoable)
    public LibraryRequest undo() {
        return null;
    }
}
