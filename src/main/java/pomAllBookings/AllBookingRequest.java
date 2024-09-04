package pomAllBookings;

import basicStaff.Basic;
import io.restassured.response.ValidatableResponse;

public class AllBookingRequest extends Basic {
    private static final String ALL_BOOKING_PATH = "/booking";
    public ValidatableResponse getAllBookings() {
        return spec()
                .when()
                .get(ALL_BOOKING_PATH)
                .then().log().all();
    }
}
