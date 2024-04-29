package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GetRequest{
    @Test
    public void testResponce(){
        Response resp = RestAssured.get("https://reqres.in/api/users?page=2");

        int code = resp.getStatusCode();
        System.out.println("resp is  :- "+ resp);

        System.out.println("Status code :- "+ code);
        Assert.assertEquals(code, 200);

    }

    @Test
    public void testResponceBody(){

        Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
        String data = resp.asString();
        System.out.println("respomce time is :- "+resp.time());
        System.out.println("resp is  :- "+ data);

    }


}
