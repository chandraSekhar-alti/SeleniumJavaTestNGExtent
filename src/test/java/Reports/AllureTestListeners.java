package Reports;

import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class AllureTestListeners extends AllureTestNg implements AllureTestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // Add any setup or annotation for test start, if needed
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Add any success-related annotations
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Capture screenshots and add to Allure reports on test failure
        captureScreenshot(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Add any skipped test-related annotations
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Handle failures within success percentage
    }

    @Override
    public void onStart(ITestContext context) {
        // Optional: Add any context initialization code here
    }

    @Override
    public void onFinish(ITestContext context) {
        // Optional: Add any context cleanup code here
    }

    @Override
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] captureScreenshot(String testName) {
        // Implement screenshot capturing
        // For example, using Selenium:
        // TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        // return takesScreenshot.getScreenshotAs(OutputType.BYTES);
        return new byte[0]; // Placeholder
    }
}
