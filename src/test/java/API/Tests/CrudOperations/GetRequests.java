package API.CrudOperations;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class RestAssuredRequests {

    @BeforeTest
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testGetReqTypeOne(){
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .extract().response();

        String resData = response.asString();

        System.out.println("resData :- "+resData);
        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals("qui est esse",response.jsonPath().getString("title[1]"));
    }

    @Test
    public void testGetReqTypeTwo(){
        given()
                .contentType(ContentType.JSON)
        .when()
                .get("/posts")
        .then()
                .statusCode(200)
                .body("title[1]",equalTo("qui est esse"));
    }

    @Test
    public void testGetRequestWithQueryParam(){
        Response response = given()
                .contentType(ContentType.JSON)
                .param("email", "Presley.Mueller@myrl.com")
                .when()
                .get("/comments")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("[0].name", equalTo("et fugit eligendi deleniti quidem qui sint nihil autem"))
                .extract().response();

        String resData = response.asString();
        System.out.println("resData :- "+resData);
    }
}
