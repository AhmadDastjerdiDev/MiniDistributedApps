package udp;

import java.io.IOException;
import java.net.*;

public class UDPMiniClient {
    public static void run(String[] args) throws IOException {
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        String clientMessage = args[2];

        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName(host);

        byte[] buffer = clientMessage.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
        socket.send(packet);
        System.out.println("Sent: " + clientMessage);

        DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
        socket.receive(response);
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received: " + received);

        socket.close();
    }
}
