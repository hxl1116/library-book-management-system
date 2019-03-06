package Responses.Library;

import Responses.LibraryResponse;

/**
 * For simulation purposes. This method will advance the simulated date of the library ahead by a specified number of
 * days and/or hours. The total number of days/hours advanced must be tracked by the system and added to the current
 * date as appropriate (e.g. to determine if books are overdue).
 *
 * @author Henry Larson
 */
public class AdvanceTimeResponse extends LibraryResponse{
    public AdvanceTimeResponse() {

    }

    public String toString() {
        return "advance,success";
    }
}
