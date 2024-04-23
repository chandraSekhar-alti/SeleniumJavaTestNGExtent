package Accessibility;

import java.util.Collections;
import java.util.List;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.selenium.AxeBuilder;
import org.openqa.selenium.WebDriver;


public class Utils {

    protected WebDriver driver;

    protected Results performAccessibilityAnalysis() {
        AxeBuilder axeBuilder = new AxeBuilder();
        return axeBuilder.analyze(driver);
    }

    protected Results performAccessibilityAnalysisWithExclusions(List<String> rulesToExclude) {
        AxeBuilder axeBuilder = new AxeBuilder().disableRules(Collections.singletonList(rulesToExclude.toString())); // Analysis with exclusions
        return axeBuilder.analyze(driver);
    }

}
