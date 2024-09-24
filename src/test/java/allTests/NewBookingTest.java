package allTests;

import com.fasterxml.jackson.annotation.JsonProperty;
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

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithAllFields(response);
    }

    @Test
    public void testCreateNewBookingWithEmptyAdditionalNeedsField() {
        BookingDates bookingdates = new BookingDates("2024-09-12", "2024-09-15");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 344, true, bookingdates, "");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithEmptyAdditionalNeedsField(response);
    }

    @Test
    public void testCreateNewBookingWithNullAdditionalNeedsField() {
        BookingDates bookingdates = new BookingDates("2024-09-12", "2024-09-15");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 344, true, bookingdates, null);

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithNullAdditionalNeedsField(response);
    }
}
