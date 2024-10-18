package createBooking;

import configPackage.Config;
import io.restassured.response.ValidatableResponse;

public class NewBookingRequest extends Config {
    public ValidatableResponse createBooking(NewBooking newBooking) {
        return spec()
                .body(newBooking)
                .log().body()
                .when()
                .post(BOOKING_PATH)
                .then().log().all();
    }

    public ValidatableResponse createBookingXML(String xmlBody) {
        return specXML()
                .body(xmlBody)
                .log().body()
                .when()
                .post(BOOKING_PATH)
                .then().log().all();
    }
}
