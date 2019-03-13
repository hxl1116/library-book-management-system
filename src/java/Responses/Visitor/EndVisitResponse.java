package Responses.Visitor;

import LibrarySystem.Library;
import Responses.LibraryResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Ends a visit in progress.
 *
 * @author Henry Larson
 */
public class EndVisitResponse extends LibraryResponse {
    private String visitorID;
    private Date visitEndTime;
    private Date visitDuration;

    public EndVisitResponse(String visitorID, Date visitEndTime, Date visitDuration) {
        this.visitorID = visitorID;
        this.visitEndTime = visitEndTime;
        this.visitDuration = visitDuration;
    }

    public String toString() {
        return String.format("depart,%s,%s,%s",
                visitorID,
                Library.DATE_FORMAT.format(visitEndTime),
                Library.TIME_FORMAT.format(visitDuration)
        );
    }
}
