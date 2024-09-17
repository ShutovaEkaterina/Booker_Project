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
    public void allBookingsGet() {
        ValidatableResponse getAllBookingsResponse = allBookingRequest.getAllBookings();
        allBookingsResponse.allBookingsSuccess(getAllBookingsResponse);
    }

    @Test
    public void allBookingsGetFilterName() {
        ValidatableResponse getAllBookingsResponse = allBookingRequest.getAllBookingsNameFilter(firstname, lastname);
        allBookingsResponse.allBookingsFilterName(getAllBookingsResponse);
    }

    @Test
    public void allBookingsGetFilterFirstname() {
        ValidatableResponse getAllBookingsResponse = allBookingRequest.getAllBookingsFirstnameFilter(firstname);
        allBookingsResponse.allBookingsFilterFirstname(getAllBookingsResponse);
    }

    @Test
    public void allBookingsGetFilterLastname() {
        ValidatableResponse getAllBookingsResponse = allBookingRequest.getAllBookingsLastnameFilter(lastname);
        allBookingsResponse.allBookingsFilterLastname(getAllBookingsResponse);
    }

    @Test
    public void allBookingsGetCheckinDate() {
        ValidatableResponse getAllBookingsResponse = allBookingRequest.getAllBookingsCheckinDate(checkin);
        allBookingsResponse.allBookingsCheckinDate(getAllBookingsResponse);
    }

    @Test
    public void allBookingsGetCheckoutDate() {
        ValidatableResponse getAllBookingsResponse = allBookingRequest.getAllBookingsCheckoutDate(checkout);
        allBookingsResponse.allBookingsCheckoutDate(getAllBookingsResponse);
    }

    @Test
    public void allBookingsGetFilterDate() {
        ValidatableResponse getAllBookingsResponse = allBookingRequest.getAllBookingsDateFilter(checkin, checkout);
        allBookingsResponse.allBookingsFilterDate(getAllBookingsResponse);
    }

   // Тест упадет, так как приходит пустой массив и статус код 200 ОК
    @Test
    public void allBookingsGetFilterDateWrong() {
        ValidatableResponse getAllBookingsResponse = allBookingRequest.getAllBookingsDateFilterWrong("2017-03-13", checkout);
        allBookingsResponse.allBookingsFilterDateWrong(getAllBookingsResponse);
    }
}
