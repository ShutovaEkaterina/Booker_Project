package deleteBooking;

import createBooking.NewBooking;
import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

public class DeleteBookingResponse {

    // Asserts for basic authorization
    public void assertDeletingExistingBookingIdBasicAuth(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CREATED);
    }

    public void assertDeletingNonExistingBookingIdBasicAuth(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_NOT_FOUND);
    }

    public void assertDeletingNullBookingIdBasicAuth(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_NOT_FOUND);
    }

    // Asserts for cookie authorization
    public void assertDeletingExistingBookingIdCookieAuth(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CREATED);
    }

    public void assertDeletingNonExistingBookingIdCookieAuth(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_NOT_FOUND);
    }

    public void assertDeletingNullBookingIdCookieAuth(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_NOT_FOUND);
    }

    // Asserts without auth headers
    public void assertDeletingBookingWithoutBasicAuthAndCookie(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_FORBIDDEN);
    }
}
