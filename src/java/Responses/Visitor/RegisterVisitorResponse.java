package Responses.Visitor;

import Responses.LibraryResponse;

import java.util.Date;

/**
 * Registers a new visitor so that they can access the library. Visitors are assigned a unique, 10-digit ID by the LBMS.
 *
 * @author Henry Larson
 */
public class RegisterVisitorResponse extends LibraryResponse {
    private int visitorID;
    private Date registrationDate;

    public RegisterVisitorResponse(int visitorID, Date registrationDate) {
        this.visitorID = visitorID;
        this.registrationDate = registrationDate;
    }

    public int getVisitorID() {
        return visitorID;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    // TODO - create response format
    public String toString() {
        return "";
    }
}
