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

public class PartialUpdateCookieAuthXMLTest {
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

    // The test failed because it returned current booking name
    @Test
    public void partialUpdateFirstnameCookieAuthXMLTest() {
        String xmlBody = "<booking>\n" +
                "    <firstname>Karla</firstname>\n" +
                "</booking>";
        ValidatableResponse response = partialUpdateRequest.partialUpdateBookingFirstnameWithCookieXML(id, xmlBody);
        partialUpdateResponse.assertPartialUpdateBookingFirstnameWithCookieAuthXML(response, currentBooking);
    }
}
