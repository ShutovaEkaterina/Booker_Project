package basicStaff;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
//название класса
public class Basic {
    protected static final String BASE_URL = "https://restful-booker.herokuapp.com";
    public RequestSpecification spec() {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL);
    }
}
