package allTests;

import bookingsIdPackage.BookingsIdRequest;
import createBooking.BookingDates;
import createBooking.NewBooking;
import createBooking.UpdateBookingRequest;
import createBooking.UpdateBookingResponse;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

public class UpdateBookingWithoutAuthHeaderTest {
    private final UpdateBookingRequest updateBookingRequest = new UpdateBookingRequest();
    private final UpdateBookingResponse updateBookingResponse = new UpdateBookingResponse();
    private final BookingsIdRequest bookingsIdRequest = new BookingsIdRequest();
    private NewBooking currentBooking;
    private final String id = "3";

    @Before
    public void getBooking() {
        ValidatableResponse response = bookingsIdRequest.getBookingsId(id);
        currentBooking = new NewBooking(
                response.extract().path("firstname"),
                response.extract().path("lastname"),
                response.extract().path("totalprice"),
                response.extract().path("depositpaid"),
                new BookingDates(
                        response.extract().path("bookingdates.checkin"),
                        response.extract().path("bookingdates.checkout")
                ),
                response.extract().path("additionalneeds")
        );
    }

    @Test
    public void updateBookingWithoutBasicAuthAndCookieBasicAuthTest() {
        ValidatableResponse response = updateBookingRequest.updateBookingWithoutBasicAuthAndCookie(id, currentBooking);
        updateBookingResponse.assertUpdateBookingWithoutBasicAuthAndCookieWithBasicAuth(response, currentBooking);
    }

}
