package Responses.Visitor;

import Responses.LibraryResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Begins a new visit by a registered visitor.
 *
 * @author Henry Larson
 */
public class BeginVisitResponse extends LibraryResponse {
    private String visitorID;
    private String visitDate;
    private String visitStartTime;

    public BeginVisitResponse(String visitorID, String visitDate, String visitStartTime) {
        this.visitorID = visitorID;
        this.visitDate = visitDate;
        this.visitStartTime = visitStartTime;
    }

    public String toString() {
        return String.format("%s,%s,%s", visitorID, visitDate, visitStartTime);
    }
}
