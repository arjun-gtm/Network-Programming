import java.net.*;
import java.util.Date;

public class RetrieveHeaderFields {
    public static void main(String[] args) throws Exception {

        URI uri = new URI("https://www.example.com");
        URL url = uri.toURL();
        URLConnection connection = url.openConnection();

        System.out.println("Content Type:" + connection.getContentType());
        System.out.println("Content Length:" + connection.getContentLength());
        System.out.println("Content Encoding:" + connection.getContentEncoding());
        System.out.println("Content Date:" + connection.getDate());
        System.out.println("Date:" + new Date(connection.getDate()));
        System.out.println("Expiration:" + connection.getExpiration());
        System.out.println("Last Modified:" + connection.getLastModified());

    }
}