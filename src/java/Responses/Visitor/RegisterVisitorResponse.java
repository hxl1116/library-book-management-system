package Responses.Visitor;

import LibrarySystem.Library;
import Responses.LibraryResponse;

import java.util.Date;

/**
 * Registers a new visitor so that they can access the library. Visitors are assigned a unique, 10-digit ID by the LBMS.
 *
 * @author Henry Larson
 */
public class RegisterVisitorResponse extends LibraryResponse {
    private String visitorID;
    private Date registrationDate;

    public RegisterVisitorResponse(String visitorID, Date registrationDate) {
        this.visitorID = visitorID;
        this.registrationDate = registrationDate;
    }

    public String toString() {
        return String.format("register,%s,%s", visitorID, Library.DATE_FORMAT.format(registrationDate));
    }
}
