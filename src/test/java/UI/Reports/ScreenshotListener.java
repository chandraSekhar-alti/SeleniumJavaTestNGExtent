package UI.Reports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenshotListener implements ITestListener {
    private WebDriver driver;

    // Default constructor
    public ScreenshotListener() {
        // Default constructor
    }

    public ScreenshotListener(WebDriver driver){
        this.driver = driver;
    }

    @Override
    public void onTestFailure(ITestResult result){
        captureScreenshot(result.getName());
    }

    private void captureScreenshot(String testName){
        try{
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "screenshots/" + testName + "_failure.png";
            FileUtils.copyFile(screenshot, new File(screenshotPath));
            System.out.println("Screenshot captured :- "+screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
