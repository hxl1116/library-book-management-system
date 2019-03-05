package Requests.Visitor;

import Requests.LibraryRequest;
import Responses.LibraryResponse;

/**
 * Pays all or part of an outstanding fine.
 *
 * @author Henry Larson
 */
public class PayFineRequest extends LibraryRequest {
    private int visitorID;
    private double amount;

    public PayFineRequest(int visitorID, double amount) {
        this.visitorID = visitorID;
        this.amount = amount;
    }

    public int getVisitorID() {
        return visitorID;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public LibraryResponse execute() {
        return null;
    }
}
