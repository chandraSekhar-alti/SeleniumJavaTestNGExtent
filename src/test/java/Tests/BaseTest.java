package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import Utils.*;

public class BaseTest {


    public static WebDriver driver;


    @BeforeMethod
    public void setup(ITestResult result) {

        // Set up WebDriver and open the browser
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

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
        // Perform login steps
        UI.sendText(By.xpath("//input[@name='username']"), "Admin");
        UI.sendText(By.xpath("//input[@type='password']"), "admin123");
        UI.clickElement(By.xpath("//button[@type='submit']"));
    }
}