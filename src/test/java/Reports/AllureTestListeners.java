package Reports;

import Tests.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureTestListeners extends BaseTest implements ITestListener {

    public AllureTestListeners() {

    }

    @Override
    public void onTestStart(ITestResult result) {
        // Add any setup or annotation for test start, if needed
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Add any success-related annotations (optional)
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Capture screenshot and attach it to Allure reports on test failure
        if (driver != null) {
            captureScreenshot(result.getName());
        } else {
            System.out.println("Warning: WebDriver instance not set. Screenshot capture skipped.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Add any skipped test-related annotations (optional)
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }


    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] captureScreenshot(String testName) {

        if (driver instanceof TakesScreenshot) {

            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        System.out.println("NOT GETTING SCREENSHOT*******************************");
        return new byte[0];
    }
}
