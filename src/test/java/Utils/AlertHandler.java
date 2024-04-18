package Utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class AlertHandler {

    private WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(AlertHandler.class.getName());

    // Constructor to initialize the WebDriver instance
    public AlertHandler(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Handles and accepts a browser alert.
     */
    public void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            LOGGER.severe("Failed to accept alert: " + e.getMessage());
        }
    }

    /**
     * Dismisses a browser alert.
     */
    public void dismissAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
            LOGGER.severe("Failed to dismiss alert: " + e.getMessage());
        }
    }

    /**
     * Gets the text from a browser alert.
     *
     * @return The text from the alert, or null if no alert is present.
     */
    public String getAlertText() {
        try {
            Alert alert = driver.switchTo().alert();
            return alert.getText();
        } catch (Exception e) {
            LOGGER.severe("Failed to get alert text: " + e.getMessage());
            return null;
        }
    }

    /**
     * Sends text to a browser alert prompt.
     *
     * @param text The text to send to the alert prompt.
     */
    public void sendAlertText(String text) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(text);
        } catch (Exception e) {
            LOGGER.severe("Failed to send text to alert: " + e.getMessage());
        }
    }
}
