package bookingsIdPackage;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.notNullValue;

public class BookingIdResponse {
    public void bookingExistedId(ValidatableResponse getExistedIdResponse) {
        getExistedIdResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("firstname", notNullValue())
                .body("lastname", notNullValue());
    }
}
