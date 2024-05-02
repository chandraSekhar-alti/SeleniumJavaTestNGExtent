package API.Tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class ApiBaseTest {

    @BeforeTest
    public static void setup() {
        RestAssured.baseURI = "http://localhost:3000/";
    }
}
