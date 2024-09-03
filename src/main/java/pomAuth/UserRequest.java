package pomAuth;

import basicStaff.Basic;
import io.restassured.response.ValidatableResponse;

public class UserRequest extends Basic {
    private static final String USER_PATH = "/auth";
public ValidatableResponse authUser(User user) {
    return spec()
            .body(user)
            .when()
            .post(USER_PATH)
            .then().log().all();
}
    public ValidatableResponse authUserWithIncorrectUsername(User user) {
        return spec()
                .body(user)
                .when()
                .post(USER_PATH)
                .then().log().all();
    }
    public ValidatableResponse authUserWithIncorrectPassword(User user) {
        return spec()
                .body(user)
                .when()
                .post(USER_PATH)
                .then().log().all();
    }
    public ValidatableResponse authUserWithIncorrectUsernameAndPassword(User user) {
        return spec()
                .body(user)
                .when()
                .post(USER_PATH)
                .then().log().all();
    }
    public ValidatableResponse authUserWithoutUsername(User user) {
        return spec()
                .body(user)
                .when()
                .post(USER_PATH)
                .then().log().all();
    }
    public ValidatableResponse authUserWithoutPassword(User user) {
        return spec()
                .body(user)
                .when()
                .post(USER_PATH)
                .then().log().all();
    }
    public ValidatableResponse authUserWithoutUsernameAndPassword(User user) {
        return spec()
                .body(user)
                .when()
                .post(USER_PATH)
                .then().log().all();
    }
}
