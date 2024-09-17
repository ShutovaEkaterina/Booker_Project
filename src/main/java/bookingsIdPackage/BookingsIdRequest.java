package bookingsIdPackage;

import configPackage.Config;
import io.restassured.response.ValidatableResponse;

public class BookingsIdRequest extends Config {
    public ValidatableResponse getBookingsExistedId(String id) {
        return spec()
                .when()
                .get(BOOKING_PATH + "/" + id)
                .then().log().all();
    }

}
