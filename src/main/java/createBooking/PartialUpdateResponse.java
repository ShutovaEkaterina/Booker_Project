package createBooking;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.equalTo;

public class PartialUpdateResponse {

    // Asserts for basic authorization
    public void assertPartialUpdateBookingFirstnameWithBasicAuth(ValidatableResponse response, NewBooking currentBooking) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("firstname", equalTo("Karla"))
                .body("lastname", equalTo(currentBooking.getLastname()))
                .body("totalprice", equalTo(currentBooking.getTotalprice()))
                .body("depositpaid", equalTo(currentBooking.isDepositpaid()))
                .body("bookingdates.checkin", equalTo(currentBooking.getBookingdates().getCheckin()))
                .body("bookingdates.checkout", equalTo(currentBooking.getBookingdates().getCheckout()))
                .body("additionalneeds", equalTo(currentBooking.getAdditionalneeds()));
    }

    public void assertPartialUpdateBookingLastnameWithBasicAuth(ValidatableResponse response, NewBooking currentBooking) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("firstname", equalTo(currentBooking.getFirstname()))
                .body("lastname", equalTo("Cooper"))
                .body("totalprice", equalTo(currentBooking.getTotalprice()))
                .body("depositpaid", equalTo(currentBooking.isDepositpaid()))
                .body("bookingdates.checkin", equalTo(currentBooking.getBookingdates().getCheckin()))
                .body("bookingdates.checkout", equalTo(currentBooking.getBookingdates().getCheckout()))
                .body("additionalneeds", equalTo(currentBooking.getAdditionalneeds()));
    }

    public void assertPartialUpdateBookingTotalPriceWithBasicAuth(ValidatableResponse response, NewBooking currentBooking) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("firstname", equalTo(currentBooking.getFirstname()))
                .body("lastname", equalTo(currentBooking.getLastname()))
                .body("totalprice", equalTo(200))
                .body("depositpaid", equalTo(currentBooking.isDepositpaid()))
                .body("bookingdates.checkin", equalTo(currentBooking.getBookingdates().getCheckin()))
                .body("bookingdates.checkout", equalTo(currentBooking.getBookingdates().getCheckout()))
                .body("additionalneeds", equalTo(currentBooking.getAdditionalneeds()));
    }

    public void assertPartialUpdateBookingDepositPaidWithBasicAuth(ValidatableResponse response, NewBooking currentBooking) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("firstname", equalTo(currentBooking.getFirstname()))
                .body("lastname", equalTo(currentBooking.getLastname()))
                .body("totalprice", equalTo(currentBooking.getTotalprice()))
                .body("depositpaid", equalTo(true))
                .body("bookingdates.checkin", equalTo(currentBooking.getBookingdates().getCheckin()))
                .body("bookingdates.checkout", equalTo(currentBooking.getBookingdates().getCheckout()))
                .body("additionalneeds", equalTo(currentBooking.getAdditionalneeds()));
    }

    public void assertPartialUpdateBookingCheckinDateWithBasicAuth(ValidatableResponse response, NewBooking currentBooking) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("firstname", equalTo(currentBooking.getFirstname()))
                .body("lastname", equalTo(currentBooking.getLastname()))
                .body("totalprice", equalTo(currentBooking.getTotalprice()))
                .body("depositpaid", equalTo(currentBooking.isDepositpaid()))
                .body("bookingdates.checkin", equalTo("2024-12-12"))
                .body("bookingdates.checkout", equalTo(currentBooking.getBookingdates().getCheckout()))
                .body("additionalneeds", equalTo(currentBooking.getAdditionalneeds()));
    }

    public void assertPartialUpdateBookingCheckoutDateWithBasicAuth(ValidatableResponse response, NewBooking currentBooking) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("firstname", equalTo(currentBooking.getFirstname()))
                .body("lastname", equalTo(currentBooking.getLastname()))
                .body("totalprice", equalTo(currentBooking.getTotalprice()))
                .body("depositpaid", equalTo(currentBooking.isDepositpaid()))
                .body("bookingdates.checkin", equalTo(currentBooking.getBookingdates().getCheckin()))
                .body("bookingdates.checkout", equalTo("2024-12-30"))
                .body("additionalneeds", equalTo(currentBooking.getAdditionalneeds()));
    }

    public void assertPartialUpdateBookingAdditionalNeedsWithBasicAuth(ValidatableResponse response, NewBooking currentBooking) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("firstname", equalTo(currentBooking.getFirstname()))
                .body("lastname", equalTo(currentBooking.getLastname()))
                .body("totalprice", equalTo(currentBooking.getTotalprice()))
                .body("depositpaid", equalTo(currentBooking.isDepositpaid()))
                .body("bookingdates.checkin", equalTo(currentBooking.getBookingdates().getCheckin()))
                .body("bookingdates.checkout", equalTo(currentBooking.getBookingdates().getCheckout()))
                .body("additionalneeds", equalTo("No sounds"));
    }

    public void assertPartialUpdateBookingWithNotExistingIdWithBasicAuth(ValidatableResponse response, NewBooking currentBooking) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_NOT_FOUND);
    }

    // Asserts without auth headers
    public void assertPartialUpdateBookingWithoutBasicAuthAndCookie(ValidatableResponse response, NewBooking currentBooking) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_FORBIDDEN);
    }
}
