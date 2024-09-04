package pomAllBookings;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

public class AllBookingsResponse {
    public void allBookingsSuccess(ValidatableResponse getAllBookingsResponse) {
        getAllBookingsResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("size()", greaterThan(0))
                .body("[0].bookingid", notNullValue());
    }
}
