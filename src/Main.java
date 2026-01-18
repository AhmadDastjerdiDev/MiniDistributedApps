import tcp.TCPMiniClient;
import tcp.TCPMiniServer;

void main(String[] args) throws Exception {

    if (args.length < 1) {
        System.out.println("Usage:");
        System.out.println("  java Main server <port>");
        System.out.println("  java Main client <host> <port>");
        return;
    }

    if (args[0].equals("server")) {
        TCPMiniServer.run(new String[]{args[1]});

    } else if (args[0].equals("client")) {
        TCPMiniClient.run(new String[]{args[1], args[2]});

    } else {
        System.out.println("Unknown mode: " + args[0]);
    }
}
