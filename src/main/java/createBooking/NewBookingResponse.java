package createBooking;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.*;

public class NewBookingResponse {
    public void assertSuccessCreatingBookingWithAllFields(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("bookingid", notNullValue())
                .body("booking.firstname", notNullValue())
                .body("booking.lastname", notNullValue())
                .body("booking.totalprice", notNullValue())
                .body("booking.depositpaid", notNullValue())
                .body("booking.bookingdates.checkin", notNullValue())
                .body("booking.bookingdates.checkout", notNullValue())
                .body("booking.additionalneeds", notNullValue());
    }

    public void assertSuccessCreatingBookingWithEmptyAdditionalNeedsField(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("bookingid", notNullValue())
                .body("booking.firstname", notNullValue())
                .body("booking.lastname", notNullValue())
                .body("booking.totalprice", notNullValue())
                .body("booking.depositpaid", notNullValue())
                .body("booking.bookingdates.checkin", notNullValue())
                .body("booking.bookingdates.checkout", notNullValue())
                .body("booking.additionalneeds", is(""));
    }

    public void assertSuccessCreatingBookingWithNullAdditionalNeedsField(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("bookingid", notNullValue())
                .body("booking.firstname", notNullValue())
                .body("booking.lastname", notNullValue())
                .body("booking.totalprice", notNullValue())
                .body("booking.depositpaid", notNullValue())
                .body("booking.bookingdates.checkin", notNullValue())
                .body("booking.bookingdates.checkout", notNullValue())
                .body("booking.additionalneeds", nullValue());
    }

    public void assertSuccessCreatingBookingWithEmptyCheckoutDateField(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("bookingid", notNullValue())
                .body("booking.firstname", notNullValue())
                .body("booking.lastname", notNullValue())
                .body("booking.totalprice", notNullValue())
                .body("booking.depositpaid", notNullValue())
                .body("booking.bookingdates.checkin", notNullValue())
                .body("booking.bookingdates.checkout", notNullValue())
                .body("booking.additionalneeds", notNullValue());
    }
}
