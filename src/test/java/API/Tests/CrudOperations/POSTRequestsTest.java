package API.Tests.CrudOperations;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.github.javafaker.Number;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class POSTRequestsTest {

    @BeforeTest
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000/";
    }

    // HTTP POST request is used to post data or create a resource on a server.
    // To send a POST request in REST Assured, we use the `post()` method.

    private static JsonObject createRequestBody(Number postId, String title, int views) {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("postId", String.valueOf(postId));
        requestBody.addProperty("title", title);
        requestBody.addProperty("views", views);
        return requestBody;
    }

    Faker faker = new Faker();
    Number idNum = faker.number();
    String title = faker.book().title();
    int minViews = 10;
    int maxViews = 10000;
    int views = faker.number().numberBetween(minViews,maxViews);


    @Test(priority = 0, groups = {"smoke"}, description = "Updates an existing post with a full JSON payload and validates the response.")    // Perform a POST request to create a new record and validate the response
    public void testCreateEntity() {
        // Create the request body with relevant data

        JsonObject requestBody = createRequestBody(idNum, title, views);

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
    }

    @Test(priority = 1, groups = {"smoke"}, description = "Updates a specific field of an existing post using a PATCH request and validates the response.")
    // Perform a POST request with a different set of data and validate the response
    public void testPostRequestAlternateApproach() {
        JsonObject requestParams = new JsonObject();
        requestParams.addProperty("postID", String.valueOf(idNum));
        requestParams.addProperty("title", title);
        requestParams.addProperty("views", views);

        // Set up the request specification
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestParams.toString());

        // Perform POST request to create a new record
        Response response = request.post("/posts/");

        // Validate the response status code
        Assert.assertEquals(response.statusCode(), 201);
    }
}
