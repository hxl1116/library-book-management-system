package Requests.Library;

import Requests.LibraryRequest;

/**
 * For simulation purposes. This method will advance the simulated date of the library ahead by a specified number of
 * days and/or hours. The total number of days/hours advanced must be tracked by the system and added to the current
 * date as appropriate (e.g. to determine if books are overdue).
 *
 * @author Henry Larson
 */
public class AdvanceTimeRequest extends LibraryRequest {
    private int numberOfDays;
    private int numberOfHours;

    public AdvanceTimeRequest(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public AdvanceTimeRequest(int numberOfDays, int numberOfHours) {
        this.numberOfDays = numberOfDays;
        this.numberOfHours = numberOfHours;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }
}
