package Accessibility.Tests;

import Accessibility.AccessibilityBaseTest;
import Accessibility.AccessibilityReportManager;
import Utils.BrowserActions;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.selenium.AxeBuilder;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import com.deque.html.axecore.results.Results;

import java.io.FileWriter;
import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class AccessibilityTest extends AccessibilityBaseTest {

    @Test
    public void testAccessibility() {
        driver.get("https://www.myntra.com/");
        Results results = performAccessibilityAnalysis();

        String HTML_PATH = System.getProperty("user.dir")+"/src/test/java/Accessibility/Reports/accessibility_report.html";
        String JSON_PATH = System.getProperty("user.dir")+"/src/test/java/Accessibility/Reports/accessibility_report.json";

        saveAccessibilityResultsToJson(results,JSON_PATH );


        AccessibilityReportManager.generateAccessibilityReport(JSON_PATH, HTML_PATH);

//        assertTrue(results.violationFree());
    }

    @Test
    public void testAccessibilityWithExclusions() {
        driver.get("https://www.myntra.com/");
        List<String> rulesToExclude = Arrays.asList("color-contrast", "heading-order", "image-alt", "link-in-text-block", "link-name", "list", "meta-viewport", "region");
        Results results = performAccessibilityAnalysisWithExclusions(rulesToExclude);
        assertTrue(results.violationFree());

        // Generate the accessibility report


    }


}
