package LibrarySystem;

import Requests.LibraryRequest;
import Requests.RequestType;

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
                    if (requestType == RequestType.UndoRequest && !requestHistory.empty()) {
                        previousRequest = requestHistory.peek();
                        undoneRequest = requestHistory.pop();
                        // TODO - Execute opposite of previous request
                    } else if (requestType == RequestType.RedoRequest && undoneRequest != null) {
                        processRequest(undoneRequest, outputStream);
                        requestHistory.push(undoneRequest);
                    } else if (requestType == RequestType.PartialRequest) partials.append(input.toString());
                    else {
                        processRequest(input, outputStream);
                        requestHistory.push(input);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processRequest(LibraryRequest request, ObjectOutputStream outputStream) throws IOException {
        System.out.println(request.toString());
        outputStream.writeObject(request.execute());
    }
}
