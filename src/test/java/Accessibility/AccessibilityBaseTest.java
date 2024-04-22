package Accessibility;

import Utils.BrowserActions;
import Utils.UI;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

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
        return axeBuilder.analyze(driver);
    }

    protected Results performAccessibilityAnalysisWithExclusions(List<String> rulesToExclude) {
        if (rulesToExclude == null) {
            throw new IllegalArgumentException("Rules to exclude cannot be null.");
        }

        AxeBuilder axeBuilder = new AxeBuilder().disableRules(rulesToExclude);
        return axeBuilder.analyze(driver);
    }

    protected void saveAccessibilityResultsToJson(Results results, String filePath) {
        JSONArray violationsArray = new JSONArray();

        List<Rule> violations = results.getViolations(); // Get violations from Results
        for (Rule violation : violations) {
            JSONObject violationJson = new JSONObject();
            violationJson.put("id", violation.getId());
            violationJson.put("impact", violation.getImpact());
            violationJson.put("description", violation.getDescription());
            violationJson.put("helpUrl", violation.getHelpUrl());

            violationsArray.put(violationJson); // Add each violation to the JSON array
        }

        try (FileWriter fileWriter = new FileWriter(new File(filePath))) {
            fileWriter.write(violationsArray.toString(4)); // Save formatted JSON to the file
        } catch (IOException e) {
            System.err.println("Error saving accessibility results: " + e.getMessage());
        }
    }
}
