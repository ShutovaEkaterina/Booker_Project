package createBooking;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.*;

public class UpdateBookingResponse {
    private final String datePattern = "\\d{4}-\\d{2}-\\d{2}";

    // Asserts for basic authorization
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

    // Asserts without auth headers
    public void assertUpdateBookingWithoutBasicAuthAndCookieWithBasicAuth(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_FORBIDDEN);
    }

    // Asserts for cookie authorization
    public void assertUpdateBookingFirstnameWithCookieAuth(ValidatableResponse response) {
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

    public void assertUpdateBookingLastnameWithCookieAuth(ValidatableResponse response) {
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

    public void assertUpdateBookingTotalPriceWithCookieAuth(ValidatableResponse response) {
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

    public void assertUpdateBookingDepositePaidWithCookieAuth(ValidatableResponse response) {
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

    public void assertUpdateBookingCheckinDateWithCookieAuth(ValidatableResponse response) {
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

    public void assertUpdateBookingCheckoutDateWithCookieAuth(ValidatableResponse response) {
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

    public void assertUpdateBookingAdditionalNeedsWithCookieAuth(ValidatableResponse response) {
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

    public void assertUpdateBookingWithNotExistingIdWithCookieAuth(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_NOT_FOUND);
    }

    // Asserts for basic and cookie authorization
    public void assertUpdateBookingFirstnameWithCookieAndBasicAuth(ValidatableResponse response) {
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

    public void assertUpdateBookingLastnameWithCookieAndBasicAuth(ValidatableResponse response) {
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

    public void assertUpdateBookingTotalPriceWithCookieAndBasicAuth(ValidatableResponse response) {
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

    public void assertUpdateBookingDepositePaidWithCookieAndBasicAuth(ValidatableResponse response) {
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

    public void assertUpdateBookingCheckinDateWithCookieAndBasicAuth(ValidatableResponse response) {
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

    public void assertUpdateBookingCheckoutDateWithCookieAndBasicAuth(ValidatableResponse response) {
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

    public void assertUpdateBookingAdditionalNeedsWithCookieAndBasicAuth(ValidatableResponse response) {
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

    public void assertUpdateBookingWithNotExistingIdWithCookieAndBasicAuth(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_NOT_FOUND);
    }

}
