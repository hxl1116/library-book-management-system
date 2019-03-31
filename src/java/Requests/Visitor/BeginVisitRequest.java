package Requests.Visitor;

import LibrarySystem.Library;
import Requests.LibraryRequest;
import Responses.LibraryResponse;
import Responses.Visitor.BeginVisitResponse;

/**
 * Begins a new visit by a registered visitor.
 *
 * @author Henry Larson
 */
public class BeginVisitRequest extends VisitRequest {
    public BeginVisitRequest(String parameters) {
        super(parameters);
    }

    @Override
    public String getVisitorID() {
        return super.getVisitorID();
    }

    @Override
    public LibraryResponse execute() {
        String[] dates = Library.beginVisit();
        return new BeginVisitResponse(getVisitorID(), dates[0], dates[1]);
    }

    @Override
    // TODO - Create method call for undoing request (not undoable)
    public LibraryRequest undo() {
        return null;
    }
}
