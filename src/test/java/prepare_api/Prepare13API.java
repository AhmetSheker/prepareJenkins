package prepare_api;

import BaseUrls.Gorest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import testdata.GorestData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.*;

public class Prepare13API extends Gorest {

    /*
    Given
        https://gorest.co.in/public/v1/users/101
    When
        I send GET request to the url
    Then
        StatusCode sould be 200
    And
        Response body should be like;
        {
    "meta": null,
    "data": {
        "id": 101,
        "name": "Chiranjeeve Tandon",
        "email": "chiranjeeve_tandon@williamson-koch.biz",
        "gender": "male",
        "status": "inactive"
    }
}
     */

    @Test
    public void get12(){
        spec.pathParams("1", "users", "2", "101");

        GorestData gorestData = new GorestData();
        Map<String, Object> inner = gorestData.inner(101, "Chiranjeeve Tandon", "chiranjeeve_tandon@williamson-koch.biz", "male", "inactive");
        Map<String, Object> expected = new HashMap<>();
        expected.put("meta", null);
        expected.put("data", inner);

        Response response = given().spec(spec).when().get("/{1}/{2}");
        System.out.println(expected);
        response.prettyPrint();
        Map<String, Object> actual = response.as(HashMap.class);

        assertEquals(expected, actual);
    }

    /*
    Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Indra Ganaka", "Sarada Mehrotra", "Jagathi Chopra" are among the users
        And
            The female users are more than male users
     */

    @Test
    public void get13(){
        spec.pathParam("1", "users");

        Response response = given().spec(spec).when().get("/{1}");

        Map<String, Object> actual = response.as(HashMap.class);

        response.
                then().
                assertThat().
                body("data.id", hasSize(10)).
                body("data.status", hasItem("active")).
                body("data.name", hasItems("Msgr. Chitraksh Rana", "Bhoopat Bharadwaj I", "Kamlesh Patel")).
                body("meta.pagination.links.current", equalTo("https://gorest.co.in/public/v1/users?page=1"));

        JsonPath jsonPath = response.jsonPath();
        List<String> female = jsonPath.getList("data.findAll{it.gender='female'}.gender");
        List<String> male = jsonPath.getList("data.findAll{it.gender='male'}.gender");
        boolean isBigger = female.size() > male.size();
        assertFalse(isBigger);


    }
}
