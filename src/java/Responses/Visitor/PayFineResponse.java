package Responses.Visitor;

import Responses.LibraryResponse;

/**
 * Pays all or part of an outstanding fine.
 *
 * @author Henry Larson
 */
public class PayFineResponse extends LibraryResponse {
    private double balance;

    public PayFineResponse(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    // TODO - create response format
    public String toString() {
        return "";
    }
}
