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

public class UpdateBookingWithAllAuthHeadersTest {
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
    public void updateFirstnameCookieAndBasicAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2018-10-18", "2024-06-21");
        NewBooking newBooking = new NewBooking("Karla", "Jones", 576, false, bookingDates,"Breakfast");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookieAndBasicAuth(id, newBooking);
        updateBookingResponse.assertUpdateBookingFirstnameWithCookieAndBasicAuth(response);
    }

    @Test
    public void updateLastnameCookieAndBasicAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2018-10-18", "2024-06-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 576, false, bookingDates,"Breakfast");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookieAndBasicAuth(id, newBooking);
        updateBookingResponse.assertUpdateBookingLastnameWithCookieAndBasicAuth(response);
    }

    @Test
    public void updateTotalPriceCookieAndBasicAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2018-10-18", "2024-06-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, false, bookingDates,"Breakfast");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookieAndBasicAuth(id, newBooking);
        updateBookingResponse.assertUpdateBookingTotalPriceWithCookieAndBasicAuth(response);
    }

    @Test
    public void updateDepositePaidCookieAndBasicAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2018-10-18", "2024-06-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, true, bookingDates,"Breakfast");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookieAndBasicAuth(id, newBooking);
        updateBookingResponse.assertUpdateBookingDepositePaidWithCookieAndBasicAuth(response);
    }

    @Test
    public void updateCheckinDateCookieAndBasicAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2024-12-12", "2024-12-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, true, bookingDates,"Breakfast");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookieAndBasicAuth(id, newBooking);
        updateBookingResponse.assertUpdateBookingCheckinDateWithCookieAndBasicAuth(response);
    }

    @Test
    public void updateCheckoutDateCookieAndBasicAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2024-12-12", "2024-12-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, true, bookingDates,"Breakfast");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookieAndBasicAuth(id, newBooking);
        updateBookingResponse.assertUpdateBookingCheckoutDateWithCookieAndBasicAuth(response);
    }

    @Test
    public void updateAdditionalNeedsCookieAndBasicAuthTest() {
        String id = "3";
        BookingDates bookingDates = new BookingDates("2024-12-12", "2024-12-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, true, bookingDates,"No sounds");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookieAndBasicAuth(id, newBooking);
        updateBookingResponse.assertUpdateBookingAdditionalNeedsWithCookieAndBasicAuth(response);
    }

    // Тест упадет, так как приходит код 405
    @Test
    public void updateNotExistingIdCookieAndBasicAuthTest() {
        String id = "3000000000";
        BookingDates bookingDates = new BookingDates("2024-12-12", "2024-12-21");
        NewBooking newBooking = new NewBooking("Mary", "Cooper", 200, true, bookingDates,"No sounds");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookieAndBasicAuth(id, newBooking);
        updateBookingResponse.assertUpdateBookingWithNotExistingIdWithCookieAndBasicAuth(response);
    }
}
