package deleteTests;

import authPackage.User;
import authPackage.UserRequest;
import authPackage.UserResponse;
import deleteBooking.DeleteBookingRequest;
import deleteBooking.DeleteBookingResponse;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DeleteCookieAuthTest {
    private final DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();
    private final DeleteBookingResponse deleteBookingResponse = new DeleteBookingResponse();
    private final UserRequest userRequest = new UserRequest();
    private final UserResponse userResponse = new UserResponse();
    private static String token;

    @Before
    public void authUser() {
        User user = new User("admin", "password123");
        ValidatableResponse response = userRequest.authUser(user);
        token = userResponse.assertAuthWithCorrectUsernameAndPassword(response);
        assertNotNull("Access token should not be null", token);
        deleteBookingRequest.setToken(token);
    }

    @Test
    public void deleteExistedIdBasicAuthTest() {
        String id = "1";
        ValidatableResponse response = deleteBookingRequest.deleteBookingWithCookieAuth(id);
        deleteBookingResponse.assertDeletingExistingBookingIdCookieAuth(response);
    }

    // The test failed because it returned a 405 status code
    @Test
    public void deleteNonExistedIdBasicAuthTest() {
        String id = "100000000";
        ValidatableResponse response = deleteBookingRequest.deleteBookingWithCookieAuth(id);
        deleteBookingResponse.assertDeletingNonExistingBookingIdCookieAuth(response);
    }

    // The test failed because it returned a 405 status code
    @Test
    public void deleteNullIdBasicAuthTest() {
        String id = null;
        ValidatableResponse response = deleteBookingRequest.deleteBookingWithCookieAuth(id);
        deleteBookingResponse.assertDeletingNullBookingIdCookieAuth(response);
    }
}
