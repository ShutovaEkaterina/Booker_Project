package allTests;

import bookingsIdPackage.BookingsIdRequest;
import createBooking.BookingDates;
import createBooking.NewBooking;
import createBooking.UpdateBookingRequest;
import createBooking.UpdateBookingResponse;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

public class UpdateBookingBasicAuthTest {
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
    public void updateFirstnameBasicAuthTest() {
        currentBooking.setFirstname("Karla");
        ValidatableResponse response = updateBookingRequest.updateBookingWithBasicAuth(id, currentBooking);
        updateBookingResponse.assertUpdateBookingFirstnameWithBasicAuth(response, currentBooking);
    }

    @Test
    public void updateLastnameBasicAuthTest() {
        currentBooking.setLastname("Cooper");
        ValidatableResponse response = updateBookingRequest.updateBookingWithBasicAuth(id, currentBooking);
        updateBookingResponse.assertUpdateBookingLastnameWithBasicAuth(response, currentBooking);
    }

    @Test
    public void updateTotalPriceBasicAuthTest() {
        currentBooking.setTotalprice(200);
        ValidatableResponse response = updateBookingRequest.updateBookingWithBasicAuth(id, currentBooking);
        updateBookingResponse.assertUpdateBookingTotalPriceWithBasicAuth(response, currentBooking);
    }

    @Test
    public void updateDepositePaidBasicAuthTest() {
        currentBooking.setDepositpaid(true);
        ValidatableResponse response = updateBookingRequest.updateBookingWithBasicAuth(id, currentBooking);
        updateBookingResponse.assertUpdateBookingDepositePaidWithBasicAuth(response, currentBooking);
    }

    @Test
    public void updateCheckinDateBasicAuthTest() {
        BookingDates currentBookingDates = currentBooking.getBookingdates();
        currentBookingDates.setCheckin("2024-12-12");
        currentBooking.setBookingdates(currentBookingDates);
        ValidatableResponse response = updateBookingRequest.updateBookingWithBasicAuth(id, currentBooking);
        updateBookingResponse.assertUpdateBookingCheckinDateWithBasicAuth(response, currentBooking);
    }

    @Test
    public void updateCheckoutDateBasicAuthTest() {
        BookingDates currentBookingsDates = currentBooking.getBookingdates();
        currentBookingsDates.setCheckout("2024-12-30");
        currentBooking.setBookingdates(currentBookingsDates);
        ValidatableResponse response = updateBookingRequest.updateBookingWithBasicAuth(id, currentBooking);
        updateBookingResponse.assertUpdateBookingCheckoutDateWithBasicAuth(response, currentBooking);
    }

    @Test
    public void updateAdditionalNeedsBasicAuthTest() {
        currentBooking.setAdditionalneeds("No sounds");
        ValidatableResponse response = updateBookingRequest.updateBookingWithBasicAuth(id, currentBooking);
        updateBookingResponse.assertUpdateBookingAdditionalNeedsWithBasicAuth(response, currentBooking);
    }

    // The test failed because it returned a 405 status code
    @Test
    public void updateNotExistingIdBasicAuthTest() {
        String id = "3000000000";
        BookingDates bookingDates = new BookingDates("2024-12-12", "2024-12-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, true, bookingDates,"No sounds");
        ValidatableResponse response = updateBookingRequest.updateBookingWithBasicAuth(id, newBooking);
        updateBookingResponse.assertUpdateBookingWithNotExistingIdWithBasicAuth(response);
    }
}
