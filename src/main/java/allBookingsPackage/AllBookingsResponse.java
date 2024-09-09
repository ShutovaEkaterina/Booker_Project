package allBookingsPackage;

import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

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

    public void allBookingsFilterFirstname (ValidatableResponse getAllBookingsResponse) {
        getAllBookingsResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("size()", either(greaterThan(0)).or(equalTo(0)));
    }

    public void allBookingsFilterLastname (ValidatableResponse getAllBookingsResponse) {
        getAllBookingsResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("size()", either(greaterThan(0)).or(equalTo(0)));
    }

    public void allBookingsFilterDate (ValidatableResponse getAllBookingsResponse) {
        getAllBookingsResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("size()", either(greaterThan(0)).or(equalTo(0)));
    }

    public void allBookingsCheckinDate (ValidatableResponse getAllBookingsResponse) {
        getAllBookingsResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("size()", either(greaterThan(0)).or(equalTo(0)));
    }

    public void allBookingsCheckoutDate (ValidatableResponse getAllBookingsResponse) {
        getAllBookingsResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("size()", either(greaterThan(0)).or(equalTo(0)));
    }

    public void allBookingsFilterDateWrong (ValidatableResponse getAllBookingsResponse) {
        String reason = getAllBookingsResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .jsonPath()
                .getString("reason");
        assertEquals("Checkin date cannot be later then checkout date", reason);
    }
}
