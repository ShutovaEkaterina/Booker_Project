package createBooking;

import configPackage.Config;
import io.restassured.response.ValidatableResponse;

public class UpdateBookingRequest extends Config {
    private String basicAuthorization = "Basic YWRtaW46cGFzc3dvcmQxMjM=";
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

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

    public ValidatableResponse updateBookingWithCookie(String id, NewBooking newBooking) {
        return spec()
                .header("Cookie", "token=" + token)
                .body(newBooking)
                .log().body()
                .when()
                .put(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse updateBookingWithCookieAndBasicAuth(String id, NewBooking newBooking) {
        return spec()
                .header("Authorization", basicAuthorization)
                .header("Cookie", "token=" + token)
                .body(newBooking)
                .log().body()
                .when()
                .put(BOOKING_PATH + "/" + id)
                .then().log().all();
    }
}
