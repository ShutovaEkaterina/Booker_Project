package createBooking;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.notNullValue;

public class NewBookingResponse {
    public void assertSuccessCreatingBookingWithAllFields(ValidatableResponse response) {
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
}
