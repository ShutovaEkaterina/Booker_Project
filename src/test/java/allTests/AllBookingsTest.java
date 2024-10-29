package allTests;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import allBookingsPackage.AllBookingRequest;
import allBookingsPackage.AllBookingsResponse;

public class AllBookingsTest {
    String firstname = "sally";
    String lastname = "brown";
    String checkin = "2013-03-13";
    String checkout = "2014-05-21";
    private final AllBookingRequest allBookingRequest = new AllBookingRequest();
    private final AllBookingsResponse allBookingsResponse = new AllBookingsResponse();

    @Test
    public void getAllBookingsWithoutParamsTest() {
        ValidatableResponse response = allBookingRequest.getAllBookingsWithoutParams();
        allBookingsResponse.assertAllBookingsWithoutParams(response);
    }

    @Test
    public void getAllBookingsByNotExistingUserNameFilterTest() {
        ValidatableResponse response = allBookingRequest.getAllBookingsByNameFilter(firstname, lastname);
        allBookingsResponse.assertAllBookingsEmptyByNoneExistingUser(response);
    }

    @Test
    public void getAllBookingsByExistingUserNameFilterTest() {
        ValidatableResponse response = allBookingRequest.getAllBookingsByNameFilter("Jim", "Ericsson");
        allBookingsResponse.assertAllBookingsByExistingUser(response);
    }

    @Test
    public void getAllBookingsByFirstnameFilterTest() {
        ValidatableResponse response = allBookingRequest.getAllBookingsByFirstnameFilter(firstname);
        allBookingsResponse.assertAllBookingsByFirstnameFilter(response);
    }

    @Test
    public void getAllBookingsByLastnameFilterTest() {
        ValidatableResponse response = allBookingRequest.getAllBookingsByLastnameFilter(lastname);
        allBookingsResponse.assertAllBookingsByLastnameFilter(response);
    }

    @Test
    public void getAllBookingsByCheckinDateFilterTest() {
        ValidatableResponse response = allBookingRequest.getAllBookingsByCheckInDateFilter(checkin);
        allBookingsResponse.assertAllBookingsByCheckinFilter(response);
    }

    @Test
    public void getAllBookingsByCheckoutDateFilterTest() {
        ValidatableResponse response = allBookingRequest.getAllBookingsByCheckoutDateFilter(checkout);
        allBookingsResponse.assertAllBookingsByCheckoutFilter(response);
    }

    @Test
    public void getAllBookingsByDatesFilterTest() {
        ValidatableResponse response = allBookingRequest.getAllBookingsByDatesFilter(checkin, checkout);
        allBookingsResponse.assertAllBookingsByDates(response);
    }

    //  The test failed because an empty array is returned along with a 200 OK status code.
    @Test
    public void getAllBookingsByDateWrongFilterTest() {
        ValidatableResponse response = allBookingRequest.getAllBookingsByWrongDateFilter("2017-03-13", checkout);
        allBookingsResponse.assertAllBookingsByWrongDateFilter(response);
    }
}
