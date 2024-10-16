package partialUpdateTests;

import authPackage.User;
import authPackage.UserRequest;
import authPackage.UserResponse;
import bookingsIdPackage.BookingsIdRequest;
import createBooking.BookingDates;
import createBooking.NewBooking;
import createBooking.PartialUpdateRequest;
import createBooking.PartialUpdateResponse;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PartialUpdateCookieAuth {
    private final PartialUpdateRequest partialUpdateRequest = new PartialUpdateRequest();
    private final PartialUpdateResponse partialUpdateResponse = new PartialUpdateResponse();
    private final UserRequest userRequest = new UserRequest();
    private final UserResponse userResponse = new UserResponse();
    private final BookingsIdRequest bookingsIdRequest = new BookingsIdRequest();

    private static String token;
    private NewBooking currentBooking;
    private final String id = "2";

    @Before
    public void authUser() {
        User user = new User("admin", "password123");
        ValidatableResponse response = userRequest.authUser(user);
        token = userResponse.assertAuthWithCorrectUsernameAndPassword(response);
        assertNotNull("Access token should not be null", token);
        partialUpdateRequest.setToken(token);
    }

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
    public void partialUpdateFirstnameCookieAuthTest() {
        String newFirstname = "Karla";
        currentBooking.setFirstname(newFirstname);
        ValidatableResponse response = partialUpdateRequest.partialUpdateBookingFirstnameWithCookie(id, newFirstname);
        partialUpdateResponse.assertPartialUpdateBookingFirstnameWithCookieAuth(response, currentBooking);
    }

    @Test
    public void partialUpdateLastnameCookieAuthTest() {
        String newLastname = "Cooper";
        currentBooking.setLastname(newLastname);
        ValidatableResponse response = partialUpdateRequest.partialUpdateBookingLastnameWithCookie(id, newLastname);
        partialUpdateResponse.assertPartialUpdateBookingLastnameWithCookieAuth(response, currentBooking);
    }

    @Test
    public void partialUpdateTotalPriceCookieAuthTest() {
        int newTotalPrice = 200;
        currentBooking.setTotalprice(newTotalPrice);
        ValidatableResponse response = partialUpdateRequest.partialUpdateBookingTotalPriceWithCookieAuth(id, newTotalPrice);
        partialUpdateResponse.assertPartialUpdateBookingTotalPriceWithCookieAuth(response, currentBooking);
    }

    @Test
    public void partialUpdateDepositPaidCookieAuthTest() {
        boolean newDepositPaid = true;
        currentBooking.setDepositpaid(newDepositPaid);
        ValidatableResponse response = partialUpdateRequest.partialUpdateBookingDepositPaidWithCookieAuth(id, newDepositPaid);
        partialUpdateResponse.assertPartialUpdateBookingDepositPaidWithCookieAuth(response, currentBooking);
    }

    @Test
    public void partialUpdateCheckinDateCookieAuthTest() {
        BookingDates currentBookingsDates = currentBooking.getBookingdates();
        String newCheckinDate = "2024-12-12";
        currentBookingsDates.setCheckin(newCheckinDate);
        ValidatableResponse response = partialUpdateRequest.partialUpdateBookingCheckinDateWithCookieAuth(id, newCheckinDate);
        partialUpdateResponse.assertPartialUpdateBookingCheckinDateWithCookieAuth(response, currentBooking);
    }

    @Test
    public void partialUpdateCheckoutDateCookieAuthTest() {
        BookingDates currentBookingsDates = currentBooking.getBookingdates();
        String newCheckoutDate = "2024-12-30";
        currentBookingsDates.setCheckout(newCheckoutDate);
        ValidatableResponse response = partialUpdateRequest.partialUpdateBookingCheckoutDateWithCookieAuth(id, newCheckoutDate);
        partialUpdateResponse.assertPartialUpdateBookingCheckoutDateWithCookieAuth(response, currentBooking);
    }

    @Test
    public void partialUpdateAdditionalNeedsCookieAuthTest() {
        String newAdditionalNeeds = "No sounds";
        currentBooking.setAdditionalneeds(newAdditionalNeeds);
        ValidatableResponse response = partialUpdateRequest.partialUpdateBookingAdditionalNeedsWithCookieAuth(id, newAdditionalNeeds);
        partialUpdateResponse.assertPartialUpdateBookingAdditionalNeedsWithCookieAuth(response, currentBooking);
    }

    // The test failed because it returned a 405 status code
    @Test
    public void partialUpdateNotExistingIdCookieAuthTest() {
        String id = "30000000";
        String newAdditionalNeeds = "No sounds";
        currentBooking.setAdditionalneeds(newAdditionalNeeds);
        ValidatableResponse response = partialUpdateRequest.partialUpdateBookingAdditionalNeedsAndIncorrectIdWithCookieAuth(id, newAdditionalNeeds);
        partialUpdateResponse.assertPartialUpdateBookingWithNotExistingIdWithCookieAuth(response, currentBooking);
    }
}
