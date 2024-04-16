package Reports;


import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestResult;

public interface AllureTestListener {
    void onTestStart(ITestResult result);

    void onTestSuccess(ITestResult result);

    void onTestFailure(ITestResult result);

    void onTestSkipped(ITestResult result);

    void onTestFailedButWithinSuccessPercentage(ITestResult result);

    void onStart(ITestContext context);

    void onFinish(ITestContext context);

    @Attachment(value = "Screenshot", type = "image/png")
    byte[] captureScreenshot(String testName);
}
