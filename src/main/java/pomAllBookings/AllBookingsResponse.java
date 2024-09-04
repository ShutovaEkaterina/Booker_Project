package pomAllBookings;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.*;

public class AllBookingsResponse {
    public void allBookingsSuccess(ValidatableResponse getAllBookingsResponse) {
        getAllBookingsResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("size()", greaterThan(0))
                .body("[0].bookingid", notNullValue());
    }
    public void allBookingsFilterName (ValidatableResponse getAllBookingsResponse) {
        getAllBookingsResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("size()", either(greaterThan(0)).or(equalTo(0)));
    }
}
