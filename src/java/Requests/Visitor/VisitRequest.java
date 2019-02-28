package Requests.Visitor;

import Requests.LibraryRequest;

/**
 * Abstract class for visit requests. Visit by a registered visitor.
 *
 * @author Henry Larson
 */
public abstract class VisitRequest extends LibraryRequest {
    private int visitorID;

    VisitRequest(int visitorID) {
        this.visitorID = visitorID;
    }

    public int getVisitorID() {
        return visitorID;
    }
}
