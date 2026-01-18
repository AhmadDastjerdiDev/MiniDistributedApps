package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPMiniServer {
    public static void run(String[] args) throws IOException {
        int port = Integer.parseInt(args[0]);
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.format("Server is listening on the port %d\n", port);
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String clientMessage = in.readLine();
        while (clientMessage != null) {
            System.out.println("Server Received Message: " + clientMessage);
            if (clientMessage.equals("HELLO")) {
                out.println("OK");
                System.out.println("Server Sent Message: OK");
            }
        }

        socket.close();
        serverSocket.close();
    }
}
