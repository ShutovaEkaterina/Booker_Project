package createBooking;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class NewBookingResponse {
    private final String datePattern = "\\d{4}-\\d{2}-\\d{2}";
    public void assertSuccessCreatingBookingWithAllFields(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("bookingid", notNullValue())
                .body("booking.firstname", notNullValue())
                .body("booking.lastname", notNullValue())
                .body("booking.totalprice", greaterThan(0))
                .body("booking.depositpaid", equalTo(true))
                .body("booking.bookingdates.checkin", matchesPattern(datePattern))
                .body("booking.bookingdates.checkout", matchesPattern(datePattern))
                .body("booking.additionalneeds", notNullValue());
    }

    public void assertSuccessCreatingBookingWithEmptyAdditionalNeedsField(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("bookingid", notNullValue())
                .body("booking.firstname", notNullValue())
                .body("booking.lastname", notNullValue())
                .body("booking.totalprice", greaterThan(0))
                .body("booking.depositpaid", equalTo(true))
                .body("booking.bookingdates.checkin", matchesPattern(datePattern))
                .body("booking.bookingdates.checkout", matchesPattern(datePattern))
                .body("booking.additionalneeds", is(""));
    }

    public void assertSuccessCreatingBookingWithNullAdditionalNeedsField(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("bookingid", notNullValue())
                .body("booking.firstname", notNullValue())
                .body("booking.lastname", notNullValue())
                .body("booking.totalprice", greaterThan(0))
                .body("booking.depositpaid", equalTo(true))
                .body("booking.bookingdates.checkin", matchesPattern(datePattern))
                .body("booking.bookingdates.checkout", matchesPattern(datePattern))
                .body("booking.additionalneeds", nullValue());
    }

    public void assertSuccessCreatingBookingWithEmptyCheckoutDateField(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .body("bookingid", notNullValue())
                .body("booking.firstname", notNullValue())
                .body("booking.lastname", notNullValue())
                .body("booking.totalprice", greaterThan(0))
                .body("booking.depositpaid", equalTo(true))
                .body("booking.bookingdates.checkin", matchesPattern(datePattern))
                .body("booking.bookingdates.checkout", matchesPattern(datePattern))
                .body("booking.additionalneeds", notNullValue());
    }

    public void assertSuccessCreatingBookingWithEmptyCheckinDateField(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .body("bookingid", notNullValue())
                .body("booking.firstname", notNullValue())
                .body("booking.lastname", notNullValue())
                .body("booking.totalprice", greaterThan(0))
                .body("booking.depositpaid", equalTo(true))
                .body("booking.bookingdates.checkin", matchesPattern(datePattern))
                .body("booking.bookingdates.checkout", matchesPattern(datePattern))
                .body("booking.additionalneeds", notNullValue());
    }

    public void assertSuccessCreatingBookingWithIncorrectFormatDates(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .body("bookingid", notNullValue())
                .body("booking.firstname", notNullValue())
                .body("booking.lastname", notNullValue())
                .body("booking.totalprice", greaterThan(0))
                .body("booking.depositpaid", equalTo(true))
                .body("booking.bookingdates.checkin", matchesPattern(datePattern))
                .body("booking.bookingdates.checkout", matchesPattern(datePattern))
                .body("booking.additionalneeds", notNullValue());
    }

    public void assertSuccessCreatingBookingWithWrongDatesFields(ValidatableResponse response) {
        String reason = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .body("bookingid", notNullValue())
                .body("booking.firstname", notNullValue())
                .body("booking.lastname", notNullValue())
                .body("booking.totalprice", greaterThan(0))
                .body("booking.depositpaid", equalTo(true))
                .body("booking.bookingdates.checkin", matchesPattern(datePattern))
                .body("booking.bookingdates.checkout", matchesPattern(datePattern))
                .body("booking.additionalneeds", notNullValue())
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("Checkin date cannot be later then checkout date", reason);
    }

    public void assertSuccessCreatingBookingWithDatesInThePast(ValidatableResponse response) {
        String reason = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .body("bookingid", notNullValue())
                .body("booking.firstname", notNullValue())
                .body("booking.lastname", notNullValue())
                .body("booking.totalprice", greaterThan(0))
                .body("booking.depositpaid", equalTo(true))
                .body("booking.bookingdates.checkin", matchesPattern(datePattern))
                .body("booking.bookingdates.checkout", matchesPattern(datePattern))
                .body("booking.additionalneeds", notNullValue())
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("You can choose dates starting from today", reason);
    }

    public void assertSuccessCreatingBookingWithFalseDepositPaid(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("bookingid", notNullValue())
                .body("booking.firstname", notNullValue())
                .body("booking.lastname", notNullValue())
                .body("booking.totalprice", greaterThan(0))
                .body("booking.depositpaid", equalTo(false))
                .body("booking.bookingdates.checkin", matchesPattern(datePattern))
                .body("booking.bookingdates.checkout", matchesPattern(datePattern))
                .body("booking.additionalneeds", notNullValue());
    }

    public void assertSuccessCreatingBookingWithZeroTotalPrice(ValidatableResponse response) {
        String reason = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .body("bookingid", notNullValue())
                .body("booking.firstname", notNullValue())
                .body("booking.lastname", notNullValue())
                .body("booking.totalprice", greaterThan(0))
                .body("booking.depositpaid", equalTo(false))
                .body("booking.bookingdates.checkin", matchesPattern(datePattern))
                .body("booking.bookingdates.checkout", matchesPattern(datePattern))
                .body("booking.additionalneeds", notNullValue())
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("The totalprice has to be greater then 0", reason);
    }

    public void assertSuccessCreatingBookingWithEmptyFirstname(ValidatableResponse response) {
        String reason = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .body("bookingid", notNullValue())
                .body("booking.firstname", notNullValue())
                .body("booking.lastname", notNullValue())
                .body("booking.totalprice", greaterThan(0))
                .body("booking.depositpaid", equalTo(false))
                .body("booking.bookingdates.checkin", matchesPattern(datePattern))
                .body("booking.bookingdates.checkout", matchesPattern(datePattern))
                .body("booking.additionalneeds", notNullValue())
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("The firstname cannot be empty", reason);
    }

    public void assertSuccessCreatingBookingWithEmptyLastname(ValidatableResponse response) {
        String reason = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .body("bookingid", notNullValue())
                .body("booking.firstname", notNullValue())
                .body("booking.lastname", notNullValue())
                .body("booking.totalprice", greaterThan(0))
                .body("booking.depositpaid", equalTo(false))
                .body("booking.bookingdates.checkin", matchesPattern(datePattern))
                .body("booking.bookingdates.checkout", matchesPattern(datePattern))
                .body("booking.additionalneeds", notNullValue())
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("The lastname cannot be empty", reason);
    }

    public void assertSuccessCreatingBookingWithAllFieldsXML(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("bookingid", notNullValue())
                .body("booking.firstname", notNullValue())
                .body("booking.lastname", notNullValue())
                .body("booking.totalprice", greaterThan(0))
                .body("booking.depositpaid", equalTo(true))
                .body("booking.bookingdates.checkin", matchesPattern(datePattern))
                .body("booking.bookingdates.checkout", matchesPattern(datePattern))
                .body("booking.additionalneeds", notNullValue());
    }
}
