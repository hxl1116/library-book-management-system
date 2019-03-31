package Responses.System;

import Responses.LibraryResponse;

public class RedoResponse extends LibraryResponse {
    private boolean success;

    public RedoResponse(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return success ? "success" : "failure";
    }
}
