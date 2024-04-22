package Accessibility;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.selenium.AxeBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.results.Results;


public class AccessibilityReportManager {

    protected WebDriver driver;

    protected Results performAccessibilityAnalysis() {
        AxeBuilder axeBuilder = new AxeBuilder();
        return axeBuilder.analyze(driver); // Perform analysis
    }

    protected Results performAccessibilityAnalysisWithExclusions(List<String> rulesToExclude) {
        AxeBuilder axeBuilder = new AxeBuilder().disableRules(Collections.singletonList(rulesToExclude.toString())); // Analysis with exclusions
        return axeBuilder.analyze(driver);
    }



    public static void generateAccessibilityReport(String jsonFilePath, String htmlFilePath) {
        try {
            JSONObject jsonObject = new JSONObject(new String(Files.readAllBytes(Paths.get(jsonFilePath))));
            String reportHtml = createHtmlReport(jsonObject); // Convert JSON to HTML

            try (FileWriter writer = new FileWriter(htmlFilePath)) {
                writer.write(reportHtml); // Write HTML report
            }

            System.out.println("Accessibility report generated: " + htmlFilePath);
        } catch (IOException | JSONException e) {
            System.err.println("Error generating accessibility report: " + e.getMessage());
        }
    }

    private static String createHtmlReport(JSONObject jsonObject) {
        // Example: Convert JSON object to basic HTML report (customized as needed)
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html><body><h1>Accessibility Report</h1>");
        htmlBuilder.append("<pre>").append(jsonObject.toString(4)).append("</pre>");
        htmlBuilder.append("</body></html>");
        return htmlBuilder.toString();
    }

}
