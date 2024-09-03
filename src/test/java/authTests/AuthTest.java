package authTests;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import pomAuth.User;
import pomAuth.UserRequest;
import pomAuth.UserResponse;

public class AuthTest {
private final UserRequest userRequest = new UserRequest();
private final UserResponse userResponse = new UserResponse();
static String token;
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
    // Тест упадет, так как статус код = 200 ОК
    @Test
    public void authUserIncorrectPassword() {
        User user = User.random();
        user.setUsername("admin");
        ValidatableResponse authResponse = userRequest.authUserWithIncorrectPassword(user);
        userResponse.authSuccessWithIncorrectPassword(authResponse, user);
    }
    // Тест упадет, так как статус код = 200 ОК
    @Test
    public void authUserIncorrectUsernameAndPassword() {
        User user = User.random();
        ValidatableResponse authResponse = userRequest.authUserWithIncorrectUsernameAndPassword(user);
        userResponse.authSuccessWithIncorrectUsernameAndPassword(authResponse, user);
    }
    // Тест упадет, так как статус код = 200 ОК
    @Test
    public void authUserWithoutUsername() {
        User user = User.random();
        user.setUsername("");
        ValidatableResponse authResponse = userRequest.authUserWithoutUsername(user);
        userResponse.authSuccessWithoutUsername(authResponse, user);
    }
    // Тест упадет, так как статус код = 200 ОК
    @Test
    public void authUserWithoutPassword() {
        User user = User.random();
        user.setPassword("");
        ValidatableResponse authResponse = userRequest.authUserWithoutPassword(user);
        userResponse.authSuccessWithoutPassword(authResponse, user);
    }
    // Тест упадет, так как статус код = 200 ОК
    @Test
    public void authUserWithoutUsernameAndPassword() {
        User user = new User();
        user.setPassword("");
        user.setUsername("");
        ValidatableResponse authResponse = userRequest.authUserWithoutUsernameAndPassword(user);
        userResponse.authSuccessWithoutUsernameAndPassword(authResponse, user);
    }
}
