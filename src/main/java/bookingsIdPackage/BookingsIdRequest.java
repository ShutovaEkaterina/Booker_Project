package bookingsIdPackage;

import configPackage.Config;
import io.restassured.response.ValidatableResponse;

public class BookingsIdRequest extends Config {
    public ValidatableResponse getBookingsId(String id) {
        return spec()
                .when()
                .get(BOOKING_PATH + "/" + id)
                .then().log().all();
    }
}
