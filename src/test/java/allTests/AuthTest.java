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

//todo убрать получение токена
    @Test
    public void testSuccessAuthUserWithCorrectUsernameAndPassword() {
        User user = new User(username, password);
        ValidatableResponse response = userRequest.authUser(user);
        userResponse.assertAuthWithCorrectUsernameAndPassword(response);
    }

    // The test failed because it returned a 200 status code
   @Test
   public void testAuthUserWithIncorrectUsername() {
        User user = new User("pasha", password);
        ValidatableResponse response = userRequest.authUser(user);
        userResponse.assertAuthWithIncorrectUsername(response);
    }

    // The test failed because it returned a 200 status code
    @Test
    public void testAuthUserWithIncorrectPassword() {
        User user = new User(username, "1234");
        ValidatableResponse response = userRequest.authUser(user);
        userResponse.assertAuthWithIncorrectPassword(response);
    }

    // The test failed because it returned a 200 status code
    @Test
    public void testAuthUserWithIncorrectUsernameAndPassword() {
        User user = new User("tamara", "123456");
        ValidatableResponse response = userRequest.authUser(user);
        userResponse.assertAuthWithIncorrectUsernameAndPassword(response);
    }

    // The test failed because it returned a 200 status code
    @Test
    public void testAuthUserWithoutUsername() {
        User user = new User("", "password123");
        ValidatableResponse response = userRequest.authUser(user);
        userResponse.assertAuthWithoutUsername(response);
    }

    // The test failed because it returned a 200 status code
    @Test
    public void testAuthUserWithoutPassword() {
        User user = new User("admin", "");
        ValidatableResponse response = userRequest.authUser(user);
        userResponse.assertAuthWithoutPassword(response);
    }

    // The test failed because it returned a 200 status code
    @Test
    public void testAuthUserWithoutUsernameAndPassword() {
        // todo переделать на нужный конструктор
        // todo убрать рандом
        User user = new User();
        ValidatableResponse response = userRequest.authUser(user);
        userResponse.assertAuthWithoutUsernameAndPassword(response);
    }
}
