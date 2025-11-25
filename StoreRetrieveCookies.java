import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;

public class StoreRetrieveCookies {
    public static void main(String[] args) throws Exception {

        CookieManager customCookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(customCookieManager);

        URI uri = new URI("https://httpbin.org/cookies/set?username=ArjunGtm");
        URL url = uri.toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while(in.readLine() != null) {

        }
        in.close();

        //Retrieve stored cookies
        CookieStore cookieStore = customCookieManager.getCookieStore();
        List<HttpCookie> cookies = cookieStore.getCookies();
        System.out.println("Stored Cookies:");
        for (HttpCookie cookie : cookies) {
            System.out.println(cookie);
        }
    }
}
