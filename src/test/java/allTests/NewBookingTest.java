package allTests;

import createBooking.BookingDates;
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
        BookingDates bookingdates = new BookingDates("2024-09-12", "2024-09-15");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 344, true, bookingdates, "Nothing needed");
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);
        newBookingResponse.assertSuccessCreatingBookingWithAllFields(response);
    }
}
