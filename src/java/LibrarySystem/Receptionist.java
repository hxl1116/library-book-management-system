package LibrarySystem;

import Requests.Book.BorrowBookRequest;
import Requests.Book.ReturnBookRequest;
import Requests.LibraryRequest;
import Requests.RequestType;
import Requests.System.PartialRequest;
import Responses.Book.BorrowBookResponse;
import Responses.Book.ReturnBookResponse;
import Responses.Library.CurrentTimeDateResponse;
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
    private static StringBuilder partials = new StringBuilder();

    /**
     * Opens the server socket.
     * LibraryRequest objects are deserialized and parsed.
     * LibraryResponse objects are serialized according to the request.
     *
     * @param port The socket port
     */
    public static void openDoors(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            LibraryRequest input;
            RequestType requestType;
            String visitorID;
            int[] ids;

            while (socket.isConnected()) {
                if ((input = (LibraryRequest) inputStream.readObject()) != null) {
                    requestType = RequestType.valueOf(input.getClass().getSimpleName());
                    switch (requestType) {
                        case AdvanceTimeRequest:
                            System.out.println("Advance request received");
                            System.out.println(input.toString());
                            outputStream.writeObject(input.execute());
                            break;
                        case BeginVisitRequest:
                            break;
                        case BookPurchaseRequest:
                            outputStream.writeObject(input.execute());
                            break;
                        case BookStoreSearchRequest:
                            break;
                        case BorrowBookRequest:
                            visitorID = ((BorrowBookRequest) input).getVisitorID();
                            ids = ((BorrowBookRequest) input).getIds();
                            String dueDate = Library.loan(visitorID, ids[0]);
                            outputStream.writeObject(new BorrowBookResponse(dueDate));
                            break;
                        case CurrentDateTimeRequest:
                            String[] currentDate = Library.getCurrentDate();
                            outputStream.writeObject(new CurrentTimeDateResponse(currentDate[0], currentDate[1]));
                            break;
                        case EndVisitRequest:
                            break;
                        case LibraryBookSearchRequest:
                            break;
                        case LibraryStatisticsReportRequest:
                            break;
                        case PartialRequest:
                            System.out.println("Partial request received");
                            partials.append(((PartialRequest) input).getPartial());
                            outputStream.writeObject(input.execute());
                            break;
                        case PayFineRequest:
                            break;
                        case QueryBorrowedBooksRequest:
                            break;
                        case RegisterVisitorRequest:
                            break;
                        case ReturnBookRequest:
                            visitorID = ((ReturnBookRequest) input).getVisitorID();
                            ids = ((ReturnBookRequest) input).getIds();
                            Library.returnBook(visitorID, ids[0]);
                            outputStream.writeObject(new ReturnBookResponse(0, 0));
                            break;
                        default:
                            partials = new StringBuilder();
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
