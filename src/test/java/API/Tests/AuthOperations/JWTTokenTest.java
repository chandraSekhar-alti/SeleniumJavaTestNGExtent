package API.Tests.AuthOperations;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class JWTTokenTest {

    @Test
    public static void testGenerateJWTToken(){
        Response response = RestAssured.given()
                .contentType("application/json")
                .body("{\"username\":\"chandraalti8978@gmail.com\", \"password\":\"Amma123@\"}")
                .post("https://www.99.co/");

        // Log the response body to see what was returned

        // Response logging to understand what's happening
        //System.out.println("Status code: " + response.getStatusCode());
        //System.out.println("Headers: " + response.getHeaders());
        //System.out.println("Response body: " + response.getBody().asString());


        try {
            String token = response.jsonPath().getString("token");
//            System.out.println("Token is: " + token);
        } catch (Exception e) {
            System.out.println("Error extracting token: " + e.getMessage());
        }
    }
}
