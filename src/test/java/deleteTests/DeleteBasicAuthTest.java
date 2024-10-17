package deleteTests;

import deleteBooking.DeleteBookingRequest;
import deleteBooking.DeleteBookingResponse;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class DeleteBasicAuthTest {
    private final DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();
    private final DeleteBookingResponse deleteBookingResponse = new DeleteBookingResponse();

    @Test
    public void deleteExistedIdBasicAuthTest() {
        String id = "1";
        ValidatableResponse response = deleteBookingRequest.deleteBookingWithBasicAuth(id);
        deleteBookingResponse.assertDeletingExistingBookingIdBasicAuth(response);
    }

    // The test failed because it returned a 405 status code
    @Test
    public void deleteNonExistedIdBasicAuthTest() {
        String id = "100000000";
        ValidatableResponse response = deleteBookingRequest.deleteBookingWithBasicAuth(id);
        deleteBookingResponse.assertDeletingNonExistingBookingIdBasicAuth(response);
    }

    // The test failed because it returned a 405 status code
    @Test
    public void deleteNullIdBasicAuthTest() {
        String id = null;
        ValidatableResponse response = deleteBookingRequest.deleteBookingWithBasicAuth(id);
        deleteBookingResponse.assertDeletingNullBookingIdBasicAuth(response);
    }
}
