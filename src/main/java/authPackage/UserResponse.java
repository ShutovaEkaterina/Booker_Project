package authPackage;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserResponse {
    // todo проверить неиспозьзуемые параметры и методы
    public String assertAuthWithCorrectUsernameAndPassword(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("token", notNullValue());
        return response.extract().jsonPath().getString("token");
    }

    public void assertAuthWithIncorrectUsername(ValidatableResponse response) {
        String reason = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("Bad credentials", reason);
    }

    public void assertAuthWithIncorrectPassword(ValidatableResponse response) {
        String reason = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("Bad credentials", reason);
    }

    public void assertAuthWithIncorrectUsernameAndPassword(ValidatableResponse response) {
        String reason = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("Bad credentials", reason);
    }

    public void assertAuthWithoutUsername(ValidatableResponse response) {
        String reason = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("Bad credentials", reason);
    }

    public void assertAuthWithoutPassword(ValidatableResponse response) {
        String reason = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("Bad credentials", reason);
    }

    public void assertAuthWithoutUsernameAndPassword(ValidatableResponse response) {
        String reason = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("Bad credentials", reason);
    }
}
