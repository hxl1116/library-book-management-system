package Responses.System;

/**
 * The client sends a partial request (i.e. any request not terminated by a semi-colon).
 *
 * @author Henry Larson
 */
public class PartialResponse {
    private String partial;

    public PartialResponse(String partial) {
        this.partial = partial;
    }

    public String getPartial() {
        return partial;
    }

    // TODO - create response format
    public String toString() {
        return "";
    }
}
