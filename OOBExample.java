import java.io.*;
import java.net.*;

public class OOBExample {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("example.com", 80);

            socket.setOOBInline(true);
            System.out.println("OOBINLINE Enabled");

            socket.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
