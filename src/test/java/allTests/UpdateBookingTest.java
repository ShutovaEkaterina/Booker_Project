package allTests;

import createBooking.BookingDates;
import createBooking.NewBooking;
import createBooking.UpdateBookingRequest;
import createBooking.UpdateBookingResponse;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class UpdateBookingTest {
    private final UpdateBookingRequest updateBookingRequest = new UpdateBookingRequest();
    private final UpdateBookingResponse updateBookingResponse = new UpdateBookingResponse();

    @Test
    public void updateFirstnameBasicAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2018-10-18", "2024-06-21");
        NewBooking newBooking = new NewBooking("Karla", "Jones", 576, false, bookingDates,"Breakfast");
        ValidatableResponse response = updateBookingRequest.updateBookingWithBasicAuth(id, newBooking);
        updateBookingResponse.assertUpdateBookingFirstnameWithBasicAuth(response);
    }

    @Test
    public void updateLastnameBasicAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2018-10-18", "2024-06-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 576, false, bookingDates,"Breakfast");
        ValidatableResponse response = updateBookingRequest.updateBookingWithBasicAuth(id, newBooking);
        updateBookingResponse.assertUpdateBookingLastnameWithBasicAuth(response);
    }

    @Test
    public void updateTotalPriceBasicAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2018-10-18", "2024-06-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, false, bookingDates,"Breakfast");
        ValidatableResponse response = updateBookingRequest.updateBookingWithBasicAuth(id, newBooking);
        updateBookingResponse.assertUpdateBookingTotalPriceWithBasicAuth(response);
    }

    @Test
    public void updateDepositePaidBasicAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2018-10-18", "2024-06-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, true, bookingDates,"Breakfast");
        ValidatableResponse response = updateBookingRequest.updateBookingWithBasicAuth(id, newBooking);
        updateBookingResponse.assertUpdateBookingDepositePaidWithBasicAuth(response);
    }

    @Test
    public void updateCheckinDateBasicAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2024-12-12", "2024-12-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, true, bookingDates,"Breakfast");
        ValidatableResponse response = updateBookingRequest.updateBookingWithBasicAuth(id, newBooking);
        updateBookingResponse.assertUpdateBookingCheckinDateWithBasicAuth(response);
    }

    @Test
    public void updateCheckoutDateBasicAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2024-12-12", "2024-12-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, true, bookingDates,"Breakfast");
        ValidatableResponse response = updateBookingRequest.updateBookingWithBasicAuth(id, newBooking);
        updateBookingResponse.assertUpdateBookingCheckoutDateWithBasicAuth(response);
    }

    @Test
    public void updateAdditionalNeedsBasicAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2024-12-12", "2024-12-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, true, bookingDates,"No sounds");
        ValidatableResponse response = updateBookingRequest.updateBookingWithBasicAuth(id, newBooking);
        updateBookingResponse.assertUpdateBookingAdditionalNeedsWithBasicAuth(response);
    }

    // Тест упадет, так как приходит код 405
    @Test
    public void updateNotExistingIdBasicAuthTest() {
        String id = "3000000000";
        BookingDates bookingDates = new BookingDates("2024-12-12", "2024-12-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, true, bookingDates,"No sounds");
        ValidatableResponse response = updateBookingRequest.updateBookingWithBasicAuth(id, newBooking);
        updateBookingResponse.assertUpdateBookingWithNotExistingIdWithBasicAuth(response);
    }

    @Test
    public void updateBookingWithoutBasicAuthAndCookieBasicAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2024-12-12", "2024-12-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, true, bookingDates,"No sounds");
        ValidatableResponse response = updateBookingRequest.updateBookingWithoutBasicAuthAndCookie(id, newBooking);
        updateBookingResponse.assertUpdateBookingWithoutBasicAuthAndCookieWithBasicAuth(response);
    }
}
