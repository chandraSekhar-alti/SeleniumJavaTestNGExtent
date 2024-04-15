package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getExtentInstance() {
        if (extent == null) {
            // Create a new instance of ExtentReports
            extent = new ExtentReports();

            // Specify the path for the report file
            String reportPath = "target/reports/ExtentReport.html";

            // Create a new Spark reporter
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            // Attach the Spark reporter to the ExtentReports instance
            extent.attachReporter(sparkReporter);

            // Optional: Configure the report properties
            sparkReporter.config().setReportName("Automation Test Report");
            sparkReporter.config().setDocumentTitle("Test Report");
        }
        return extent;
    }

}
