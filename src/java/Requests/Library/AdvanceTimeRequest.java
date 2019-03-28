package Requests.Library;

import LibrarySystem.Library;
import Requests.LibraryRequest;
import Responses.Library.AdvanceTimeResponse;
import Responses.LibraryResponse;

/**
 * For simulation purposes. This method will advance the simulated date of the library ahead by a specified number of
 * days and/or hours. The total number of days/hours advanced must be tracked by the system and added to the current
 * date as appropriate (e.g. to determine if books are overdue).
 *
 * @author Henry Larson
 */
public class AdvanceTimeRequest extends LibraryRequest {
    private int numberOfDays;
    private int numberOfHours = 0;

    public AdvanceTimeRequest(String parameters) {
        if (parameters.contains(",")) numberOfDays = Integer.parseInt(parameters);
        else {
            String[] params = parameters.split(",");
            numberOfDays = Integer.parseInt(params[0]);
            numberOfHours = Integer.parseInt(params[1]);
        }
    }

    @Override
    public LibraryResponse execute() {
        Library.advanceTime(numberOfDays, numberOfHours);
        return new AdvanceTimeResponse();
    }

    @Override
    // TODO - Create method call for undoing request (not undoable)
    public LibraryRequest undo() {
        return null;
    }
}
