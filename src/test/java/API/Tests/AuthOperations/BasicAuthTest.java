package API.Tests.AuthOperations;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BasicAuthTest {

    @Test(priority = 1, groups = {"smoke"}, description = "This test case open the URL and give the credientials for the authecationa and get the responce code from the server")
    public void testBasicAuthentication(){
        Response response = given()
                .header("Content-Type","application/json")
                .auth().preemptive()
                .basic("postman","password")// here we have to pass the username and password for the authencation
                .when()
                .get("https://postman-echo.com/basic-auth");

        System.out.println("Response code from the server :- "+response.statusCode());
    }
}
