package partialUpdateTests;

import bookingsIdPackage.BookingsIdRequest;
import createBooking.BookingDates;
import createBooking.NewBooking;
import createBooking.PartialUpdateRequest;
import createBooking.PartialUpdateResponse;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

public class PartialUpdateBasicAuthTest {
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
    public void partialUpdateFirstnameBasicAuthTest() {
        String newFirstname = "Karla";
        currentBooking.setFirstname(newFirstname);
        ValidatableResponse response = partialUpdateRequest.partialUpdateBookingFirstnameWithBasicAuth(id, newFirstname);
        partialUpdateResponse.assertPartialUpdateBookingFirstnameWithBasicAuth(response, currentBooking);
    }

    @Test
    public void partialUpdateLastnameBasicAuthTest() {
        String newLastname = "Cooper";
        currentBooking.setLastname(newLastname);
        ValidatableResponse response = partialUpdateRequest.partialUpdateBookingLastnameWithBasicAuth(id, newLastname);
        partialUpdateResponse.assertPartialUpdateBookingLastnameWithBasicAuth(response, currentBooking);
    }

    @Test
    public void partialUpdateTotalPriceBasicAuthTest() {
        int newTotalPrice = 200;
        currentBooking.setTotalprice(newTotalPrice);
        ValidatableResponse response = partialUpdateRequest.partialUpdateBookingTotalPriceWithBasicAuth(id, newTotalPrice);
        partialUpdateResponse.assertPartialUpdateBookingTotalPriceWithBasicAuth(response, currentBooking);
    }

    @Test
    public void partialUpdateDepositPaidBasicAuthTest() {
        boolean newDepositPaid = true;
        currentBooking.setDepositpaid(newDepositPaid);
        ValidatableResponse response = partialUpdateRequest.partialUpdateBookingDepositPaidWithBasicAuth(id, newDepositPaid);
        partialUpdateResponse.assertPartialUpdateBookingDepositPaidWithBasicAuth(response, currentBooking);
    }

    @Test
    public void partialUpdateCheckinDateBasicAuthTest() {
        BookingDates currentBookingsDates = currentBooking.getBookingdates();
        String newCheckinDate = "2024-12-12";
        currentBookingsDates.setCheckin(newCheckinDate);
        ValidatableResponse response = partialUpdateRequest.partialUpdateBookingCheckinDateWithBasicAuth(id, newCheckinDate);
        partialUpdateResponse.assertPartialUpdateBookingCheckinDateWithBasicAuth(response, currentBooking);
    }

    @Test
    public void partialUpdateCheckoutDateBasicAuthTest() {
        BookingDates currentBookingsDates = currentBooking.getBookingdates();
        String newCheckoutDate = "2024-12-30";
        currentBookingsDates.setCheckout(newCheckoutDate);
        ValidatableResponse response = partialUpdateRequest.partialUpdateBookingCheckoutDateWithBasicAuth(id, newCheckoutDate);
        partialUpdateResponse.assertPartialUpdateBookingCheckoutDateWithBasicAuth(response, currentBooking);
    }

    @Test
    public void partialUpdateAdditionalNeedsBasicAuthTest() {
        String newAdditionalNeeds = "No sounds";
        currentBooking.setAdditionalneeds(newAdditionalNeeds);
        ValidatableResponse response = partialUpdateRequest.partialUpdateBookingAdditionalNeedsWithBasicAuth(id, newAdditionalNeeds);
        partialUpdateResponse.assertPartialUpdateBookingAdditionalNeedsWithBasicAuth(response, currentBooking);
    }

    // The test failed because it returned a 405 status code
    @Test
    public void partialUpdateNotExistingIdBasicAuthTest() {
        String id = "30000000";
        String newAdditionalNeeds = "No sounds";
        currentBooking.setAdditionalneeds(newAdditionalNeeds);
        ValidatableResponse response = partialUpdateRequest.partialUpdateBookingAdditionalNeedsAndIncorrectIdWithBasicAuth(id, newAdditionalNeeds);
        partialUpdateResponse.assertPartialUpdateBookingWithNotExistingIdWithBasicAuth(response, currentBooking);
    }
}
