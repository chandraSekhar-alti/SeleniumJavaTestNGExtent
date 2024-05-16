package API.Tests.AuthOperations;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BearerTokenTest {

    private static final String BASE_URL = "https://gorest.co.in";
    private static final String BASE_PATH = "/public/v2/users";
    private static final String Token = "21ac9b0b3b4fdffcac841e90edc3e6f9313f9330b7538d12ca1ae2368ddc252e";


    @Test(description = "Tests the Bearer token authentication with a POST request to create a new user", priority = 1)
    public void testValidateBearerToken(){
        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.baseUri(BASE_URL);
        requestSpecification.basePath(BASE_PATH);
        Faker faker = new Faker();

        String name = faker.name().fullName();
        String uniqueEmail = faker.internet().emailAddress();
        JSONObject payload = new JSONObject();

        payload.put("name",name);
        payload.put("email",uniqueEmail);
        payload.put("gender","female");
        payload.put("status","inactive");

        requestSpecification.header("Authorization","Bearer " +  Token)
                .contentType(ContentType.JSON)
                .body(payload.toJSONString());
        Response response = requestSpecification.post();

        Assert.assertEquals(response.statusCode(), 201, "Expected status code 201 but got " + response.statusCode());
//        System.out.println("response status line " + response.statusLine());
//        System.out.println("response body "+ response.getBody().asPrettyString());


    }
}
