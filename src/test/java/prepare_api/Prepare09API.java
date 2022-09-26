package prepare_api;

import BaseUrls.HerOkuAPP;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Prepare09API extends HerOkuAPP {

        /*
        Given
            https://restful-booker.herokuapp.com/booking/10
        When
            User send GET request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSon
        And
            Status Line should be HTTP/1.1 200 OK
         */

    @Test
    public void get01(){
        spec.pathParams("1", "booking", "2", "10");

        Response response = given().spec(spec).when().get("/{1}/{2}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

    }


}
