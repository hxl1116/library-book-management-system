package java.Responses.System;

/**
 * Many requests must include required parameters. The following response format is always used if one or more
 * parameters are missing for a request.
 *
 * @author Henry Larson
 */
public class MissingParametersResponse {
    private String[] missingParameters;

    public MissingParametersResponse(String... missingParameters) {
        this.missingParameters = missingParameters;
    }

    public String[] getMissingParameters() {
        return missingParameters;
    }

    // TODO - create response format
    public String toString() {
        return "";
    }
}
