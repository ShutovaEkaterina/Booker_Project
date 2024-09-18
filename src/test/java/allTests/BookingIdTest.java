package allTests;

import bookingsIdPackage.BookingIdResponse;
import bookingsIdPackage.BookingsIdRequest;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class BookingIdTest {
    private final BookingIdResponse bookingIdResponse= new BookingIdResponse();
    private final BookingsIdRequest bookingsIdRequest = new BookingsIdRequest();


    @Test
    public void testBookingExistedId() {
        String id = "1";
        ValidatableResponse response = bookingsIdRequest.getBookingsExistedId(id);
        bookingIdResponse.assertWithExistingBookingId(response);
    }

}
