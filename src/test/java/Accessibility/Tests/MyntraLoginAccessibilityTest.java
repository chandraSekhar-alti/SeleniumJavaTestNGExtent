package Accessibility.Tests;

import Accessibility.AccessibilityBaseTest;
import Accessibility.Utils;
import com.deque.html.axecore.results.Results;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class MyntraLoginAccessibilityTest extends AccessibilityBaseTest {

    @Test
    public void testLoginPageAccessibility() {

        driver.get("https://www.myntra.com/login");
        List<String> rulesToExclude = Arrays.asList("color-contrast", "heading-order", "image-alt", "link-in-text-block", "link-name", "list", "meta-viewport", "region");
        Results results = Utils.performAccessibilityAnalysisWithElementExclusions(rulesToExclude);
        assertTrue(results.violationFree());
    }
}
