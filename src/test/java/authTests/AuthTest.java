package authTests;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import pomAuth.User;
import pomAuth.UserRequest;
import pomAuth.UserResponse;

public class AuthTest {
private final UserRequest userRequest = new UserRequest();
private final UserResponse userResponse = new UserResponse();
static User user;
static String token;
public String getToken() {
    return token;
    }
    @Test
    public void authUser() {
    String username = "admin";
    String password = "password123";
    User user = new User(username, password);
        ValidatableResponse authResponse = userRequest.authUser(user);
        userResponse.authSuccess(authResponse, user);
        token = userResponse.extractToken(authResponse);
    }

    // Тест упадет, так как статус код = 200 ОК
   @Test
   public void authUserIncorrectUsername() {
       User user = User.random();
        user.setPassword("password123");
        ValidatableResponse authResponse = userRequest.authUserWithIncorrectUsername(user);
        userResponse.authSuccessWithIncorrectUsername(authResponse, user);
    }
}
