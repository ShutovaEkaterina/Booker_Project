package createBooking;

import configPackage.Config;
import io.restassured.response.ValidatableResponse;

public class PartialUpdateRequest extends Config {
    private final String basicAuthorization = AuthUtil.createBasicAuthorization("admin", "password123");
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public ValidatableResponse partialUpdateBookingFirstnameWithBasicAuth(String id, String firstname) {
        String requestBody = "{ \"firstname\": \"" + firstname + "\" }";
        return spec()
                .header("Authorization", basicAuthorization)
                .body(requestBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse partialUpdateBookingLastnameWithBasicAuth(String id, String lastname) {
        String requestBody = "{ \"lastname\": \"" + lastname + "\" }";
        return spec()
                .header("Authorization", basicAuthorization)
                .body(requestBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse partialUpdateBookingTotalPriceWithBasicAuth(String id, int totalPrice) {
        String requestBody = "{ \"totalprice\": \"" + totalPrice + "\" }";
        return spec()
                .header("Authorization", basicAuthorization)
                .body(requestBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse partialUpdateBookingDepositPaidWithBasicAuth(String id, boolean depositPaid) {
        String requestBody = "{ \"depositpaid\": \"" + depositPaid + "\" }";
        return spec()
                .header("Authorization", basicAuthorization)
                .body(requestBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse partialUpdateBookingCheckinDateWithBasicAuth(String id, String checkinDate) {
        String requestBody = "{ \"bookingdates\": { \"checkin\": \"" + checkinDate + "\" } }";
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
