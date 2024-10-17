package deleteTests;

import deleteBooking.DeleteBookingRequest;
import deleteBooking.DeleteBookingResponse;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class DeleteWithoutAuthHeaderTest {
    private final DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();
    private final DeleteBookingResponse deleteBookingResponse = new DeleteBookingResponse();

    @Test
    public void deleteExistedIdBasicAuthTest() {
        String id = "1";
        ValidatableResponse response = deleteBookingRequest.deleteBookingWithoutBasicAuthAndCookie(id);
        deleteBookingResponse.assertDeletingBookingWithoutBasicAuthAndCookie(response);
    }
}
