package configPackage;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
//название класса
public class Config {
    protected static final String BASE_URL = "https://restful-booker.herokuapp.com";
    protected static final String BOOKING_PATH = "/booking";
    public RequestSpecification spec() {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL);
    }
}
