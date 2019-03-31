package Requests.System;

import Requests.LibraryRequest;
import Responses.LibraryResponse;

public class CreateAccountRequest extends LibraryRequest {
    private String clientID;
    private String username;
    private String password;
    private String role;
    private String visitorID;

    public CreateAccountRequest(String parameters) {
        String[] params = parameters.split(",");
        clientID = params[0];
        username = params[1];
        password = params[2];
        role = params[3];
        visitorID = params[4];
    }

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
