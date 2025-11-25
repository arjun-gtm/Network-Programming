import java.io.*;
import java.net.*;

public class SoLingerExample {
    public static void main(String[] args){
        try(Socket socket = new Socket("example.com"),80) {
            int lingerTime = socket.getSoLinger();
            System.out.println("Current SO_LINGER:" + lingerTime);

            if(lingerTime == -1){
                socket.setSoLinger(true,5);
            System.out.println("SO_LINGER enabled for 5 seconds" );
            }

            OutputStream out = socket.getOutputStream();
            out.write("Hello".getBytes());

            socket.close();
            System.out.println("socket closed");

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}