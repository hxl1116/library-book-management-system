package LibrarySystem;

import Requests.LibraryRequest;
import Requests.RequestType;
import Responses.LibraryResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Stack;

/**
 * Server for the LBMS.
 * Sends and receives LibraryResponse and LibraryRequest objects, respectively.
 *
 * @author Henry Larson
 */
public class Receptionist {
    private static final Stack<LibraryRequest> requestHistory = new Stack<>();
    private static LibraryRequest previousRequest;
    private static LibraryRequest undoneRequest;
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

            while (socket.isConnected()) {
                if ((input = (LibraryRequest) inputStream.readObject()) != null) {
                    requestType = RequestType.valueOf(input.getClass().getSimpleName());
                    if (requestType == RequestType.UndoRequest && !requestHistory.empty())
                        undoRequest();
                    else if (requestType == RequestType.RedoRequest && undoneRequest != null)
                        outputStream.writeObject(redoRequest());
                    else if (requestType == RequestType.PartialRequest)
                        partials.append(input.toString());
                    else
                        outputStream.writeObject(processRequest(input));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static LibraryResponse processRequest(LibraryRequest request) throws IOException {
        requestHistory.push(request);
        return request.execute();
    }

    private static void undoRequest() {
        previousRequest = requestHistory.peek();
        undoneRequest = requestHistory.pop();
        previousRequest.undo();
    }

    private static LibraryResponse redoRequest() throws IOException {
        requestHistory.push(undoneRequest);
        return processRequest(undoneRequest);
    }
}
