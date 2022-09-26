package prepare_api;

import BaseUrls.PlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import testdata.PlaceHolderData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.*;

public class Prepare11API extends PlaceHolder {
    /*
    Given
        https://jsonplaceholder.typicode.com/todos/23
    When
        User send GET request to the url
    Then
        HTTP Status Code should be 200
    And
        Response format should be "application/json"
    And
        "title" is "et itaque necessitatibus maxime molestiae qui quas velit"
    And
        "completed" is false
    And
        "userId" is 2
     */

    @Test
    public void get03(){
        spec.pathParams("1", "todos", "2", "23");
        Response response = given().spec(spec).when().get("/{1}/{2}");
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed", equalTo(false)).
                body("userId", equalTo(2));
    }

    /*
    Given
        https://jsonplaceholder.typicode.com/todos
    When
        User send GET request to the url
    And
        Accepted type is "application/json"
    Then
        HTTP Status Code should be 200
    And
        Response format should be "application/json"
    And
        There should be 200 todos
    And
        "quis eius est sint explicabo" should be one of the todos
    And
        2, 7 and 9 should be among the userIds
     */

    @Test
    public void get04(){
        spec.pathParams("1", "todos");
        Response response = given().spec(spec).accept(ContentType.JSON).when().get("/{1}");
        response.
                then().
                statusCode(200).
                contentType("application/json").
                body("id", hasSize(200)).
                body("title", hasItem("quis eius est sint explicabo")).
                body("userId", hasItems(2, 7, 9));
    }

    /*
    Given
        https://jsonplaceholder.typicode.com/todos
    When
        I send GET request to the url
    Then
        1-HTTP Status Code should be 200
        2-Print all ids greater than 190 on the console
          Assert that there are 10 ids greater than 190
        3-Print all userIds less than 5 on the console
          Assert that maximum userId less than 5 is 80
        4-Print all titles whose ids are less than 5
          Assert that "delectus aut autem" is one of the titles whose id is less than 5
     */

    @Test
    public void get07(){
        spec.pathParam("1", "todos");
        Response response = given().spec(spec).when().get("/{1}");
        response.then().assertThat().statusCode(200);
        JsonPath jsonPath = response.jsonPath();
        List<Integer> ids = jsonPath.getList("findAll{it.id > 190}.id");
        assertEquals(10, ids.size());
        List<Integer> userIds = jsonPath.getList("findAll{it.userId < 5}.userId");
        assertEquals(80, userIds.size());
        List<String> titles = jsonPath.getList("findAll{it.id < 5}.title");
        assertTrue(titles.contains("delectus aut autem"));
    }

    /*
    De-serialization: To convert JSON Data to Java Object
    Serialization: To convert Java Object to JSON Data

    To do De-serialization and  Serialization we can use the followings
    1-Gson: Google Created
    2-Object Mapper: More popular

     */

    /*
    Given
        https://jsonplaceholder.typicode.com/todos/2
    When
        I send GET request to the url
    Then
        HTTP Status Code should be 200
    And
        "completed" is false
    And
        "userId" is 1
    And
        "title" is "quis ut nam facilis et officia qui"
    And
        header "Via" is "1.1 Vegur"
    And
        header "Server" is "cloudflare"
        {
        "userId": 1,
        "id": 2,
        "title": "quis ut nam facilis et officia qui",
        "completed": false
        }
     */

    @Test
    public void get09(){
        spec.pathParams("1", "todos", "2", "2");
        Response response = given().spec(spec).accept(ContentType.JSON).when().get("/{1}/{2}");
        response.
                then().
                assertThat().
                statusCode(200).
                body("completed", equalTo(false)).
                body("userId", equalTo(1)).
                body("title", equalTo("quis ut nam facilis et officia qui"));

        assertEquals("1.1 vegur", response.getHeader("Via"));
        assertEquals("cloudflare", response.getHeader("Server"));
    }

    @Test
    public void get10(){
        spec.pathParams("1", "todos", "2", "2");

        Map<String, Object> expected = new HashMap<>();
        expected.put("userId", 1);
        expected.put("title", "quis ut nam facilis et officia qui");
        expected.put("completed", false);
        expected.put("Via", "1.1 vegur");
        expected.put("Server", "cloudflare");
        expected.put("StatusCode", 200);

        Response response = given().spec(spec).when().get("/{1}/{2}");
        response.prettyPrint();
        Map<String, Object> actual = response.as(HashMap.class);

        assertEquals(expected.get("userId"), actual.get("userId"));
        assertEquals(expected.get("title"), actual.get("title"));
        assertEquals(expected.get("completed"), actual.get("completed"));
        assertEquals(expected.get("Via"), response.getHeader("Via"));
        assertEquals(expected.get("Server"), response.getHeader("Server"));
        assertEquals(expected.get("StatusCode"), response.getStatusCode());

    }

    @Test
    public void get11(){
        spec.pathParams("1", "todos", "2", "2");

        PlaceHolderData placeHolderData = new PlaceHolderData();
        Map<String, Object> expected = placeHolderData.testData(1, "quis ut nam facilis et officia qui", false);

        Response response = given().spec(spec).when().get("/{1}/{2}");
        Map<String, Object> actual = response.as(HashMap.class);

        assertEquals(expected.get("userId"), actual.get("userId"));
        assertEquals(expected.get("title"), actual.get("title"));
        assertEquals(expected.get("completed"), actual.get("completed"));
    }
}
