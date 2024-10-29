package allTests;

import createBooking.BookingDates;
import createBooking.NewBooking;
import createBooking.NewBookingRequest;
import createBooking.NewBookingResponse;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class NewBookingTest {
    private final NewBookingRequest newBookingRequest = new NewBookingRequest();
    private final NewBookingResponse newBookingResponse = new NewBookingResponse();

    @Test
    public void createNewBookingWithAllFieldsTest() {
        BookingDates bookingdates = new BookingDates("2024-09-12", "2024-09-15");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 344, true, bookingdates, "Nothing needed");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithAllFields(response);
    }

    @Test
    public void createNewBookingWithEmptyAdditionalNeedsFieldTest() {
        BookingDates bookingdates = new BookingDates("2024-09-12", "2024-09-15");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 344, true, bookingdates, "");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithEmptyAdditionalNeedsField(response);
    }

    @Test
    public void createNewBookingWithNullAdditionalNeedsFieldTest() {
        BookingDates bookingdates = new BookingDates("2024-09-12", "2024-09-15");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 344, true, bookingdates, null);

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithNullAdditionalNeedsField(response);
    }

    // The test failed because the response contained an incorrect date format, and the status code was 200.
    @Test
    public void createNewBookingWithEmptyCheckoutDateFieldTest() {
        BookingDates bookingdates = new BookingDates("2024-09-12", "");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 344, true, bookingdates, "Something");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithEmptyCheckoutDateField(response);
    }

    // The test failed because the response contained an incorrect date format, and the status code was 200.
    @Test
    public void createNewBookingWithEmptyCheckinDateFieldTest() {
        BookingDates bookingdates = new BookingDates("", "2024-09-12");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 344, true, bookingdates, "Something");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithEmptyCheckinDateField(response);
    }

    // The test failed because the response contained an incorrect date format, and the status code was 200.
    @Test
    public void createNewBookingWithIncorrectFormatDatesTest() {
        BookingDates bookingdates = new BookingDates("20-09-2024", "23-09-2024");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 344, true, bookingdates, "Something");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithIncorrectFormatDates(response);
    }

    // The test failed because it returned a 200 status code
    @Test
    public void createNewBookingWithWrongDatesFieldsTest() {
        BookingDates bookingdates = new BookingDates("2024-09-20", "2024-09-02");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 344, true, bookingdates, "Something");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithWrongDatesFields(response);
    }

    // The test failed because it returned a 200 status code
    @Test
    public void createNewBookingWithDatesInThePastTest() {
        BookingDates bookingdates = new BookingDates("2020-03-20", "2020-03-30");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 344, true, bookingdates, "Something");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithDatesInThePast(response);
    }

    @Test
    public void createNewBookingWithFalseDepositPaidTest() {
        BookingDates bookingdates = new BookingDates("2024-10-20", "2024-10-30");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 0, false, bookingdates, "Something");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithFalseDepositPaid(response);
    }

    // The test failed because it returned a 200 status code
    @Test
    public void createNewBookingWithZeroTotalPriceTest() {
        BookingDates bookingdates = new BookingDates("2024-10-20", "2024-10-30");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 0, false, bookingdates, "Something");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithZeroTotalPrice(response);
    }

    // The test failed because it returned a 200 status code
    @Test
    public void createNewBookingWithEmptyFirstnameTest() {
        BookingDates bookingdates = new BookingDates("2024-10-20", "2024-10-30");
        NewBooking newBooking = new NewBooking("", "Smith", 12, false, bookingdates, "Something");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithEmptyFirstname(response);
    }

    // The test failed because it returned a 200 status code
    @Test
    public void createNewBookingWithEmptyLastnameTest() {
        BookingDates bookingdates = new BookingDates("2024-10-20", "2024-10-30");
        NewBooking newBooking = new NewBooking("Amanda", "", 12, false, bookingdates, "Something");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithEmptyLastname(response);
    }
}
