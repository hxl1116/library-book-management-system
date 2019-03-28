package LibrarySystem;

import Requests.Book.*;
import Requests.Library.AdvanceTimeRequest;
import Requests.Library.CurrentDateTimeRequest;
import Requests.Library.LibraryStatisticsReportRequest;
import Requests.System.PartialRequest;
import Requests.Visitor.BeginVisitRequest;
import Requests.Visitor.EndVisitRequest;
import Requests.Visitor.PayFineRequest;
import Requests.Visitor.RegisterVisitorRequest;
import Responses.Book.BorrowBookResponse;
import Responses.Book.ReturnBookResponse;
import Responses.LibraryResponse;
import Responses.ResponseType;
import Responses.System.PartialResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Client class that allows for interaction with the LBMS.
 *
 * @author Henry Larson
 */
public class LibClient {
    private static final String URL = "localhost";
    private static final int PORT = 8888;

    private static final Scanner key = new Scanner(System.in);

    /**
     * Opens socket for client and connects to server (Receptionist).
     * Waits for user input and parses it into LibraryRequest objects then waits for a LibraryResponse object.
     *
     * @param args Runtime arguments
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        try (Socket socket = new Socket(URL, PORT);
             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {
            String output;
            String command;
            String params;

            while (socket.isConnected()) {
                output = key.nextLine();

                if (output.contains(";")) {
                    command = output.substring(0, output.indexOf(","));
                    params = output.substring(output.indexOf(","), output.length() - 1);

                    switch (command) {
                        case "advance":
                            outputStream.writeObject(new AdvanceTimeRequest(params));
                            break;
                        case "arrive":
                            outputStream.writeObject(new BeginVisitRequest(params));
                            break;
                        case "buy":
//                            outputStream.writeObject(new BookPurchaseRequest(params));
                            break;
                        case "borrow":
                            outputStream.writeObject(new BorrowBookRequest(params));
                            break;
                        case "borrowed":
                            outputStream.writeObject(new BorrowBookRequest(params));
                            break;
                        case "datetime":
                            outputStream.writeObject(new CurrentDateTimeRequest());
                            break;
                        case "depart":
                            outputStream.writeObject(new EndVisitRequest(params));
                            break;
                        case "info":
//                            outputStream.writeObject(new LibraryBookSearchRequest(params));
                            break;
                        case "pay":
//                            outputStream.writeObject(new PayFineRequest(params));
                            break;
                        case "register":
//                            outputStream.writeObject(new RegisterVisitorRequest(params));
                            break;
                        case "report":
//                            outputStream.writeObject(new LibraryStatisticsReportRequest(params));
                            break;
                        case "return":
                            outputStream.writeObject(new ReturnBookRequest(params));
                            break;
                        case "search":
//                            outputStream.writeObject(new QueryBorrowedBooksRequest(params));
                            break;
                        case "logout":
                            outputStream.writeObject(new PartialRequest(command));
                            break;
                        default:
                            invalidRequest(output);
                            break;
                    }
                } else {
                    outputStream.writeObject(new PartialRequest(output));
                }

                receiveResponse(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints an invalid request error message
     *
     * @param request User request input
     */
    private static void invalidRequest(String request) {
        System.out.printf("Invalid Request: %s\n", request);
    }

    /**
     * Prints invalid parameter(s) error message
     *
     * @param paramsArray User request parameters
     */
    private static void invalidParams(String[] paramsArray) {
        StringBuilder params = new StringBuilder();
        for (String param : paramsArray) {
            params.append(param).append(",");
        }
        System.out.printf("Invalid Params: %s\n", params.toString().substring(0, params.toString().length() - 1));
    }

    /**
     * Receives and parses LibraryResponse objects from the server (Receptionist)
     *
     * @param inputStream Client socket object input stream
     */
    private static void receiveResponse(ObjectInputStream inputStream) {
        try {
            LibraryResponse input;
            if ((input = (LibraryResponse) inputStream.readObject()) != null) System.out.println(input.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
