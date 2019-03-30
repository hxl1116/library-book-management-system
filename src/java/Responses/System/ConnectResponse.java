package Responses.System;

import Responses.LibraryResponse;

public class ConnectResponse extends LibraryResponse {
    private String clientID;

    public ConnectResponse(String clientID) {
        this.clientID = clientID;
    }

    @Override
    public String toString() {
        return String.format("connect,%s;", clientID);
    }
}
