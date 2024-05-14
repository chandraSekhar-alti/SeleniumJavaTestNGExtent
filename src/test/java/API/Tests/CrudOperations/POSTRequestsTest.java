package API.Tests.CrudOperations;

import API.Tests.ApiBaseTest;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class POSTRequestsTest extends ApiBaseTest {
    // HTTP POST request is used to post data or create a resource on a server.
    // To send a POST request in REST Assured, we use the `post()` method.

    private static JsonObject createRequestBody(String postId, String title, int views) {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("postId", postId);
        requestBody.addProperty("title", title);
        requestBody.addProperty("views", views);
        return requestBody;
    }

    @Test(priority = 3, groups = {"smoke"}, description = "Updates an existing post with a full JSON payload and validates the response.")    // Perform a POST request to create a new record and validate the response
    public void testPostRequest() {
        // Create the request body with relevant data
        JsonObject requestBody = createRequestBody("500", "Post data successfully done!!!!", 190);
        System.out.println("Request body: " + requestBody);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .extract().response();

        // Validate the response status code
        Assert.assertEquals(response.statusCode(), 201);
        System.out.println("Response status code: " + response.statusLine());
        System.out.println("Response body: " + response.asString());
    }

    @Test(priority = 3, groups = {"smoke"}, description = "Updates a specific field of an existing post using a PATCH request and validates the response.")
    // Perform a POST request with a different set of data and validate the response
    public void testPostRequestTypeTwo() {
        JsonObject requestParams = new JsonObject();
        requestParams.addProperty("postID", "20");
        requestParams.addProperty("title", "Post data successfully done by the second method!!!!");
        requestParams.addProperty("views", 200);

        // Set up the request specification
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestParams.toString());

        // Perform POST request to create a new record
        Response response = request.post("/posts/");

        // Validate the response status code
        Assert.assertEquals(response.statusCode(), 201);
        System.out.println("The status received: " + response.statusLine());
        System.out.println("Response body: " + response.asString());
    }
}