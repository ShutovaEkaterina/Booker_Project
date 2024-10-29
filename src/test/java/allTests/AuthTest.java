package allTests;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import authPackage.User;
import authPackage.UserRequest;
import authPackage.UserResponse;

public class AuthTest {
    String username = "admin";
    String password = "password123";
    private final UserRequest userRequest = new UserRequest();
    private final UserResponse userResponse = new UserResponse();

    @Test
    public void successAuthUserWithCorrectUsernameAndPasswordTest() {
        User user = new User(username, password);
        ValidatableResponse response = userRequest.authUser(user);
        userResponse.assertAuthWithCorrectUsernameAndPassword(response);
    }

    // The test failed because it returned a 200 status code
   @Test
   public void authUserWithIncorrectUsernameTest() {
        User user = new User("pasha", password);
        ValidatableResponse response = userRequest.authUser(user);
        userResponse.assertAuthWithIncorrectUsername(response);
    }

    // The test failed because it returned a 200 status code
    @Test
    public void authUserWithIncorrectPasswordTest() {
        User user = new User(username, "1234");
        ValidatableResponse response = userRequest.authUser(user);
        userResponse.assertAuthWithIncorrectPassword(response);
    }

    // The test failed because it returned a 200 status code
    @Test
    public void authUserWithIncorrectUsernameAndPasswordTest() {
        User user = new User("tamara", "123456");
        ValidatableResponse response = userRequest.authUser(user);
        userResponse.assertAuthWithIncorrectUsernameAndPassword(response);
    }

    // The test failed because it returned a 200 status code
    @Test
    public void authUserWithoutUsernameTest() {
        User user = new User("", "password123");
        ValidatableResponse response = userRequest.authUser(user);
        userResponse.assertAuthWithoutUsername(response);
    }

    // The test failed because it returned a 200 status code
    @Test
    public void authUserWithoutPasswordTest() {
        User user = new User("admin", "");
        ValidatableResponse response = userRequest.authUser(user);
        userResponse.assertAuthWithoutPassword(response);
    }

    // The test failed because it returned a 200 status code
    @Test
    public void authUserWithoutUsernameAndPasswordTest() {
        User user = new User();
        ValidatableResponse response = userRequest.authUser(user);
        userResponse.assertAuthWithoutUsernameAndPassword(response);
    }
}
