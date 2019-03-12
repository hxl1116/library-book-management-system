package Requests.Visitor;

import Requests.LibraryRequest;

/**
 * Abstract class for visit requests. Visit by a registered visitor.
 *
 * @author Henry Larson
 */
public abstract class VisitRequest extends LibraryRequest {
    private String visitorID;

    VisitRequest(String parameters) {
        visitorID = parameters;
    }

    public String getVisitorID() {
        return visitorID;
    }
}
