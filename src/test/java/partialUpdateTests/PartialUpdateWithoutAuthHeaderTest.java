package partialUpdateTests;

import bookingsIdPackage.BookingsIdRequest;
import createBooking.*;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

public class PartialUpdateWithoutAuthHeaderTest {
    private final PartialUpdateRequest partialUpdateRequest = new PartialUpdateRequest();
    private final PartialUpdateResponse partialUpdateResponse = new PartialUpdateResponse();
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
    public void partialUpdateBookingWithoutBasicAuthAndCookieTest() {
        boolean newDepositPaid = true;
        currentBooking.setDepositpaid(newDepositPaid);
        ValidatableResponse response = partialUpdateRequest.partialUpdateBookingWithoutBasicAuthAndCookie(id, newDepositPaid);
        partialUpdateResponse.assertPartialUpdateBookingWithoutBasicAuthAndCookie(response, currentBooking);
    }
}
