import java.net.URLConnection;

public class MimeTypeGuesser {
    public static void main (String[] args) {
        String filePath = "arjun.pdf";

        String mimeTypeGuesser = URLConnection.guessContentTypeFromName(filePath);
        System.out.println("MIME Type (By file name):" + mimeTypeGuesser);
    }
}