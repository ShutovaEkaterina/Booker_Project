package bookingsIdPackage;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.notNullValue;

public class BookingIdResponse {
    public void assertWithExistingBookingId(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("firstname", notNullValue())
                .body("lastname", notNullValue());
    }
}
