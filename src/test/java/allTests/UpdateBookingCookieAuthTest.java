package allTests;

import authPackage.User;
import authPackage.UserRequest;
import authPackage.UserResponse;
import bookingsIdPackage.BookingIdResponse;
import bookingsIdPackage.BookingsIdRequest;
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
    private final BookingsIdRequest bookingsIdRequest = new BookingsIdRequest();
    private final BookingIdResponse bookingIdResponse = new BookingIdResponse();

    private static String token;
    private NewBooking currentBooking;
    private final String id = "3";

    @Before
    public void authUser() {
        User user = new User("admin", "password123");
        ValidatableResponse response = userRequest.authUser(user);
        token = userResponse.assertAuthWithCorrectUsernameAndPassword(response);
        assertNotNull("Access token should not be null", token);
        updateBookingRequest.setToken(token);
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
    public void updateFirstnameCookieAuthTest() {
        currentBooking.setFirstname("Karla");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookie(id, currentBooking);
        updateBookingResponse.assertUpdateBookingFirstnameWithCookieAuth(response, currentBooking);
    }

    @Test
    public void updateLastnameCookieAuthTest() {
        currentBooking.setLastname("Cooper");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookie(id, currentBooking);
        updateBookingResponse.assertUpdateBookingLastnameWithCookieAuth(response, currentBooking);
    }

    @Test
    public void updateTotalPriceCookieAuthTest() {
        currentBooking.setTotalprice(200);
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookie(id, currentBooking);
        updateBookingResponse.assertUpdateBookingTotalPriceWithCookieAuth(response, currentBooking);
    }

    @Test
    public void updateDepositePaidCookieAuthTest() {
        currentBooking.setDepositpaid(true);
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookie(id, currentBooking);
        updateBookingResponse.assertUpdateBookingDepositePaidWithCookieAuth(response, currentBooking);
    }

    @Test
    public void updateCheckinDateCookieAuthTest() {
        BookingDates currentBookingDates = currentBooking.getBookingdates();
        currentBookingDates.setCheckin("2024-12-12");
        currentBooking.setBookingdates(currentBookingDates);
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookie(id, currentBooking);
        updateBookingResponse.assertUpdateBookingCheckinDateWithCookieAuth(response, currentBooking);
    }

    @Test
    public void updateCheckoutDateCookieAuthTest() {
        BookingDates currentBookingsDates = currentBooking.getBookingdates();
        currentBookingsDates.setCheckout("2024-12-30");
        currentBooking.setBookingdates(currentBookingsDates);
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookie(id, currentBooking);
        updateBookingResponse.assertUpdateBookingCheckoutDateWithCookieAuth(response, currentBooking);
    }

    @Test
    public void updateAdditionalNeedsCookieAuthTest() {
        currentBooking.setAdditionalneeds("No sounds");
        ValidatableResponse response = updateBookingRequest.updateBookingWithCookie(id, currentBooking);
        updateBookingResponse.assertUpdateBookingAdditionalNeedsWithCookieAuth(response, currentBooking);
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
