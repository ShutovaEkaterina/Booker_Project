package allBookingsPackage;

import configPackage.Config;
import io.restassured.response.ValidatableResponse;

public class AllBookingRequest extends Config {


    public ValidatableResponse getAllBookings() {
        return spec()
                .when()
                .get(BOOKING_PATH)
                .then().log().all();
    }

    public ValidatableResponse getAllBookingsNameFilter(String firstname, String lastname) {
        return spec()
                .queryParam("firstname", firstname)
                .queryParam("lastname", lastname)
                .when()
                .get(BOOKING_PATH)
                .then().log().all();
    }

    public ValidatableResponse getAllBookingsFirstnameFilter(String firstname) {
        return spec()
                .queryParam("firstname", firstname)
                .when()
                .get(BOOKING_PATH)
                .then().log().all();
    }

    public ValidatableResponse getAllBookingsLastnameFilter(String lastname) {
        return spec()
                .queryParam("lastname", lastname)
                .when()
                .get(BOOKING_PATH)
                .then().log().all();
    }

    public ValidatableResponse getAllBookingsDateFilter(String checkin, String checkout) {
        return spec()
                .queryParam("checkin", checkin)
                .queryParam("checkout", checkout)
                .when()
                .get(BOOKING_PATH)
                .then().log().all();
    }

    public ValidatableResponse getAllBookingsCheckinDate(String checkin) {
        return spec()
                .queryParam("checkin", checkin)
                .when()
                .get(BOOKING_PATH)
                .then().log().all();
    }

    public ValidatableResponse getAllBookingsCheckoutDate(String checkout) {
        return spec()
                .queryParam("checkout", checkout)
                .when()
                .get(BOOKING_PATH)
                .then().log().all();
    }

    public ValidatableResponse getAllBookingsDateFilterWrong(String checkin, String checkout) {
        return spec()
                .queryParam("checkin", checkin)
                .queryParam("checkout", checkout)
                .when()
                .get(BOOKING_PATH)
                .then().log().all();
    }
}
