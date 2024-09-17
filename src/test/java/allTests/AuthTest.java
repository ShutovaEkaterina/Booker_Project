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
    public void authUser() {
        User user = new User(username, password);
        ValidatableResponse authResponse = userRequest.authUser(user);
        userResponse.authSuccess(authResponse);
    }

    // Тест упадет, так как статус код = 200 ОК
   @Test
   public void authUserIncorrectUsername() {
        User user = new User("pasha", password);
        ValidatableResponse authResponse = userRequest.authUser(user);
        userResponse.authSuccessWithIncorrectUsername(authResponse);
    }

    // Тест упадет, так как статус код = 200 ОК
    @Test
    public void authUserIncorrectPassword() {
        User user = new User(username, "1234");
        ValidatableResponse authResponse = userRequest.authUser(user);
        userResponse.authSuccessWithIncorrectPassword(authResponse);
    }

    // Тест упадет, так как статус код = 200 ОК
    @Test
    public void authUserIncorrectUsernameAndPassword() {
        User user = new User("tamara", "123456");
        ValidatableResponse authResponse = userRequest.authUser(user);
        userResponse.authSuccessWithIncorrectUsernameAndPassword(authResponse);
    }

    // Тест упадет, так как статус код = 200 ОК
    @Test
    public void authUserWithoutUsername() {
        User user = new User("", "password123");
        ValidatableResponse authResponse = userRequest.authUser(user);
        userResponse.authSuccessWithoutUsername(authResponse);
    }

    // Тест упадет, так как статус код = 200 ОК
    @Test
    public void authUserWithoutPassword() {
        User user = new User("admin", "");
        ValidatableResponse authResponse = userRequest.authUser(user);
        userResponse.authSuccessWithoutPassword(authResponse);
    }

    // Тест упадет, так как статус код = 200 ОК
    @Test
    public void authUserWithoutUsernameAndPassword() {
        // todo переделать на нужный конструктор
        // todo убрать рандом
        User user = new User();
        ValidatableResponse authResponse = userRequest.authUser(user);
        userResponse.authSuccessWithoutUsernameAndPassword(authResponse);
    }
}
