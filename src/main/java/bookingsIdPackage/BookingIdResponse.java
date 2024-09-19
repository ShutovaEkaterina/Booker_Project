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
                .body("lastname", notNullValue())
                .body("totalprice", notNullValue())
                .body("depositpaid", notNullValue())
                .body("bookingdates.checkin", notNullValue())
                .body("bookingdates.checkout", notNullValue())
                .body("additionalneeds", notNullValue());
    }
    public void assertWithNoneExistingBookingId(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_NOT_FOUND);
    }

    public void assertWithNullBookingId(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_NOT_FOUND);
    }
}