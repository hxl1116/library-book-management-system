package Requests.Visitor;

import Requests.LibraryRequest;
import Responses.LibraryResponse;
import Responses.Visitor.RegisterVisitorResponse;

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

    public RegisterVisitorRequest(String parameters) {
        String[] params = parameters.split(",");
        firstName = params[0];
        lastName = params[1];
        address = params[2];
        phoneNumber = params[3];
    }

    @Override
    // TODO - Create method call for response data
    public LibraryResponse execute() {
        return new RegisterVisitorResponse("", null);
    }

    @Override
    // TODO - Create method call for undoing request (not undoable)
    public LibraryRequest undo() {
        return null;
    }
}
