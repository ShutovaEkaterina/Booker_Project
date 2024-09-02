package basicStaff;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Basic {
    protected static final String BASE_URL = "https://restful-booker.herokuapp.com";
    //private static final String COMMON_PATH = "/api";
    public RequestSpecification spec() {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                //.basePath(COMMON_PATH)
                ;
    }
}
