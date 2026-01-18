package tcp_ping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPPingServer{
    public static void run(String[] args)  throws IOException {
        int port = Integer.parseInt(args[0]);
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is Listening on the port " + port);
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String clientMessage;
        while((clientMessage = in.readLine())!=null){
            System.out.println("RECEIVED: " + clientMessage);
            if(clientMessage.equals("PING")){
                String ack = "ACK";
                out.println(ack);
                System.out.println("SENT: " + ack);
            }
        }
        socket.close();
        serverSocket.close();
    }
}
