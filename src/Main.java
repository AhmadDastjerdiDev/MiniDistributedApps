import tcp.TCPMiniClient;
import tcp.TCPMiniServer;
import tcp_ping.TCPPingClient;
import tcp_ping.TCPPingServer;
import udp.UDPMiniClient;
import udp.UDPMiniServer;

void main(String[] args) throws Exception {

    if (args.length < 1) {
        System.out.println("Usage:");
        System.out.println("  java Main TCP_Server <port>");
        System.out.println("  java Main TCP_Client <host> <port>");
        System.out.println("  java Main UDP_Server <port>");
        System.out.println("  java Main UDP_Client <address> <port> <message>");
        System.out.println("  java Main TCP_Ping_Server <port>");
        System.out.println("  java Main TCP_Ping_Client <host> <port> <timeout>");
        return;
    }

    switch (args[0]) {
        case "TCP_Server" -> TCPMiniServer.run(new String[]{args[1]});
        case "TCP_Client" -> TCPMiniClient.run(new String[]{args[1], args[2]});
        case "UDP_Server" -> UDPMiniServer.run(new String[]{args[1]});
        case "UDP_Client" -> UDPMiniClient.run(new String[]{args[1], args[2], args[3]});
        case "TCP_Ping_Server" -> TCPPingServer.run(new String[]{args[1]});
        case "TCP_Ping_Client" -> TCPPingClient.run(new String[]{args[1], args[2], args[3]});
        default -> System.out.println("Unknown mode: " + args[0]);
    }
}
