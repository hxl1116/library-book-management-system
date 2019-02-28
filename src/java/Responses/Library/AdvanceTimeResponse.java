package Responses.Library;

/**
 * For simulation purposes. This method will advance the simulated date of the library ahead by a specified number of
 * days and/or hours. The total number of days/hours advanced must be tracked by the system and added to the current
 * date as appropriate (e.g. to determine if books are overdue).
 *
 * @author Henry Larson
 */
public class AdvanceTimeResponse {
    private boolean success;

    public AdvanceTimeResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    // TODO - create response format
    public String toString() {
        return "";
    }
}
