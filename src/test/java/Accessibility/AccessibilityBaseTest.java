package Accessibility;

import Utils.BrowserActions;
import Utils.UI;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.selenium.AxeBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Collections;
import java.util.List;

//import static Tests.BaseTest.driver;

public class AccessibilityBaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    protected Results performAccessibilityAnalysis() {
        AxeBuilder axeBuilder = new AxeBuilder();
        return axeBuilder.analyze(driver); // Perform analysis
    }

    protected Results performAccessibilityAnalysisWithExclusions(List<String> rulesToExclude) {
        if (rulesToExclude == null) {
            throw new IllegalArgumentException("Rules to exclude cannot be null.");
        }

        AxeBuilder axeBuilder = new AxeBuilder().disableRules(rulesToExclude);
        return axeBuilder.analyze(driver);
    }
}
