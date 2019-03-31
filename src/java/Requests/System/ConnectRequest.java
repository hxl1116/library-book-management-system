package Requests.System;

import Requests.LibraryRequest;
import Responses.LibraryResponse;

public class ConnectRequest extends LibraryRequest {
    @Override
    public LibraryResponse execute() {
        return null;
    }

    @Override
    // TODO - Create method call for undoing request (not undoable)
    public LibraryRequest undo() {
        return null;
    }
}
