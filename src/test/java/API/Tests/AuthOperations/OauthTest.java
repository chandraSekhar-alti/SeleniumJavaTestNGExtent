package API.Tests.AuthOperations;



import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.authentication.OAuthSignature;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class OauthTest {
    public static WebDriver driver;

    final String CONSUMER_KEY = "FZ4Olz54LlEzbJU9NFvQXa3my";
    final String CONSUMER_SECRET = "labdakVq7yrKENVAHkm4k4g2SB1wBnYy5kukSdPLTLXB1Dojfj";
    final String ACCESS_TOKEN = "1786000292451848192-b8aAjaqKWzGUtqVnI8I5WVxKftwcC4";
    final String ACCESS_TOKEN_SECRET = "Sc40VjsdXM773NBUA7pl26TNvgse5bmrhNKvZEDSAyKbp";

    final String TWITTER_API_URL = "https://api.twitter.com/1.1/statuses/update.json";
    String tweetMessage = "This is a test tweet via Twitter API using OAuth authentication!";


    @Test
    public void testAPIoAuth() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://twitter.com");
        Thread.sleep(5000);
        WebElement signInButton = driver.findElement(By.xpath("//span[text()='Sign in']"));
        signInButton.click();

        Thread.sleep(20000);

        WebElement usernameInput = driver.findElement(By.xpath("//input[@autocomplete='username']"));
        Thread.sleep(5000);

        WebElement nextBtn = driver.findElement(By.xpath("//span[text()='Next']"));
        usernameInput.sendKeys("@chandra_alti");
        nextBtn.click();
        Thread.sleep(5000);

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("Amma123@");
        Thread.sleep(5000);


        WebElement LoginBtn = driver.findElement(By.xpath("//span[text()='Log in']"));
        LoginBtn.click();
        Thread.sleep(5000);


        Response response = RestAssured.given()
                .auth()
                .oauth(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN, ACCESS_TOKEN_SECRET, OAuthSignature.HEADER)
                .param("status", tweetMessage)
                .post(TWITTER_API_URL);

        if (response.statusCode() == 200) {
            System.out.println("Tweet posted successfully!");
        } else {
            System.out.println("Failed to post tweet. Error: " + response.getBody().asString());
        }
    }


    @Test
    public void newTweet() {
        RestAssured.baseURI = "https://api.twitter.com/2";

        RestAssured.authentication = RestAssured.oauth(CONSUMER_KEY,CONSUMER_SECRET,ACCESS_TOKEN,ACCESS_TOKEN_SECRET );

        Response response = RestAssured.given()
                .header("Content-TYpe", "application/json")
                .body("{\\\"status\\\": \\\"Hello, Twitter! This is my first tweet via REST Assured.\\\"}")
                .post("/tweets");

        System.out.println("Response: " + response.getBody().asString());
        System.out.println("Status Code: " + response.getStatusCode());

    }

}
