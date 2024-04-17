package Tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import Utils.UI;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class BaseTest {

    public static WebDriver driver;
    protected static Map<String, Map<String, String>> environmentConfig;

    @BeforeMethod
    @Parameters("environment")
    public void setUp(ITestResult result, @Optional("regression") String environment) {
        // Load configuration settings for the specified environment
        loadEnvironmentConfig(environment);

        // Set up WebDriver and launch the Chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Get base URL from the environment configuration
        String baseUrl = environmentConfig.get(environment).get("baseUrl");
        driver.get(baseUrl);

        // Wait for the page to load completely
        UI.waitForElement(By.className("orangehrm-login-logo"));

        // Perform login using the specified environment credentials
        loginUsingEnvironment(environment);

        // Wait for the client brand banner to be visible
        UI.waitForElement(By.xpath("//img[@alt='client brand banner']"));
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser and clean up the driver instance
        if (driver != null) {
            driver.quit();
            driver = null; // Set driver to null for cleanup
        }
    }

    protected void loginUsingEnvironment(String environment) {
        // Retrieve username and password from the environment configuration
        String username = environmentConfig.get(environment).get("username");
        String password = environmentConfig.get(environment).get("password");

        // Perform login steps using the retrieved credentials
        UI.sendText(By.xpath("//input[@name='username']"), username);
        UI.sendText(By.xpath("//input[@type='password']"), password);
        UI.clickElement(By.xpath("//button[@type='submit']"));
    }

    // Load the JSON config file based on the specified environment
    private void loadEnvironmentConfig(String environment) {
        // Set default environment to "regression" if none provided
        if (environment == null || environment.isEmpty()) {
            environment = "regression";
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Load JSON config file and map the data to the environmentConfig map
            environmentConfig = objectMapper.readValue(new File("src/test/resources/config.json"), Map.class);
        } catch (IOException e) {
            // Print error stack trace if there's an issue loading the config file
            e.printStackTrace();
        }
    }
}
