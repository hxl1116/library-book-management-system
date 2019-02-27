package java.Requests.Library;

import java.util.List;

/**
 * Reports various statistics about library usage for a period covering a specified number of days.
 *
 * @author Henry Larson
 */
public class LibraryStatisticsReportRequest {
    private List<Integer> days;

    public LibraryStatisticsReportRequest() {

    }

    public LibraryStatisticsReportRequest(List<Integer> days) {
        this.days = days;
    }

    public List<Integer> getDays() {
        return days;
    }
}
