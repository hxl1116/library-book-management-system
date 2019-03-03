package Requests.Visitor;

import Requests.LibraryRequest;

/**
 * Registers a new visitor so that they can access the library. Visitors are assigned a unique, 10-digit ID by the LBMS.
 *
 * @author Henry Larson
 */
public class RegisterVisitorRequest extends LibraryRequest {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    public RegisterVisitorRequest(String firstName, String lastName, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
