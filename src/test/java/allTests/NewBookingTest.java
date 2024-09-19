package allTests;

import createBooking.NewBooking;
import createBooking.NewBookingRequest;
import createBooking.NewBookingResponse;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class NewBookingTest {
    private final NewBookingRequest newBookingRequest = new NewBookingRequest();
    private final NewBookingResponse newBookingResponse = new NewBookingResponse();

    @Test
    public void testCreateNewBookingWithAllFields() {
        NewBooking newBooking = new NewBooking("Amanda", "Smith", "Nothing needed", "2024-12-12", "2024-12-15", 344, true);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);
        newBookingResponse.assertSuccessCreatingBookingWithAllFields(response);
    }
}
