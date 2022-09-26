package prepare_api;

import BaseUrls.HerOkuAPP;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.*;

public class Prepare10API extends HerOkuAPP {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/3
    When
        User send GET request to the url
    Then
        HTTP Status Code should be 404
    And
        Status Line should be HTTP/1.1 404 Not Found
    And
        Response body contains "Not Found"
    And
        Server is "Cowboy"
     */

    @Test
    public void get02(){
//         spec.pathParams("1", "booking", "2", "3");

//         Response response = given().spec(spec).when().get("/{1}/{2}");
//         response.prettyPrint();
//         response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
//         assertTrue(response.asString().contains("Not Found"));
//         assertEquals("Cowboy", response.getHeader("Server"));
    }
}
