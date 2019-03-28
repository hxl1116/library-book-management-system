package Requests.Library;

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
    // TODO - Create method call for response data
    public LibraryResponse execute() {
        return new CurrentTimeDateResponse("", "");
    }

    @Override
    // TODO - Create method call for undoing request (not undoable)
    public LibraryRequest undo() {
        return null;
    }
}
