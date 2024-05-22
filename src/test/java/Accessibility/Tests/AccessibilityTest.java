package Accessibility.Tests;


import Accessibility.AccessibilityBaseTest;
import Accessibility.Utils;
import com.deque.html.axecore.results.Results;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

public class AccessibilityTest extends AccessibilityBaseTest {


    @Test
    public void testHomePageAccessibility() {
        String URL = Utils.properties.getProperty("MyntraHomePageURL");
        driver.get(URL);

        Results results = Utils.performAccessibilityAnalysis();

        if (results.violationFree()) {
            test.pass("No violations found");
        } else {
            results.getViolations().forEach(v -> {
                test.fail("Violation found: " + v.getDescription());
            });
        }
    }


    @Test
    public void testMensPageAccessibility() {
        String URL = Utils.properties.getProperty("MyntraMensPage");
        driver.get(URL);
        List<String> rulesToExclude = Arrays.asList("color-contrast", "heading-order", "image-alt", "link-in-text-block", "link-name", "list", "meta-viewport", "region");
        Results results = Utils.performAccessibilityAnalysisWithExclusionsForMultipleRules(rulesToExclude);
        assertTrue(results.violationFree());
    }

    @Test
    public void testWomenPageAccessibility() {
        String URL = Utils.properties.getProperty("MyntraWomensPageURL");
        driver.get(URL);
        String rulesToExclude = "color-contrast";
        Results results = Utils.performAccessibilityAnalysisWithExclusionsForSingleRule(rulesToExclude);
        assertTrue(results.violationFree());
    }

    @Test
    public void testKidsPageAccessibility() {
        String URL = Utils.properties.getProperty("MyntraKidsPageURL");
        driver.get(URL);
        List<String> rulesToExclude = Arrays.asList("#header", "#footer");
        Results results = Utils.performAccessibilityAnalysisWithElementExclusions(rulesToExclude);
        assertTrue(results.violationFree());
    }

    @Test
    public void testHomeAndLivingPageAccessibility() {
        String URL = Utils.properties.getProperty("MyntraHomeAndLivingPageURL");
        driver.get(URL);
        List<String> rulesToExclude = Arrays.asList("color-contrast", "heading-order", "image-alt", "link-in-text-block", "link-name", "list", "meta-viewport", "region");
        Results results = Utils.performAccessibilityAnalysisWithIframeExclusions("#parent-iframe", Arrays.asList(".ad-banner"));
        assertNotNull("Accessibility results should not be null", results);

    }

    @Test
    public void testBeautyPageAccessibility() {
        String URL = Utils.properties.getProperty("MyntraPersonalCareURL");
        driver.get(URL);
        Results results = Utils.performAccessibilityAnalysisWithShadowDomExclusions("blog-comments", Arrays.asList(".comment"));

        assertNotNull("Accessibility results should not be null", results);
    }

    @Test
    public void testStudioPageAccessibility() {
        String URL = Utils.properties.getProperty("MyntraStudioPageURL");
        driver.get(URL);
        Results results = Utils.performAccessibilityAnalysis();
        assertTrue(results.violationFree());
    }
}
