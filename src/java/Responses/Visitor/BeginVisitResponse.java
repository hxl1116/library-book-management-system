package java.Responses.Visitor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Begins a new visit by a registered visitor.
 *
 * @author Henry Larson
 */
public class BeginVisitResponse {
    // YYYY/MM/DD format
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    // HH:MM:SS
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

    private int visitorID;
    private Date visitDate;
    private Date visitStartTime;

    public BeginVisitResponse(int visitorID, Date visitDate, Date visitStartTime) {
        this.visitorID = visitorID;
        this.visitDate = visitDate;
        this.visitStartTime = visitStartTime;
    }

    public int getVisitorID() {
        return visitorID;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public Date getVisitStartTime() {
        return visitStartTime;
    }

    // TODO - create response format
    public String toString() {
        return "";
    }
}
