package tcp;

import java.io.*;
import java.net.Socket;


public class TCPMiniClient {
    public static void run(String[] args) throws IOException {
        String host = args[0];
        int port = Integer.parseInt(args[1]);

        Socket socket = new Socket(host, port);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String syn = "HELLO";
        out.println(syn);
        System.out.println("Client Sent Message: " + syn);

        String serverReply = in.readLine();
        System.out.println("Client Received: " + serverReply);

        socket.close();
    }
}
