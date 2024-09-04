package authTests;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import pomAllBookings.AllBookingRequest;
import pomAllBookings.AllBookingsResponse;

public class AllBookingsTest {
    private final AllBookingRequest allBookingRequest = new AllBookingRequest();
    private final AllBookingsResponse allBookingsResponse = new AllBookingsResponse();
    @Test
    public void allBookingsGet() {
        ValidatableResponse getAllBookingsResponse = allBookingRequest.getAllBookings();
        allBookingsResponse.allBookingsSuccess(getAllBookingsResponse);
    }
    @Test
    public void allBookingsGetFilterName() {
        String firstname = "sally";
        String lastname = "brown";
        ValidatableResponse getAllBookingsResponse = allBookingRequest.getAllBookingsNameFilter(firstname, lastname);
        allBookingsResponse.allBookingsFilterName(getAllBookingsResponse);
    }
}
