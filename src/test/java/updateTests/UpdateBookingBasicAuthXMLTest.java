package updateTests;

import bookingsIdPackage.BookingsIdRequest;
import createBooking.BookingDates;
import createBooking.NewBooking;
import createBooking.UpdateBookingRequest;
import createBooking.UpdateBookingResponse;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

public class UpdateBookingBasicAuthXMLTest {
    private final UpdateBookingRequest updateBookingRequest = new UpdateBookingRequest();
    private final UpdateBookingResponse updateBookingResponse = new UpdateBookingResponse();
    private final BookingsIdRequest bookingsIdRequest = new BookingsIdRequest();
    private NewBooking currentBooking;
    private final String id = "3";
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

    // The test failed because it returned a 400 status code
    @Test
    public void updateFirstnameBasicAuthXMLTest() {
        String xmlBody = "<booking>\n" +
                "    <firstname>Karla</firstname>\n" +
                "    <lastname>" + currentBooking.getLastname() + "</lastname>\n" +
                "    <totalprice>" + currentBooking.getTotalprice() + "</totalprice>\n" +
                "    <depositpaid>" + currentBooking.isDepositpaid() + "</depositpaid>\n" +
                "    <bookingdates>\n" +
                "        <checkin>" + currentBooking.getBookingdates().getCheckin() + "</checkin>\n" +
                "        <checkout>" + currentBooking.getBookingdates().getCheckout() + "</checkout>\n" +
                "    </bookingdates>\n" +
                "    <additionalneeds>" + currentBooking.getAdditionalneeds() + "</additionalneeds>\n" +
                "</booking>";
        ValidatableResponse response = updateBookingRequest.updateBookingWithBasicAuthXML(id, xmlBody);
        updateBookingResponse.assertUpdateBookingFirstnameWithBasicAuthXML(response, currentBooking);
    }
}
