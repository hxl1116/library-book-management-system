package Requests.Visitor;

import Requests.LibraryRequest;
import Responses.LibraryResponse;
import Responses.Visitor.PayFineResponse;

/**
 * Pays all or part of an outstanding fine.
 *
 * @author Henry Larson
 */
public class PayFineRequest extends LibraryRequest {
    private String visitorID;
    private double amount;

    public PayFineRequest(String parameters) {
        String[] params = parameters.split(",");
        visitorID = params[0];
        amount = Double.parseDouble(params[1]);
    }

    @Override
    // TODO - Create method call for response data
    public LibraryResponse execute() {
        return new PayFineResponse(0.0);
    }
}
