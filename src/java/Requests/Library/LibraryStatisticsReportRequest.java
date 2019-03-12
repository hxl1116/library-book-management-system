package Requests.Library;

import Requests.LibraryRequest;
import Responses.LibraryResponse;

import java.util.List;

/**
 * Reports various statistics about library usage for a period covering a specified number of days.
 *
 * @author Henry Larson
 */
// TODO - Refactor for parameter parsing
public class LibraryStatisticsReportRequest extends LibraryRequest {
    private int days;

    public LibraryStatisticsReportRequest(int days) {
        this.days = days;
    }

    @Override
    public LibraryResponse execute() {
        return null;
    }
}
