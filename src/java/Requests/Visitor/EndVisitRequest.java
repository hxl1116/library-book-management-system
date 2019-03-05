package Requests.Visitor;

import Responses.LibraryResponse;

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

    @Override
    public LibraryResponse execute() {
        return null;
    }
}
