package allTests;

import createBooking.BookingDates;
import createBooking.NewBooking;
import createBooking.UpdateBookingRequest;
import createBooking.UpdateBookingResponse;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class UpdateBookingWithoutAuthHeaderTest {
    private final UpdateBookingRequest updateBookingRequest = new UpdateBookingRequest();
    private final UpdateBookingResponse updateBookingResponse = new UpdateBookingResponse();

    @Test
    public void updateBookingWithoutBasicAuthAndCookieBasicAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2024-12-12", "2024-12-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, true, bookingDates,"No sounds");
        ValidatableResponse response = updateBookingRequest.updateBookingWithoutBasicAuthAndCookie(id, newBooking);
        updateBookingResponse.assertUpdateBookingWithoutBasicAuthAndCookieWithBasicAuth(response);
    }

}
