import java.io.*;
import java.net.*;

public class SoTimeoutExample {
    public static void main(String[] args) {
        try (Socket socket = new Socket("example.com", 80)) {

            // Get current timeout (default = 0 means infinite wait)
            int currentTimeout = socket.getSoTimeout();
            System.out.println("Current SO_TIMEOUT: " + currentTimeout + " ms");

            // Set timeout to 3 minutes (180000 ms)
            if (currentTimeout == 0) {
                socket.setSoTimeout(180000);
                System.out.println("SO_TIMEOUT set to 3 minutes.");
            }

            InputStream in = socket.getInputStream();

            try {
                int data = in.read(); // waits until data or timeout
                System.out.println("Data received: " + data);
            } catch (SocketTimeoutException e) {
                System.out.println("Read timed out! No data received within the timeout.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
