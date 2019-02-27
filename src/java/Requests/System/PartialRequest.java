package java.Requests.System;

/**
 * The client sends a partial request (i.e. any request not terminated by a semi-colon).
 *
 * @author Henry Larson
 */
public class PartialRequest {
    private String partial;

    public PartialRequest(String partial) {
        this.partial = partial;
    }

    public String getPartial() {
        return partial;
    }
}
