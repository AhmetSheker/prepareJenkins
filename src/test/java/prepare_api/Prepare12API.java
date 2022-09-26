package prepare_api;

import BaseUrls.HerOkuAPP;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import testdata.HerOkuAPPData;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.*;

public class Prepare12API extends HerOkuAPP {
    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User send GET request to the url
    Then
        HTTP Status Code should be 200
    And
        Among the data there should be someone whose firstname is "Mary" and lastname is "Jackson"
     */

    @Test
    public void get05(){
        spec.pathParam("1", "booking").queryParams("fn", "Mary", "ln", "Jackson");
        Response response = given().spec(spec).when().get("/{1}");
        response.then().assertThat().statusCode(200);
    }

        /*
    Given
        https://restful-booker.herokuapp.com/booking/11
    When
        User send GET request to the url
    Then
        HTTP Status Code should be 200
    And
        Response format should be "application/json"
    And
        Response body should be like;
        {
        "firstname": "James",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
            },
        "additionalneeds": "Breakfast"
        }
     */

    @Test
    public void get06(){
        spec.pathParams("1", "booking", "2", "11");
        Response response = given().spec(spec).when().get("/{1}/{2}");
        response.then().assertThat().statusCode(200).contentType("application/json");
        Map<String, String> bookDate = new LinkedHashMap<>();
        bookDate.put("checkin", "2018-01-01");
        bookDate.put("checkout", "2019-01-01");
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("firstname", "James");
        responseBody.put("lastname", "Brown");
        responseBody.put("totalprice", 111);
        responseBody.put("depositpaid", true);
        responseBody.put("bookingdates", bookDate);
        responseBody.put("additionalneeds", "Breakfast");
        response.prettyPrint();
        System.out.println(responseBody);
        JsonPath jsonPath = response.jsonPath();
        assertEquals(responseBody, jsonPath.get());
    }

    /*
    Given
        https://restful-booker.herokuapp.com/booking/5
    When
        I send GET request to the url
    Then
        Response body should be like;
        {
    "firstname": "Javier",
    "lastname": "Sevilla",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
     */

    @Test
    public void get11(){
        spec.pathParams("1", "booking", "2", "42");

        HerOkuAPPData herOkuAPPData = new HerOkuAPPData();
        Map<String, String> bookdate = herOkuAPPData.bookingDate("2018-01-01", "2019-01-01");
        Map<String, Object> expected = herOkuAPPData.herOkuAppData("Javier", "Sevilla", 111, true, "Breakfast");

        Response response = given().spec(spec).when().get("/{1}/{2}");
        Map<String, Object> actual = response.as(HashMap.class);

        assertEquals(expected.get("firstname"), actual.get("firstname"));
        assertEquals(expected.get("lastname"), actual.get("lastname"));
        assertEquals(expected.get("totalprice"), actual.get("totalprice"));
        assertEquals(expected.get("depositpaid"), actual.get("depositpaid"));
        assertEquals(bookdate.get("checkin"), ((Map)actual.get("bookingdates")).get("checkin"));
        assertEquals(bookdate.get("checkout"), ((Map)actual.get("bookingdates")).get("checkout"));
        assertEquals(expected.get("additionalneeds"), actual.get("additionalneeds"));
    }
}
