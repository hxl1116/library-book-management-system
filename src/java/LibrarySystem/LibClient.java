package LibrarySystem;

import Requests.Book.BookPurchaseRequest;
import Requests.Book.BorrowBookRequest;
import Requests.Book.QueryBorrowedBooksRequest;
import Requests.Book.ReturnBookRequest;
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
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())
        ) {
            String output;
            String command;
            String[] params;

            while (socket.isConnected()) {
                output = key.nextLine();

                if (output.contains(";")) {
                    command = output.substring(0, output.indexOf(","));
                    output = output.substring(0, output.length() - 1);

                    if (output.contains(",")) {
                        params = output.substring(output.indexOf(",") + 1).split(",");

                        switch (command) {
                            case "advance":
                                if (params.length == 2) outputStream.writeObject(new AdvanceTimeRequest(
                                        Integer.parseInt(params[0]), Integer.parseInt(params[1])
                                ));
                                else if (params.length == 1)
                                    outputStream.writeObject(new AdvanceTimeRequest(
                                            Integer.parseInt(params[0])
                                    ));
                                else invalidParams(params);
                                break;
                            case "arrive":
                                if (params.length == 1) {
                                    outputStream.writeObject(new BeginVisitRequest(
                                            Integer.parseInt(params[0])
                                    ));
                                } else invalidParams(params);
                                break;
                            case "buy":
                                if (params.length > 1) {
                                    int quantity = Integer.parseInt(params[0]);
                                    int[] ids = new int[params.length - 1];
                                    for (int i = 0; i < ids.length; i++) {
                                        ids[i] = Integer.parseInt(params[i + 1]);
                                    }

                                    outputStream.writeObject(new BookPurchaseRequest(quantity, ids));
                                } else invalidParams(params);
                                break;
                            case "search":

                                break;
                            case "borrow":
                                if (params.length > 1) {
                                    String visitorID = params[0];
                                    int[] ids = new int[params.length - 1];
                                    for (int i = 0; i < ids.length; i++) {
                                        ids[i] = Integer.parseInt(params[i + 1]);
                                    }
                                    outputStream.writeObject(new BorrowBookRequest(visitorID, ids));
                                } else invalidParams(params);
                                break;
                            case "depart":
                                if (params.length == 1) outputStream.writeObject(new EndVisitRequest(
                                        Integer.parseInt(params[0])
                                ));
                                else invalidParams(params);
                                break;
                            case "info":
                                break;
                            case "report":
                                if (params.length == 1) outputStream.writeObject(
                                        new LibraryStatisticsReportRequest(Integer.parseInt(params[0]))
                                );

                                // TODO - check for no days listed
                                break;
                            case "pay":
                                if (params.length == 2) outputStream.writeObject(new PayFineRequest(
                                        Integer.parseInt(params[0]), Double.parseDouble(params[1]))
                                );
                                break;
                            case "borrowed":
                                if (params.length == 1) outputStream.writeObject(new QueryBorrowedBooksRequest(
                                        Integer.parseInt(params[0]))
                                );
                                break;
                            case "register":
                                if (params.length == 4) outputStream.writeObject(new RegisterVisitorRequest(
                                        params[0], params[1], params[2], params[3])
                                );
                                break;
                            case "return":
                                if (params.length > 1) {
                                    int[] ids = new int[params.length - 1];
                                    for (int i = 1; i < ids.length; i++) {
                                        ids[i] = Integer.parseInt(params[i + 1]);
                                    }
                                    outputStream.writeObject(new ReturnBookRequest(params[0], ids));
                                } else invalidParams(params);
                                break;
                            case "logout":
                                outputStream.writeObject(new PartialRequest(command));
                                break;
                            default:
                                invalidRequest(output);
                                break;
                        }
                    } else {
                        switch (command) {
                            case "datetime":
                                outputStream.writeObject(new CurrentDateTimeRequest());
                                break;
                            case "logout":
                                outputStream.writeObject(new PartialRequest(command));
                                break;
                            default:
                                invalidRequest(output);
                                break;
                        }
                    }
                } else {
                    outputStream.writeObject(new PartialRequest(output));
                }

                receiveResponse(inputStream);
            }
        } catch (IOException | ClassNotFoundException e) {
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
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static void receiveResponse(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        LibraryResponse input;
        if ((input = (LibraryResponse) inputStream.readObject()) != null) System.out.println(input.toString());
    }
}
