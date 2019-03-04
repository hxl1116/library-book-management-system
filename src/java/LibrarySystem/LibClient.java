package LibrarySystem;

import Requests.Book.QueryBorrowedBooksRequest;
import Requests.Library.AdvanceTimeRequest;
import Requests.Library.CurrentDateTimeRequest;
import Requests.Library.LibraryStatisticsReportRequest;
import Requests.System.PartialRequest;
import Requests.Visitor.BeginVisitRequest;
import Requests.Visitor.EndVisitRequest;
import Requests.Visitor.PayFineRequest;
import Requests.Visitor.RegisterVisitorRequest;
import Responses.LibraryResponse;
import Responses.ResponseType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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
    public static void main(String[] args) {
        try (Socket socket = new Socket(URL, PORT);
             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {
            String output;
            String command;
            String[] params;
            while (socket.isConnected()) {
                output = key.nextLine();
                if (output.contains(";")) {
                    if (output.contains(",")) {
                        command = output.substring(0, output.indexOf(","));
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
                                else System.out.println(invalidParams(params));
                                break;
                            case "arrive":
                                if (params.length == 1) {
                                    outputStream.writeObject(new BeginVisitRequest(
                                            Integer.parseInt(params[0])
                                    ));
                                } else System.out.println(invalidParams(params));
                                break;
                            case "buy":
                                break;
                            case "search":
                                break;
                            case "borrow":
                                break;
                            case "depart":
                                if (params.length == 1) outputStream.writeObject(new EndVisitRequest(
                                        Integer.parseInt(params[0])
                                ));
                                else System.out.println(invalidParams(params));
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
                                break;
                            case "logout":
                                outputStream.writeObject(new PartialRequest(command));
                                break;
                            default:
                                System.out.println(invalidRequest(output));
                                break;
                        }
                    } else {
                        command = output;

                        switch (command) {
                            case "datetime":
                                outputStream.writeObject(new CurrentDateTimeRequest());
                                break;
                            case "logout":
                                break;
                            default:
                                System.out.println(invalidRequest(output));
                                break;
                        }
                    }
                } else {
                    outputStream.writeObject(new PartialRequest(output));
                    receiveResponse(inputStream);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns an invalid request error message
     *
     * @param request User request input
     * @return invalid request error message
     */
    private static String invalidRequest(String request) {
        return String.format("%c[31mInvalid Request: %s%c[0m", 27, request, 27);
    }

    /**
     * Returns invalid parameter(s) error message
     *
     * @param paramsArray User request parameters
     * @return invalid parameters error message
     */
    private static String invalidParams(String[] paramsArray) {
        StringBuilder params = new StringBuilder();
        for (String param : paramsArray) {
            params.append(param).append(",");
        }
        return String.format("%c[31mInvalid Params: %s%c[0m",
                27,
                params.toString().substring(0, params.toString().length() - 1),
                27);
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
        ResponseType responseType;

        if ((input = (LibraryResponse) inputStream.readObject()) != null) {
            responseType = ResponseType.valueOf(input.getClass().getSimpleName());

            System.out.println("Inside receiving if statement.");
            switch (responseType) {
                case AdvanceTimeResponse:
                    break;
                case BeginVisitResponse:
                    break;
                case BookPurchaseResponse:
                    break;
                case BookStoreSearchResponse:
                    break;
                case BorrowBookResponse:
                    break;
                case CurrentDateTimeResponse:
                    break;
                case EndVisitResponse:
                    break;
                case LibraryBookSearchResponse:
                    break;
                case LibraryStatisticsReportResponse:
                    break;
                case PartialResponse:
                    break;
                case PayFineResponse:
                    break;
                case QueryBorrowedBooksResponse:
                    break;
                case RegisterVisitorResponse:
                    break;
                case ReturnBookResponse:
                    break;
                default:
                    break;
            }
        }
    }
}
