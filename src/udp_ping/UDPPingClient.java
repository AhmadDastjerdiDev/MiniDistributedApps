package udp_ping;

import java.net.*;
import java.io.IOException;

public class UDPPingClient {
    public static void run(String[] args) throws IOException, InterruptedException {
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        int timeout = Integer.parseInt(args[2]);

        DatagramSocket socket = new DatagramSocket();
        socket.setSoTimeout(timeout);
        InetAddress address = InetAddress.getByName(host);

        while (true) {
            byte[] sendBuf = "PING".getBytes();
            DatagramPacket pingPacket = new DatagramPacket(sendBuf, sendBuf.length, address, port);
            socket.send(pingPacket);
            System.out.println("SENT: PING");

            byte[] recvBuf = new byte[1024];
            DatagramPacket reply = new DatagramPacket(recvBuf, recvBuf.length);

            try {
                socket.receive(reply);
                String receivedMsg = new String(reply.getData(), 0, reply.getLength());
                System.out.println("RECEIVED: " + receivedMsg);
            } catch (SocketTimeoutException e) {
                System.out.println("TIMEOUT: target failed");
            } finally {
                socket.close();
            }
            Thread.sleep(1000);
        }
    }
}
