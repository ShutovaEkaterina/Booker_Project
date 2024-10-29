package createBooking;

import configPackage.Config;
import io.restassured.response.ValidatableResponse;

public class UpdateBookingRequest extends Config {

    private final String basicAuthorization = AuthUtil.createBasicAuthorization("admin", "password123");
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

    public ValidatableResponse updateBookingWithBasicAuthXML(String id, String xmlBody) {
        return specXML()
                .header("Authorization", basicAuthorization)
                .body(xmlBody)
                .log().body()
                .when()
                .put(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse updateBookingWithCookieXML(String id, String xmlBody) {
        return specXML()
                .header("Cookie", "token=" + token)
                .body(xmlBody)
                .log().body()
                .when()
                .put(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse updateBookingWithoutBasicAuthAndCookieXML(String id, String xmlBody) {
        return specXML()
                .body(xmlBody)
                .log().body()
                .when()
                .put(BOOKING_PATH + "/" + id)
                .then().log().all();
    }
}
