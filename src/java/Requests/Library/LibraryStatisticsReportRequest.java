package Requests.Library;

import Requests.LibraryRequest;
import Responses.Library.LibraryStatisticsReportResponse;
import Responses.LibraryResponse;

import java.util.List;

/**
 * Reports various statistics about library usage for a period covering a specified number of days.
 *
 * @author Henry Larson
 */
public class LibraryStatisticsReportRequest extends LibraryRequest {
    private int days;

    public LibraryStatisticsReportRequest(String parameters) {
        days = Integer.parseInt(parameters);
    }

    @Override
    // TODO - Create method call for response data
    public LibraryResponse execute() {
        return new LibraryStatisticsReportResponse(null,
                0,
                0,
                0.0,
                0,
                0.0,
                0.0
        );
    }

    @Override
    // TODO - Create method call for undoing request (not undoable)
    public LibraryRequest undo() {
        return null;
    }
}
