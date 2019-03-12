package LibrarySystem;

import Requests.LibraryRequest;
import Requests.RequestType;

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

            while (socket.isConnected()) {
                if ((input = (LibraryRequest) inputStream.readObject()) != null) {
                    requestType = RequestType.valueOf(input.getClass().getSimpleName());
                    if (requestType == RequestType.PartialRequest) partials.append(input.toString());
                    else processRequest(input, outputStream);
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
