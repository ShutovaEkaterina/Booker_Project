package pomAuth;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;

public class UserResponse {
    // todo проверить неиспозьзуемые параметры и методы
    public void authSuccess(ValidatableResponse authResponse, User user) {
        authResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("token", notNullValue());
    }
    public void authSuccessWithIncorrectUsername(ValidatableResponse authResponse, User user) {
        String reason = authResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("Bad credentials", reason);
    }
    public void authSuccessWithIncorrectPassword(ValidatableResponse authResponse, User user) {
        String reason = authResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("Bad credentials", reason);
    }
    public void authSuccessWithIncorrectUsernameAndPassword(ValidatableResponse authResponse, User user) {
        String reason = authResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("Bad credentials", reason);
    }
    public void authSuccessWithoutUsername(ValidatableResponse authResponse, User user) {
        String reason = authResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("Bad credentials", reason);
    }
    public void authSuccessWithoutPassword(ValidatableResponse authResponse, User user) {
        String reason = authResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("Bad credentials", reason);
    }
    public void authSuccessWithoutUsernameAndPassword(ValidatableResponse authResponse, User user) {
        String reason = authResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("Bad credentials", reason);
    }

    public String extractToken(ValidatableResponse response) {
        return response.extract().jsonPath().getString("token");
    }
}
