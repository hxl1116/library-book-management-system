package Responses.System;

import Responses.LibraryResponse;

public class UndoResponse extends LibraryResponse {
    private boolean success;

    public UndoResponse(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return success ? "success" : "failure";
    }
}
