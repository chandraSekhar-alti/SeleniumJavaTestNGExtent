package API.Tests.CrudOperations;

import API.Tests.ApiBaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PUTRequestsTest extends ApiBaseTest {
//    The PUT request updates a resource but requires the full JSON payload.
//    To send a PUT request in REST-assured, we use the put() method:

    private static final  String requestBody = """
            {
              "id": "1",
              "postId": "08",
              "title": "Updated content by PUT method",
              "views": "200"
            }""";

    @Test
    public void testPutRequest(){
        Response response = given()
                .header("Content-Type","application/json")
                .and()
                .body(requestBody)
                .when()
                .put("posts/1")
                .then()
                .extract().response();

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(1,response.jsonPath().getInt("id"));
        Assert.assertEquals("08", response.jsonPath().getString("postId"));
        Assert.assertEquals("Updated content by PUT method",response.jsonPath().getString("title"));
        Assert.assertEquals("200",response.jsonPath().getString("views"));
    }


    //PATCH Request
    //The PATCH request updates a resource but requires only the field(s) which is being updated in the payload:
    @Test
    public void testPatchRequest(){

        String patchResponseBody = """
                {
                "title":"Updated title by the Patch method"
                }
                """;
        Response response = given()
                .header("Content-Type", "application/json")
                .and()
                .body(patchResponseBody)
                .when()
                .patch("posts/2")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("02", response.jsonPath().getString("postId"));
        Assert.assertEquals("Updated title by the Patch method",response.jsonPath().getString("title"));
        Assert.assertEquals("200", response.jsonPath().getString("views"));
    }
}
