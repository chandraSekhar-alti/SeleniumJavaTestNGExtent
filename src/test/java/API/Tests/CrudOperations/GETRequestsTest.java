package API.Tests.CrudOperations;

import API.Tests.ApiBaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class GETRequestsTest extends ApiBaseTest {

    @Test
    //performing get action and storing the data in response variable and doing assertions
    public void testGetReqTypeOne(){
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("posts")
                .then()
                .extract().response();

        String resData = response.asString();

        System.out.println("resData :- "+resData);
        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals("Understanding REST APIs",response.jsonPath().getString("title[1]"));
    }

    @Test
    //Performing get action on API and doing assertion at the same time
    public void testGetReqTypeTwo(){
        given()
                .contentType(ContentType.JSON)
        .when()
                .get("posts")
        .then()
                .statusCode(200)
                .body("title[1]",equalTo("Understanding REST APIs"));
    }

    @Test
    //Performing GET action on API with passing the Query parameters
    public void testGetRequestWithQueryParam(){
        Response response = given()
                .contentType(ContentType.JSON)
                .param("email", "alice.johnson@example.com")
                .when()
                .get("comments")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("[0].name", equalTo("Alice Johnson"))
                .extract().response();

        String resData = response.asString();
        System.out.println("resData :- "+resData);
    }
}
