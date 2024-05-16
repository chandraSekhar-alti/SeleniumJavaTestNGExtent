package Accessibility;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
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
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = captureScreenshot(driver, result.getName());
            test.fail("Test Failed: " + result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped: " + result.getThrowable());
        } else {
            test.pass("Test Passed");
        }

        extentReports.flush();

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

    private String captureScreenshot(WebDriver driver, String screenshotName){
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String screenshotPath = System.getProperty("user.dir") + "src/test/java/Accessibility/Reports/Screenshots/" + screenshotName +"_screenshot.png";
            File destination  = new File(screenshotPath);
            FileUtils.copyFile(source, destination );
            return screenshotPath;

        } catch (IOException e) {
            System.out.println("Expection while taking screenshot :: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }


}
