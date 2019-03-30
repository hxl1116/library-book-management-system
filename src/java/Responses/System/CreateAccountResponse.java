package Responses.System;

import Responses.LibraryResponse;

public class CreateAccountResponse extends LibraryResponse {
    private String clientID;
    private boolean success;

    public CreateAccountResponse(String clientID, boolean success) {
        this.clientID = clientID;
        this.success = success;
    }

    @Override
    public String toString() {
        return String.format("%s,create,%s", clientID, success ? "success" : "failure");
    }
}
