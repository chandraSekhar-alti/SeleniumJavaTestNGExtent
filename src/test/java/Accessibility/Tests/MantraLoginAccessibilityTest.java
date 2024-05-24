package Accessibility.Tests;


import Accessibility.Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.selenium.AxeBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class MantraLoginAccessibilityTest{
    protected WebDriver driver;
    protected ExtentTest test;
    protected ExtentReports extent;

    @Test
    public void testLoginPageAccessibility() {

        Utils.loadProperties();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.myntra.com/login");
        List<String> rulesToExclude = Arrays.asList("color-contrast", "heading-order", "image-alt", "link-in-text-block", "link-name", "list", "meta-viewport", "region");

        AxeBuilder axeBuilder = new AxeBuilder();
        for (String element : rulesToExclude) {
            axeBuilder.exclude(element);
        }
        Results results = axeBuilder.analyze(driver);
        assertTrue(results.violationFree());
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
