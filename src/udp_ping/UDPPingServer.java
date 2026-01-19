package udp_ping;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPPingServer {
    public static void run(String[] args) throws IOException {
        int port = Integer.parseInt(args[0]);
        DatagramSocket socket = new DatagramSocket(port);
        System.out.println("Server is listening on the port " + port);

        byte[] buffer = new byte[1024];

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String receivedMsg = new String(packet.getData(), 0, packet.getLength());
            if (receivedMsg.equals("exit")) {
                System.out.println("Server is shutting down");
                break;
            }

            if (receivedMsg.equals("PING")) {
                System.out.println("RECEIVED: PING");

                DatagramPacket reply = new DatagramPacket("ACK".getBytes(), "ACK".length(), packet.getAddress(), packet.getPort());
                socket.send(reply);
                System.out.println("SENT: ACK");
            }
        }
    }
}
