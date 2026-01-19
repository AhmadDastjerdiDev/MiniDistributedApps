package tcp_ping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TCPPingClient {
    public static void run(String[] args) throws IOException, InterruptedException {
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        int timeout = Integer.parseInt(args[2]);

        Socket socket = new Socket(host, port);
        socket.setSoTimeout(timeout);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        while (true) {
            out.println("PING");
            System.out.println("SENT: PING");

            try {
                String receivedMessage = in.readLine();
                System.out.println("RECEIVED: " + receivedMessage);
            } catch (SocketTimeoutException e) {
                System.out.println("Timeout: target failed");
                break;
            } finally {
                socket.close();
            }
            Thread.sleep(1000);
        }
        socket.close();
    }
}
