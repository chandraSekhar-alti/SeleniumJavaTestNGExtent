package API.Tests.CrudOperations;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DELETERequestsTest {

    // The DELETE request is used to remove a resource from the server.
    // In REST Assured, we send a DELETE request using the `delete()` method.

    @BeforeTest
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test(priority = 4, groups = {"smoke"}, description = "Deletes the record with ID 1 from the 'posts' endpoint on jsonplaceholder.")
    // Perform a DELETE request to remove a specific post
    public void deleteRequest() {
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .delete("/posts/1")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode(), "Expected HTTP status 200");
    }
}
