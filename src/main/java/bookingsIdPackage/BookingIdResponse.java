package bookingsIdPackage;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.*;

public class BookingIdResponse {
    String datePattern = "\\d{4}-\\d{2}-\\d{2}";
    public void assertWithExistingBookingId(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("firstname", notNullValue())
                .body("lastname", notNullValue())
                .body("totalprice", greaterThan(0))
                .body("depositpaid", either(equalTo(true)).or(equalTo(false)))
                .body("bookingdates.checkin", matchesPattern(datePattern))
                .body("bookingdates.checkout", matchesPattern(datePattern))
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
