package LibrarySystem;

import Requests.LibraryRequest;
import Requests.RequestType;
import Requests.System.PartialRequest;
import Requests.Visitor.BeginVisitRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receptionist {
    public void openDoors(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            LibraryRequest input;
            RequestType requestType;
            while (socket.isConnected()) {
                if ((input = (LibraryRequest) inputStream.readObject()) != null) {
                    requestType = RequestType.valueOf(input.getClass().getSimpleName());
                    switch (requestType) {
                        case BeginVisitRequest:
                            System.out.println(((BeginVisitRequest) input).getVisitorID());
                            break;
                        case PartialRequest:
                            System.out.println(((PartialRequest) input).getPartial());
                            break;
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
