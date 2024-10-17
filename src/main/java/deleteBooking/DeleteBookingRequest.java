package deleteBooking;

import configPackage.Config;
import createBooking.AuthUtil;
import createBooking.NewBooking;
import io.restassured.response.ValidatableResponse;

public class DeleteBookingRequest extends Config {
    private final String basicAuthorization = AuthUtil.createBasicAuthorization("admin", "password123");
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public ValidatableResponse deleteBookingWithBasicAuth(String id) {
        return spec()
                .header("Authorization", basicAuthorization)
                .when()
                .delete(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse deleteBookingWithCookieAuth(String id) {
        return spec()
                .header("Cookie", "token=" + token)
                .when()
                .delete(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse deleteBookingWithoutBasicAuthAndCookie(String id) {
        return spec()
                .when()
                .delete(BOOKING_PATH + "/" + id)
                .then().log().all();
    }
}
