package Accessibility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import com.deque.html.axecore.args.FromFrames;
import com.deque.html.axecore.args.FromShadowDom;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.selenium.AxeBuilder;
import org.openqa.selenium.WebDriver;


public class Utils {

    protected static WebDriver driver;

    public static Properties properties;

    public static Results performAccessibilityAnalysis() {
        AxeBuilder axeBuilder = new AxeBuilder();
        return axeBuilder.analyze(driver);
    }

    public static Results performAccessibilityAnalysisWithExclusionsForMultipleRules(List<String> rulesToExclude) {
        AxeBuilder axeBuilder = new AxeBuilder().disableRules(Arrays.asList(rulesToExclude.toString())); // Analysis with exclusions
        return axeBuilder.analyze(driver);
    }

    public static Results performAccessibilityAnalysisWithExclusionsForSingleRule(String ruleToExclude) {
        AxeBuilder axeBuilder = new AxeBuilder().disableRules(Collections.singletonList(ruleToExclude));
        return axeBuilder.analyze(driver);
    }

    // Perform an analysis excluding specific elements
    public static Results performAccessibilityAnalysisWithElementExclusions(List<String> elementsToExclude) {
        AxeBuilder axeBuilder = new AxeBuilder();
        for (String element : elementsToExclude) {
            axeBuilder.exclude(element);
        }
        return axeBuilder.analyze(driver);
    }

    // Perform an analysis excluding elements from specific iframes
    public static Results performAccessibilityAnalysisWithIframeExclusions(String iframeSelector, List<String> elementsToExclude) {
        AxeBuilder axeBuilder = new AxeBuilder().exclude(new FromFrames(iframeSelector, elementsToExclude.toArray(new String[0])));
        return axeBuilder.analyze(driver);
    }

    // Perform an analysis excluding elements from specific Shadow DOM
    public static Results performAccessibilityAnalysisWithShadowDomExclusions(String shadowDomSelector, List<String> elementsToExclude) {
        AxeBuilder axeBuilder = new AxeBuilder().exclude(new FromShadowDom(shadowDomSelector, Arrays.toString(elementsToExclude.toArray(new String[0]))));
        return axeBuilder.analyze(driver);
    }

    // Load properties from config.properties file
    public static void loadProperties() {
        properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
