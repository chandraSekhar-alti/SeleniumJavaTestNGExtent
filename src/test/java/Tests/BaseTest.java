package Tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import Utils.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public  class BaseTest {


    public static WebDriver driver;
    protected static Properties properties;

    @BeforeMethod
    public void setup(ITestResult result) {
        loadProperties();

        // Set up WebDriver and open the browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String BASE_URL = properties.getProperty("baseUrl");
        driver.get(BASE_URL);
        //wait until to load complete page
        UI.waitForElement(By.className("orangehrm-login-logo"));
        loginUser();
        UI.waitForElement(By.xpath("//img[@alt='client brand banner']"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    public static void loginUser() {

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        // Perform login steps
        UI.sendText(By.xpath("//input[@name='username']"), username);
        UI.sendText(By.xpath("//input[@type='password']"), password);
        UI.clickElement(By.xpath("//button[@type='submit']"));
    }

    // Load properties from config.properties file
    private void loadProperties() {
        properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}