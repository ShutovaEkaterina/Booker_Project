package authPackage;

import configPackage.Config;
import io.restassured.response.ValidatableResponse;

public class UserRequest extends Config {
    private static final String USER_PATH = "/auth";
    public ValidatableResponse authUser(User user) {
        return spec()
                .body(user)
                .when()
                .post(USER_PATH)
                .then().log().all();
    }
}
