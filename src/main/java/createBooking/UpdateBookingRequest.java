package createBooking;

import configPackage.Config;
import io.restassured.response.ValidatableResponse;

public class UpdateBookingRequest extends Config {
    String basicAuthorization = "Basic YWRtaW46cGFzc3dvcmQxMjM=";

    public ValidatableResponse updateBookingWithBasicAuth(String id, NewBooking newBooking) {
        return spec()
                .header("Authorization", basicAuthorization)
                .body(newBooking)
                .log().body()
                .when()
                .put(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse updateBookingWithoutBasicAuthAndCookie(String id, NewBooking newBooking) {
        return spec()
                .body(newBooking)
                .log().body()
                .when()
                .put(BOOKING_PATH + "/" + id)
                .then().log().all();
    }
}
