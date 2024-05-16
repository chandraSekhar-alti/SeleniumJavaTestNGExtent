package API.Tests.CrudOperations;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class GETRequestsTest {

    @BeforeTest
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000/";
    }

    @Test(priority = 0, groups = {"smoke"}, description = "Fetches the list of posts from the live server and validates the response.")
    // Perform a GET request to fetch posts and validate the response
    public void testGetRequest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("posts")
                .then()
                .extract().response();

        String resData = response.asString();
        System.out.println("Response data: " + resData);

        // Validate the status code and the second post's title
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("title[1]"), "Updated title by the Patch method");
    }

    @Test(priority = 0, groups = {"smoke"}, description = "Fetches the list of posts from the live server and validates the second post's title.")
    // Perform a GET request and validate the status code and response content
    public void testGetRequestAlternateApproach() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("posts")
                .then()
                .statusCode(200)
                .body("title[1]", equalTo("Updated title by the Patch method"));
    }

    @Test(priority = 0, groups = {"smoke"}, description = "Fetches data from the comments endpoint using query parameters and validates the response.")
    // Perform a GET request with query parameters and validate the response
    public void testGetRequestWithQueryParam() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("email", "alice.johnson@example.com")  // Pass a query parameter
                .when()
                .get("comments")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("[0].name", equalTo("Alice Johnson"))
                .extract().response();

        String resData = response.asString();
        System.out.println("Response data: " + resData);
    }
}
