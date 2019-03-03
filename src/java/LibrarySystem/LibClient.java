package LibrarySystem;

import Requests.System.PartialRequest;
import Requests.Visitor.BeginVisitRequest;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class LibClient {
    private static final String url = "http://localhost.com";
    private static final String charset = "UTF-8";

    private static final Scanner key = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);

            String output;
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            while (socket.isConnected()) {
                output = key.nextLine();
                switch (output) {
                    case "arrive":
                        outputStream.writeObject(new BeginVisitRequest(1234));
                        break;
                    default:
                        outputStream.writeObject(new PartialRequest(output));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
