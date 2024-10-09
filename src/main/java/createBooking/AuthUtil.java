package createBooking;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AuthUtil {
    public static String createBasicAuthorization(String username, String password) {
        String auth = username + ":" + password;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        return "Basic " + encodedAuth;
    }
}
