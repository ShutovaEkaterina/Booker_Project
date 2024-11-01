package createBooking;

import configPackage.Config;
import io.restassured.response.ValidatableResponse;

public class PartialUpdateRequest extends Config {
    private final String basicAuthorization = AuthUtil.createBasicAuthorization("admin", "password123");
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    // Updating with basic authorization
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

    public ValidatableResponse partialUpdateBookingCheckoutDateWithBasicAuth(String id, String checkoutDate) {
        String requestBody = "{ \"bookingdates\": { \"checkout\": \"" + checkoutDate + "\" } }";
        return spec()
                .header("Authorization", basicAuthorization)
                .body(requestBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse partialUpdateBookingAdditionalNeedsWithBasicAuth(String id, String additionalNeeds) {
        String requestBody = "{ \"additionalneeds\": \"" + additionalNeeds + "\" }";
        return spec()
                .header("Authorization", basicAuthorization)
                .body(requestBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse partialUpdateBookingAdditionalNeedsAndIncorrectIdWithBasicAuth(String id, String additionalNeeds) {
        String requestBody = "{ \"additionalneeds\": \"" + additionalNeeds + "\" }";
        return spec()
                .header("Authorization", basicAuthorization)
                .body(requestBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    // Updating without basic authorization and without cookie
    public ValidatableResponse partialUpdateBookingWithoutBasicAuthAndCookie(String id, boolean depositPaid) {
        String requestBody = "{ \"depositpaid\": \"" + depositPaid + "\" }";
        return spec()
                .body(requestBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    // Updating with cookie
    public ValidatableResponse partialUpdateBookingFirstnameWithCookie(String id, String firstname) {
        String requestBody = "{ \"firstname\": \"" + firstname + "\" }";
        return spec()
                .header("Cookie", "token=" + token)
                .body(requestBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse partialUpdateBookingLastnameWithCookie(String id, String lastname) {
        String requestBody = "{ \"lastname\": \"" + lastname + "\" }";
        return spec()
                .header("Cookie", "token=" + token)
                .body(requestBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse partialUpdateBookingTotalPriceWithCookieAuth(String id, int totalPrice) {
        String requestBody = "{ \"totalprice\": \"" + totalPrice + "\" }";
        return spec()
                .header("Cookie", "token=" + token)
                .body(requestBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse partialUpdateBookingDepositPaidWithCookieAuth(String id, boolean depositPaid) {
        String requestBody = "{ \"depositpaid\": \"" + depositPaid + "\" }";
        return spec()
                .header("Cookie", "token=" + token)
                .body(requestBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse partialUpdateBookingCheckinDateWithCookieAuth(String id, String checkinDate) {
        String requestBody = "{ \"bookingdates\": { \"checkin\": \"" + checkinDate + "\" } }";
        return spec()
                .header("Cookie", "token=" + token)
                .body(requestBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse partialUpdateBookingCheckoutDateWithCookieAuth(String id, String checkoutDate) {
        String requestBody = "{ \"bookingdates\": { \"checkout\": \"" + checkoutDate + "\" } }";
        return spec()
                .header("Cookie", "token=" + token)
                .body(requestBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse partialUpdateBookingAdditionalNeedsWithCookieAuth(String id, String additionalNeeds) {
        String requestBody = "{ \"additionalneeds\": \"" + additionalNeeds + "\" }";
        return spec()
                .header("Cookie", "token=" + token)
                .body(requestBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse partialUpdateBookingAdditionalNeedsAndIncorrectIdWithCookieAuth(String id, String additionalNeeds) {
        String requestBody = "{ \"additionalneeds\": \"" + additionalNeeds + "\" }";
        return spec()
                .header("Cookie", "token=" + token)
                .body(requestBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    // Updating with XML body
    public ValidatableResponse partialUpdateBookingFirstnameWithBasicAuthXML(String id, String xmlBody) {
        return specXML()
                .header("Authorization", basicAuthorization)
                .body(xmlBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse partialUpdateBookingFirstnameWithCookieXML(String id, String xmlBody) {
        return specXML()
                .header("Cookie", "token=" + token)
                .body(xmlBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

    public ValidatableResponse partialUpdateBookingWithoutBasicAuthAndCookieXML(String id, String xmlBody) {
        return specXML()
                .body(xmlBody)
                .log().body()
                .when()
                .patch(BOOKING_PATH + "/" + id)
                .then().log().all();
    }
}
