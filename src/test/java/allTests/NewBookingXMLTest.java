package allTests;

import createBooking.NewBookingRequest;
import createBooking.NewBookingResponse;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class NewBookingXMLTest {
    private final NewBookingRequest newBookingRequest = new NewBookingRequest();
    private final NewBookingResponse newBookingResponse = new NewBookingResponse();

    @Test
    public void createNewBookingWithAllFieldsXMLTest() {
        String xmlBody = "<booking>\n" +
                "    <firstname>Amanda</firstname>\n" +
                "    <lastname>Smith</lastname>\n" +
                "    <totalprice>344</totalprice>\n" +
                "    <depositpaid>true</depositpaid>\n" +
                "    <bookingdates>\n" +
                "        <checkin>2024-09-12</checkin>\n" +
                "        <checkout>2024-09-15</checkout>\n" +
                "    </bookingdates>\n" +
                "    <additionalneeds>Nothing needed</additionalneeds>\n" +
                "</booking>";

        // The test failed because it returned a 500 status code
        ValidatableResponse response = newBookingRequest.createBookingXML(xmlBody);
        newBookingResponse.assertSuccessCreatingBookingWithAllFieldsXML(response);
    }
}
