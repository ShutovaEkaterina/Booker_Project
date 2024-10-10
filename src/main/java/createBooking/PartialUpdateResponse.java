package createBooking;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.equalTo;

public class PartialUpdateResponse {
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
}
