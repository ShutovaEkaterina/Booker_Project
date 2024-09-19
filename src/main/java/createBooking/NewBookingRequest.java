package createBooking;

import configPackage.Config;
import io.restassured.response.ValidatableResponse;

public class NewBookingRequest extends Config {
    public ValidatableResponse createBooking(NewBooking newBooking) {
        return spec()
                .body(newBooking)
                .when()
                .post(BOOKING_PATH)
                .then().log().all();
    }
}
