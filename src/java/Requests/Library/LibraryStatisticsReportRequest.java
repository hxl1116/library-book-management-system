package Requests.Library;

import Requests.LibraryRequest;

import java.util.List;

/**
 * Reports various statistics about library usage for a period covering a specified number of days.
 *
 * @author Henry Larson
 */
public class LibraryStatisticsReportRequest extends LibraryRequest {
    private int days;

    public LibraryStatisticsReportRequest() {

    }

    public LibraryStatisticsReportRequest(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}
