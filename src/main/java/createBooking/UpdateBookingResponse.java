package createBooking;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.*;

public class UpdateBookingResponse {
    private final String datePattern = "\\d{4}-\\d{2}-\\d{2}";

    public void assertUpdateBookingFirstnameWithBasicAuth(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("firstname", equalTo("Karla"))
                .body("lastname", notNullValue())
                .body("totalprice", greaterThan(0))
                .body("depositpaid", either(equalTo(true)).or(equalTo(false)))
                .body("bookingdates.checkin", matchesPattern(datePattern))
                .body("bookingdates.checkout", matchesPattern(datePattern))
                .body("additionalneeds", notNullValue());
    }

    public void assertUpdateBookingLastnameWithBasicAuth(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("firstname", notNullValue())
                .body("lastname", equalTo("Cooper"))
                .body("totalprice", greaterThan(0))
                .body("depositpaid", either(equalTo(true)).or(equalTo(false)))
                .body("bookingdates.checkin", matchesPattern(datePattern))
                .body("bookingdates.checkout", matchesPattern(datePattern))
                .body("additionalneeds", notNullValue());
    }

    public void assertUpdateBookingTotalPriceWithBasicAuth(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("firstname", notNullValue())
                .body("lastname", notNullValue())
                .body("totalprice", equalTo(200))
                .body("depositpaid", either(equalTo(true)).or(equalTo(false)))
                .body("bookingdates.checkin", matchesPattern(datePattern))
                .body("bookingdates.checkout", matchesPattern(datePattern))
                .body("additionalneeds", notNullValue());
    }

    public void assertUpdateBookingDepositePaidWithBasicAuth(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("firstname", notNullValue())
                .body("lastname", notNullValue())
                .body("totalprice", greaterThan(0))
                .body("depositpaid", equalTo(true))
                .body("bookingdates.checkin", matchesPattern(datePattern))
                .body("bookingdates.checkout", matchesPattern(datePattern))
                .body("additionalneeds", notNullValue());
    }

    public void assertUpdateBookingCheckinDateWithBasicAuth(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("firstname", notNullValue())
                .body("lastname", notNullValue())
                .body("totalprice", greaterThan(0))
                .body("depositpaid", either(equalTo(true)).or(equalTo(false)))
                .body("bookingdates.checkin", equalTo("2024-12-12"))
                .body("bookingdates.checkout", matchesPattern(datePattern))
                .body("additionalneeds", notNullValue());
    }

    public void assertUpdateBookingCheckoutDateWithBasicAuth(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("firstname", notNullValue())
                .body("lastname", notNullValue())
                .body("totalprice", greaterThan(0))
                .body("depositpaid", either(equalTo(true)).or(equalTo(false)))
                .body("bookingdates.checkin", matchesPattern(datePattern))
                .body("bookingdates.checkout", equalTo("2024-12-21"))
                .body("additionalneeds", notNullValue());
    }

    public void assertUpdateBookingAdditionalNeedsWithBasicAuth(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("firstname", notNullValue())
                .body("lastname", notNullValue())
                .body("totalprice", greaterThan(0))
                .body("depositpaid", either(equalTo(true)).or(equalTo(false)))
                .body("bookingdates.checkin", matchesPattern(datePattern))
                .body("bookingdates.checkout", matchesPattern(datePattern))
                .body("additionalneeds", equalTo("No sounds"));
    }

    public void assertUpdateBookingWithNotExistingIdWithBasicAuth(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_NOT_FOUND);
    }

    public void assertUpdateBookingWithoutBasicAuthAndCookieWithBasicAuth(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_FORBIDDEN);
    }
}
