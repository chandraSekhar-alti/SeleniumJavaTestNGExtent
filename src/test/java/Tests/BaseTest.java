package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import Utils.*;
import Reports.ExtentReportManager;

public class BaseTest {

    protected static ExtentReports extent;
    protected static ExtentTest test;
    public static WebDriver driver;

    @BeforeSuite
    public void setUpReports() {
        extent = ExtentReportManager.getExtentInstance();
    }

    @BeforeMethod
    public void setup(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        test = extent.createTest(this.getClass().getSimpleName() + "." + testName);

        // Set up WebDriver and open the browser
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        UI.waitForElement(By.className("orangehrm-login-logo"));
        loginUser();
        UI.waitForElement(By.xpath("//img[@alt='client brand banner']"));
    }

    @AfterMethod
    public void tearDown() {
        // Check the status of the test and report pass or fail accordingly
        if (test.getStatus() == Status.FAIL) {
            test.fail("Test failed");
        } else {
            test.pass("Test passed");
        }

        // Quit WebDriver
        if (driver != null) {
            driver.quit();
        }
    }
    @AfterSuite
    public void tearDownReports() {
        // Write and close the report
        extent.flush();
    }
    @AfterTest
    public void closeExtent() {
        // Flush and close the ExtentReports instance
        if (extent != null) {
            extent.flush();
        }
    }

    public static void loginUser() {
        // Perform login steps
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
