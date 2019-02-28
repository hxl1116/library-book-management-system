package Requests.Visitor;

/**
 * Ends a visit in progress.
 *
 * @author Henry Larson
 */
public class EndVisitRequest extends VisitRequest {
    public EndVisitRequest(int visitorID) {
        super(visitorID);
    }

    public int getVisitorID() {
        return super.getVisitorID();
    }
}
