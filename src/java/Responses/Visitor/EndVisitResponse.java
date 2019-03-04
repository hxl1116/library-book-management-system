package Responses.Visitor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Ends a visit in progress.
 *
 * @author Henry Larson
 */
public class EndVisitResponse {
    // YYYY/MM/DD format
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    // HH:MM:SS
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

    private int visitorID;
    private Date visitEndTime;
    private Date visitDuration;

    public EndVisitResponse(int visitorID, Date visitEndTime, Date visitDuration) {
        this.visitorID = visitorID;
        this.visitEndTime = visitEndTime;
        this.visitDuration = visitDuration;
    }

    public int getVisitorID() {
        return visitorID;
    }

    public Date getVisitEndTime() {
        return visitEndTime;
    }

    public Date getVisitDuration() {
        return visitDuration;
    }

    // TODO - create response format
    public String toString() {
        return "";
    }
}
