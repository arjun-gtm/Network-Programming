import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketStatusExample {
    public static void main(String[] args) {
        Socket socket = new Socket();
        System.out.println("Before connecting:");

        try {
            InetSocketAddress address = new InetSocketAddress("www.google.com", 80);

            socket.bind(new InetSocketAddress(0));
            System.out.println("\nAfter binding:");

            socket.connect(address);
            System.out.println("\nAfter connecting:");

            socket.close();
            System.out.println("\nAfter closing:");
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

