import java.net.*;
import java.io.*;

public class HttpResponseExample {
    public static void main(String[] args) {
        try{
            URI uri = new URI("http://www.example.com");
            URL url = uri.toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            String responseMessage = connection.getResponseMessage();

            System.out.println("Response Code:" + responseCode);
            System.out.println("Response Message:" + responseMessage);

            connection.disconnect();
        }
        catch (URISyntaxException e) {
            System.err.println("Invalid URI:" + e.getMessage());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}