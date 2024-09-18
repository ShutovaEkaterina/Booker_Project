package allBookingsPackage;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class AllBookingsResponse {
    public void assertAllBookingsWithoutParams(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("size()", greaterThan(0))
                .body("[0].bookingid", notNullValue());
    }

    // assertAllBookingsEmptyByFirstNameAndLastName
    // assertAllBookingsEmptyByNonExistingUser
    public void assertAllBookingsEmptyByNoneExistingUser(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("size()", equalTo(0));
    }

    public void assertAllBookingsByExistingUser(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("size()", greaterThan(0));
    }

    public void assertAllBookingsByFirstnameFilter(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("size()", either(greaterThan(0)).or(equalTo(0)));
    }

    public void assertAllBookingsByLastnameFilter(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("size()", either(greaterThan(0)).or(equalTo(0)));
    }

    public void assertAllBookingsByDates(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("size()", either(greaterThan(0)).or(equalTo(0)));
    }

    public void assertAllBookingsByCheckinFilter(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("size()", either(greaterThan(0)).or(equalTo(0)));
    }

    public void assertAllBookingsByCheckoutFilter(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("size()", either(greaterThan(0)).or(equalTo(0)));
    }

    public void assertAllBookingsByWrongDateFilter(ValidatableResponse response) {
        String reason = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("Checkin date cannot be later then checkout date", reason);
    }
}
