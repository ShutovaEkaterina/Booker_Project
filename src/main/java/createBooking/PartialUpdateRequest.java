package createBooking;

import configPackage.Config;
import io.restassured.response.ValidatableResponse;

public class PartialUpdateRequest extends Config {
    private final String basicAuthorization = AuthUtil.createBasicAuthorization("admin", "password123");
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public ValidatableResponse partialUpdateBookingWithBasicAuth(String id, String firstname) {
        String requestBody = "{ \"firstname\": \"" + firstname + "\" }";
        return spec()
                .header("Authorization", basicAuthorization)
                .body(requestBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse partialUpdateBookingWithoutBasicAuthAndCookie(String id, NewBooking newBooking) {
        return spec()
                .body(newBooking)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse partialUpdateBookingWithCookie(String id, NewBooking newBooking) {
        return spec()
                .header("Cookie", "token=" + token)
                .body(newBooking)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }
}
