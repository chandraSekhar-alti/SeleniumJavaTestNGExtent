package Accessibility;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.List;

import java.lang.reflect.Method;
import java.util.Properties;


public class AccessibilityBaseTest {
    protected WebDriver driver;
    protected ExtentReports extentReports;
    protected ExtentTest test;
    public static Properties properties;

    @BeforeMethod
    public void setup(Method method) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Utils.loadProperties();

        String className = this.getClass().getSimpleName();
        String testName = method.getName();

        test = extentReports.createTest(testName);
        test.assignCategory(className);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @AfterSuite
    public void teardownReporting() {
        extentReports.flush();
    }

    @BeforeSuite
    public void setupReporting() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/src/test/java/Accessibility/Reports/accessibility_report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }


}
