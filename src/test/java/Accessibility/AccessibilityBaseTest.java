package Accessibility;

import Utils.BrowserActions;
import Utils.UI;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.selenium.AxeBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.List;


public class AccessibilityBaseTest {
    protected WebDriver driver;
    protected ExtentReports extentReports;
    protected ExtentTest test;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        test = extentReports.createTest("Accessibility Test");
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
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/src/test/java/Accessibility/Reports/accessibility_report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    protected Results performAccessibilityAnalysis() {
        AxeBuilder axeBuilder = new AxeBuilder();
        return axeBuilder.analyze(driver);
    }

    protected Results performAccessibilityAnalysisWithExclusions(List<String> rulesToExclude) {
        if (rulesToExclude == null) {
            throw new IllegalArgumentException("Rules to exclude cannot be null.");
        }

        AxeBuilder axeBuilder = new AxeBuilder().disableRules(rulesToExclude);
        return axeBuilder.analyze(driver);
    }


}
