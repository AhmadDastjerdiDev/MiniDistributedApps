package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPMiniServer {
    public static void run(String[] args) throws IOException {
        boolean running = true;
        int port = Integer.parseInt(args[0]);
        byte[] buffer = new byte[1024];
        DatagramSocket socket = new DatagramSocket(port);
        System.out.println("UDP Server is listening on port " + port);

        while(running) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String receivedMsg = new String(packet.getData(),0, packet.getLength());
            if(receivedMsg.equals("exit")){
                System.out.print("Server is shutting down!");
                break;
            }
            System.out.println("Received from " + packet.getAddress() + ":" + packet.getPort() + "->" + receivedMsg);
            socket.send(packet);
            System.out.println("Sent: " + receivedMsg);
        }
        socket.close();
    }
}
