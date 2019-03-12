package Requests.Visitor;

import Responses.LibraryResponse;

/**
 * Ends a visit in progress.
 *
 * @author Henry Larson
 */
public class EndVisitRequest extends VisitRequest {
    public EndVisitRequest(String visitorID) {
        super(visitorID);
    }

    public String getVisitorID() {
        return super.getVisitorID();
    }

    @Override
    public LibraryResponse execute() {
        return null;
    }
}
