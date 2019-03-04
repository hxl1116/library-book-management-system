package LibrarySystem;

import Requests.LibraryRequest;
import Requests.RequestType;
import Requests.System.PartialRequest;
import Responses.System.PartialResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server for the LBMS.
 * Sends and receives LibraryResponse and LibraryRequest objects, respectively.
 *
 * @author Henry Larson
 */
public class Receptionist {
    private StringBuilder partials = new StringBuilder();

    /**
     * Opens the server socket.
     * LibraryRequest objects are deserialized and parsed.
     * LibraryResponse objects are serialized according to the request.
     *
     * @param port The socket port
     */
    public void openDoors(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            LibraryRequest input;
            RequestType requestType;
            while (socket.isConnected()) {
                if ((input = (LibraryRequest) inputStream.readObject()) != null) {
                    requestType = RequestType.valueOf(input.getClass().getSimpleName());
                    switch (requestType) {
                        case AdvanceTimeRequest:
                            break;
                        case BeginVisitRequest:
                            break;
                        case BookPurchaseRequest:
                            break;
                        case BookStoreSearchRequest:
                            break;
                        case BorrowBookRequest:
                            break;
                        case CurrentDateTimeRequest:
                            break;
                        case EndVisitRequest:
                            break;
                        case LibraryBookSearchRequest:
                            break;
                        case LibraryStatisticsReportRequest:
                            break;
                        case PartialRequest:
                            partials.append(((PartialRequest) input).getPartial());
                            outputStream.writeObject(new PartialResponse(partials.toString()));
                            break;
                        case PayFineRequest:
                            break;
                        case QueryBorrowedBooksRequest:
                            break;
                        case RegisterVisitorRequest:
                            break;
                        case ReturnBookRequest:
                            break;
                        default:
                            partials = new StringBuilder();
                            break;
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
