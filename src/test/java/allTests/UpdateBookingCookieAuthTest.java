package allTests;

import authPackage.User;
import authPackage.UserRequest;
import authPackage.UserResponse;
import createBooking.BookingDates;
import createBooking.NewBooking;
import createBooking.UpdateBookingRequest;
import createBooking.UpdateBookingResponse;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class UpdateBookingCookieAuthTest {
    private final UpdateBookingRequest updateBookingRequest = new UpdateBookingRequest();
    private final UpdateBookingResponse updateBookingResponse = new UpdateBookingResponse();
    private final UserRequest userRequest = new UserRequest();
    private final UserResponse userResponse = new UserResponse();

    private static String token;

    @Before
    public void authUser() {
        User user = new User("admin", "password123");
        ValidatableResponse response = userRequest.authUser(user);
        token = userResponse.assertAuthWithCorrectUsernameAndPassword(response);
        assertNotNull("Access token should not be null", token);
        updateBookingRequest.setToken(token);
    }

    @Test
    public void updateFirstnameCookieAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2018-10-18", "2024-06-21");
        NewBooking newBooking = new NewBooking("Karla", "Jones", 576, false, bookingDates,"Breakfast");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookie(id, newBooking);
        updateBookingResponse.assertUpdateBookingFirstnameWithCookieAuth(response);
    }

    @Test
    public void updateLastnameCookieAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2018-10-18", "2024-06-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 576, false, bookingDates,"Breakfast");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookie(id, newBooking);
        updateBookingResponse.assertUpdateBookingLastnameWithCookieAuth(response);
    }

    @Test
    public void updateTotalPriceCookieAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2018-10-18", "2024-06-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, false, bookingDates,"Breakfast");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookie(id, newBooking);
        updateBookingResponse.assertUpdateBookingTotalPriceWithCookieAuth(response);
    }

    @Test
    public void updateDepositePaidCookieAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2018-10-18", "2024-06-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, true, bookingDates,"Breakfast");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookie(id, newBooking);
        updateBookingResponse.assertUpdateBookingDepositePaidWithCookieAuth(response);
    }

    @Test
    public void updateCheckinDateCookieAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2024-12-12", "2024-12-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, true, bookingDates,"Breakfast");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookie(id, newBooking);
        updateBookingResponse.assertUpdateBookingCheckinDateWithCookieAuth(response);
    }

    @Test
    public void updateCheckoutDateCookieAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2024-12-12", "2024-12-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, true, bookingDates,"Breakfast");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookie(id, newBooking);
        updateBookingResponse.assertUpdateBookingCheckoutDateWithCookieAuth(response);
    }

    @Test
    public void updateAdditionalNeedsCookieAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2024-12-12", "2024-12-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, true, bookingDates,"No sounds");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookie(id, newBooking);
        updateBookingResponse.assertUpdateBookingAdditionalNeedsWithCookieAuth(response);
    }

    // Тест упадет, так как приходит код 405
    @Test
    public void updateNotExistingIdCookieAuthTest() {
        String id = "3000000000";
        BookingDates bookingDates = new BookingDates("2024-12-12", "2024-12-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, true, bookingDates,"No sounds");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookie(id, newBooking);
        updateBookingResponse.assertUpdateBookingWithNotExistingIdWithCookieAuth(response);
    }
}
