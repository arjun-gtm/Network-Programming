import java.net.*;

public class ProxyExample {
    public static void main(String[] args){
        try {
            SocketAddress proxyAddress = new InetSocketAddress("myproxy.example.com",1080);
            Proxy proxy = new Proxy(Proxy.Type.SOCKS, proxyAddress);

            Socket socket = new Socket(proxy);
            SocketAddress remoteAddress = new InetSocketAddress("login.ibiblio.org",25);
            socket.connect(remoteAddress);

            System.out.println("Connected via proxy!");
            socket.close();
        } catch (Exception e) {
            System.err.println("Connection failed:" + e.getMessage());
        }
    }
}