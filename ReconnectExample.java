import java.net.*;

public class ReconnectExample {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("www.yahoo.com",80);

            SocketAddress yahooAddress = socket.getRemoteSocketAddress();
            System.out.println("Connected to:" + yahooAddress);

            socket.close();

            Socket socket2 = new Socket();
            socket2.connect(yahooAddress);

            System.out.println("Recsonnected to:" + yahooAddress);

            socket2.close();

        } catch(Exception e) {
            System.err.println("Error:" + e.getMessage());
        }
    }
}