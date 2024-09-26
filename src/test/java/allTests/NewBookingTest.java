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
    public void testCreateNewBookingWithAllFields() {
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
    public void testCreateNewBookingWithEmptyAdditionalNeedsField() {
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
    public void testCreateNewBookingWithNullAdditionalNeedsField() {
        BookingDates bookingdates = new BookingDates("2024-09-12", "2024-09-15");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 344, true, bookingdates, null);

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithNullAdditionalNeedsField(response);
    }

    // Тест упадет, так как в ответе приходит некорректный формат даты, и статус код 200
    @Test
    public void testCreateNewBookingWithEmptyCheckoutDateField() {
        BookingDates bookingdates = new BookingDates("2024-09-12", "");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 344, true, bookingdates, "Something");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithEmptyCheckoutDateField(response);
    }

    // Тест упадет, так как в ответе приходит некорректный формат даты, и статус код 200
    @Test
    public void testCreateNewBookingWithEmptyCheckinDateField() {
        BookingDates bookingdates = new BookingDates("", "2024-09-12");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 344, true, bookingdates, "Something");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithEmptyCheckinDateField(response);
    }

    // Тест упадет, так как в ответе приходит некорректный формат даты, и статус код 200
    @Test
    public void testCreateNewBookingWithIncorrectFormatDates() {
        BookingDates bookingdates = new BookingDates("20-09-2024", "23-09-2024");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 344, true, bookingdates, "Something");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithIncorrectFormatDates(response);
    }

    // Тест упадет, так как в ответе приходит статус код 200
    @Test
    public void testCreateNewBookingWithWrongDatesFields() {
        BookingDates bookingdates = new BookingDates("2024-09-20", "2024-09-02");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 344, true, bookingdates, "Something");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithWrongDatesFields(response);
    }

    // Тест упадет, так как в ответе приходит статус код 200
    @Test
    public void testCreateNewBookingWithDatesInThePast() {
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
    public void testCreateNewBookingWithFalseDepositPaid() {
        BookingDates bookingdates = new BookingDates("2024-10-20", "2024-10-30");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 0, false, bookingdates, "Something");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithFalseDepositPaid(response);
    }

    // Тест упадет, так как в ответе приходит статус код 200
    @Test
    public void testCreateNewBookingWithZeroTotalPrice() {
        BookingDates bookingdates = new BookingDates("2024-10-20", "2024-10-30");
        NewBooking newBooking = new NewBooking("Amanda", "Smith", 0, false, bookingdates, "Something");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithZeroTotalPrice(response);
    }

    // Тест упадет, так как в ответе приходит статус код 200
    @Test
    public void testCreateNewBookingWithEmptyFirstname() {
        BookingDates bookingdates = new BookingDates("2024-10-20", "2024-10-30");
        NewBooking newBooking = new NewBooking("", "Smith", 12, false, bookingdates, "Something");

        // log newBooking
        System.out.println(newBooking);
        ValidatableResponse response = newBookingRequest.createBooking(newBooking);

        // log response
        System.out.println(response);
        newBookingResponse.assertSuccessCreatingBookingWithEmptyFirstname(response);
    }

    // Тест упадет, так как в ответе приходит статус код 200
    @Test
    public void testCreateNewBookingWithEmptyLastname() {
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
