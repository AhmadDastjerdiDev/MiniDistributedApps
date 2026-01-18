import tcp.TCPMiniClient;
import tcp.TCPMiniServer;
import udp.UDPMiniClient;
import udp.UDPMiniServer;

void main(String[] args) throws Exception {

    if (args.length < 1) {
        System.out.println("Usage:");
        System.out.println("  java Main TCP_Server <port>");
        System.out.println("  java Main TCP_Client <host> <port>");
        System.out.println("  java Main UDP_Server <port>");
        System.out.println("  java Main UDP_Client <address> <port> <message>");
        return;
    }

    switch (args[0]) {
        case "TCP_Server" -> TCPMiniServer.run(new String[]{args[1]});
        case "TCP_Client" -> TCPMiniClient.run(new String[]{args[1], args[2]});
        case "UDP_Server" -> UDPMiniServer.run(new String[]{args[1]});
        case "UDP_Client" -> UDPMiniClient.run(new String[]{args[1], args[2], args[3]});
        default -> System.out.println("Unknown mode: " + args[0]);
    }
}
