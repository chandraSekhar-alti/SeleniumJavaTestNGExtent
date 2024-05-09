package API.Tests.AuthOperations;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class OauthTest {

    private static final String CLIENT_ID = "AVBLq2GKC37slzUEtx8xAH_CcS-vlpjRH8OASvvx5WaglArqMLTOonYBsAkhhEAiyV722sHEe4IoO_91";
    private static final String CLIENT_SECRET = "EA31Q2bo7emgRV-JKB9uzi6wQIwUKNhD5Rj6ZBMehjj4a7m2bbZVS3r-tM-LycTWHk57jNb5u_ImmntR";
    private static final String PAYPALL_OAUTH_URL = "https://api.sandbox.paypal.com/v1/oauth2/token";
    private static final String PAYPALL_API_URL = "https://api.sandbox.paypal.com/v2/invoicing/templates";
    private String Access_Token;


    @Test(priority = 0)
    public  void testGetPayPallInvoiceTemplatesList() {

        /*
        * 1. Get the Client id and secret.
        * 2. Get the Access token using client id and Secret
        * 3. Hit the end point and get the data using access token
        * */

        RestAssured.baseURI = PAYPALL_OAUTH_URL;
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.auth().preemptive().basic(CLIENT_ID, CLIENT_SECRET);
        requestSpecification.param("grant_type","client_credentials");

        Response response = requestSpecification.post();
        Access_Token = response.jsonPath().getString("access_token");

        RestAssured.baseURI = PAYPALL_API_URL;
        requestSpecification = RestAssured.given();
        requestSpecification.headers("Authorization","Bearer "+Access_Token);
        requestSpecification.headers("Content-Type","application/json");

        response = requestSpecification.get();
        System.out.println("Final response from the server is :- "+response.getBody().asPrettyString());

    }

    @Test(priority = 1)
    public  void testGetPayPallInvoiceTemplatesListWay2() {
        //This performs same action of testGetPayPallInvoiceTemplatesList() method but here the coding style is different

        Access_Token = RestAssured.given()
                .auth().preemptive().basic(CLIENT_ID,CLIENT_SECRET)
                .param("grant_type","client_credentials")
                .when()
                .post(PAYPALL_OAUTH_URL)
                .jsonPath().getString("access_token");

        RestAssured.given()
                .headers("Authorization","Bearer "+Access_Token)
                .headers("Content-Type","application/json")
                .when()
                .get(PAYPALL_API_URL)
                .then()
                .log().body();

    }

}
