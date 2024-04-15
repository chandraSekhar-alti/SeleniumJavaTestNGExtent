package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import static Tests.BaseTest.driver;

public class UI {
    public static void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void sleep(long seconds) throws InterruptedException {
        try {
            Thread.sleep(Duration.ofSeconds(seconds));
        } catch (Exception e) {
            System.out.println("Exception Error :- " + e);
        }

    }
}
