package Requests.Visitor;

import Responses.LibraryResponse;

/**
 * Begins a new visit by a registered visitor.
 *
 * @author Henry Larson
 */
public class BeginVisitRequest extends VisitRequest {
    public BeginVisitRequest(int visitorID) {
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
