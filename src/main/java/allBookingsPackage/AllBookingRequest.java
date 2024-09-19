package allBookingsPackage;

import configPackage.Config;
import io.restassured.response.ValidatableResponse;

public class AllBookingRequest extends Config {


    public ValidatableResponse getAllBookingsWithoutParams() {
        return spec()
                .when()
                .get(BOOKING_PATH)
                .then().log().all();
    }

    public ValidatableResponse getAllBookingsByNameFilter(String firstname, String lastname) {
        return spec()
                .queryParam("firstname", firstname)
                .queryParam("lastname", lastname)
                .when()
                .get(BOOKING_PATH)
                .then().log().all();
    }

    public ValidatableResponse getAllBookingsByFirstnameFilter(String firstname) {
        return spec()
                .queryParam("firstname", firstname)
                .when()
                .get(BOOKING_PATH)
                .then().log().all();
    }

    public ValidatableResponse getAllBookingsByLastnameFilter(String lastname) {
        return spec()
                .queryParam("lastname", lastname)
                .when()
                .get(BOOKING_PATH)
                .then().log().all();
    }

    public ValidatableResponse getAllBookingsByDatesFilter(String checkin, String checkout) {
        return spec()
                .queryParam("checkin", checkin)
                .queryParam("checkout", checkout)
                .when()
                .get(BOOKING_PATH)
                .then().log().all();
    }

    public ValidatableResponse getAllBookingsByCheckInDateFilter(String checkin) {
        return spec()
                .queryParam("checkin", checkin)
                .when()
                .get(BOOKING_PATH)
                .then().log().all();
    }

    public ValidatableResponse getAllBookingsByCheckoutDateFilter(String checkout) {
        return spec()
                .queryParam("checkout", checkout)
                .when()
                .get(BOOKING_PATH)
                .then().log().all();
    }

    public ValidatableResponse getAllBookingsByWrongDateFilter(String checkin, String checkout) {
        return spec()
                .queryParam("checkin", checkin)
                .queryParam("checkout", checkout)
                .when()
                .get(BOOKING_PATH)
                .then().log().all();
    }
}
