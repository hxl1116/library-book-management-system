package Responses.System;

import Responses.LibraryResponse;

public class DisconnectResponse extends LibraryResponse {
    private String clientID;

    public DisconnectResponse(String clientID) {
        this.clientID = clientID;
    }

    @Override
    public String toString() {
        return String.format("%s,disconnect;", clientID);
    }
}
