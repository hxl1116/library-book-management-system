package Requests.System;

import Requests.LibraryRequest;
import Responses.LibraryResponse;

public class DisconnectRequest extends LibraryRequest {
    private String clientID;

    public DisconnectRequest(String parameters) {
        clientID = parameters;
    }

    @Override
    public LibraryResponse execute() {
        return null;
    }
}
