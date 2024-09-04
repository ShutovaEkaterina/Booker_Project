package authTests;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import pomAllBookings.AllBookingRequest;
import pomAllBookings.AllBookingsResponse;

import java.util.Date;

public class AllBookingsTest {
    private final AllBookingRequest allBookingRequest = new AllBookingRequest();
    private final AllBookingsResponse allBookingsResponse = new AllBookingsResponse();
    @Test
    public void allBookingsGet() {
        ValidatableResponse getAllBookingsResponse = allBookingRequest.getAllBookings();
        allBookingsResponse.allBookingsSuccess(getAllBookingsResponse);
    }
    @Test
    public void allBookingsGetFilterName() {
        String firstname = "sally";
        String lastname = "brown";
        ValidatableResponse getAllBookingsResponse = allBookingRequest.getAllBookingsNameFilter(firstname, lastname);
        allBookingsResponse.allBookingsFilterName(getAllBookingsResponse);
    }
    @Test
    public void allBookingsGetFilterFirstname() {
        String firstname = "sally";
        ValidatableResponse getAllBookingsResponse = allBookingRequest.getAllBookingsFirstnameFilter(firstname);
        allBookingsResponse.allBookingsFilterFirstname(getAllBookingsResponse);
    }
    @Test
    public void allBookingsGetFilterLastname() {
        String lastname = "brown";
        ValidatableResponse getAllBookingsResponse = allBookingRequest.getAllBookingsLastnameFilter(lastname);
        allBookingsResponse.allBookingsFilterLastname(getAllBookingsResponse);
    }
    @Test
    public void allBookingsGetCheckinDate() {
        String checkin = "2013-03-13";
        ValidatableResponse getAllBookingsResponse = allBookingRequest.getAllBookingsCheckinDate(checkin);
        allBookingsResponse.allBookingsCheckinDate(getAllBookingsResponse);
    }
    @Test
    public void allBookingsGetCheckoutDate() {
        String checkout = "2014-05-21";
        ValidatableResponse getAllBookingsResponse = allBookingRequest.getAllBookingsCheckoutDate(checkout);
        allBookingsResponse.allBookingsCheckoutDate(getAllBookingsResponse);
    }
    @Test
    public void allBookingsGetFilterDate() {
        String checkin = "2013-03-13";
        String checkout = "2014-05-21";
        ValidatableResponse getAllBookingsResponse = allBookingRequest.getAllBookingsDateFilter(checkin, checkout);
        allBookingsResponse.allBookingsFilterDate(getAllBookingsResponse);
    }
   // Тест упадет, так как приходит пустой массив и статус код 200 ОК
    @Test
    public void allBookingsGetFilterDateWrong() {
        String checkin = "2017-03-13";
        String checkout = "2014-05-21";
        ValidatableResponse getAllBookingsResponse = allBookingRequest.getAllBookingsDateFilterWrong(checkin, checkout);
        allBookingsResponse.allBookingsFilterDateWrong(getAllBookingsResponse);
    }
}
