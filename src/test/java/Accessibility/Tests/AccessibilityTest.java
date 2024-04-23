package Accessibility.Tests;

import Accessibility.AccessibilityBaseTest;
import com.deque.html.axecore.results.Results;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class AccessibilityTest extends AccessibilityBaseTest {

    @Test
    public void testAccessibility() {
        driver.get("https://www.myntra.com/");
        Results results = performAccessibilityAnalysis();

        if (results.violationFree()) {
            test.pass("No violations found");
        } else {
            results.getViolations().forEach(v -> {
                test.fail("Violation found: " + v.getDescription());
            });
        }
    }

    @Test
    public void testAccessibilityWithExclusions() {
        driver.get("https://www.myntra.com/");
        List<String> rulesToExclude = Arrays.asList("color-contrast", "heading-order", "image-alt", "link-in-text-block", "link-name", "list", "meta-viewport", "region");
        Results results = performAccessibilityAnalysisWithExclusions(rulesToExclude);
        assertTrue(results.violationFree());
    }


}
