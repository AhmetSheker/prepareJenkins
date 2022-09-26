package prepare_api;

import BaseUrls.HerOkuAPP;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatePojo;
import pojos.HerOkuPojo;
import pojos.HerOkuResponsePojo;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class Prepare14API extends HerOkuAPP {
    /*
    Given
            https://restful-booker.herokuapp.com/booking/101
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like
 		    {
    "firstname": "Taylor",
    "lastname": "Martin",
    "totalprice": 216,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2022-11-29",
        "checkout": "2022-12-04"
    },
    "additionalneeds": "breakfast"
}
     */

    @Test
    public void get14(){
//         spec.pathParams("1", "booking", "2", "101");

//         BookingDatePojo bookingDatePojo = new BookingDatePojo("2022-11-29", "2022-12-04");
//         HerOkuPojo expected = new HerOkuPojo("Taylor", "Martin", 216, true, bookingDatePojo, "breakfast");

//         Response response = given().spec(spec).when().get("/{1}/{2}");

//         HerOkuResponsePojo actual = response.as(HerOkuResponsePojo.class);

//         assertEquals(expected.getFirstname(), actual.getBooking().getFirstname());

    }
}
