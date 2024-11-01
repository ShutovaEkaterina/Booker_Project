package allTests;

import bookingsIdPackage.BookingIdResponse;
import bookingsIdPackage.BookingsIdRequest;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class BookingIdTest {
    private final BookingIdResponse bookingIdResponse= new BookingIdResponse();
    private final BookingsIdRequest bookingsIdRequest = new BookingsIdRequest();


    @Test
    public void bookingExistedIdTest() {
        String id = "3";
        ValidatableResponse response = bookingsIdRequest.getBookingsId(id);
        bookingIdResponse.assertWithExistingBookingId(response);
    }

    @Test
    public void bookingNoneExistedIdTest() {
        String id = "1000000000";
        ValidatableResponse response = bookingsIdRequest.getBookingsId(id);
        bookingIdResponse.assertWithNoneExistingBookingId(response);
    }

    @Test
    public void bookingNullIdTest() {
        String id = null;
        ValidatableResponse response = bookingsIdRequest.getBookingsId(id);
        bookingIdResponse.assertWithNullBookingId(response);
    }

}
