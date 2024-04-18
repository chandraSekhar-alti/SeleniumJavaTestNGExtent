package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.logging.Logger;

public class WindowFrameHandling {
    private static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(WindowFrameHandling.class.getName());

    // Constructor to initialize the WebDriver instance
    public WindowFrameHandling(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Switches focus to a specified window or tab.
     *
     * @param windowHandle The handle of the window to switch to.
     */
    public static void switchToWindow(String windowHandle) {
        try {
            driver.switchTo().window(windowHandle);
        } catch (Exception e) {
            LOGGER.severe("Failed to switch to window with handle: " + windowHandle);
            e.printStackTrace();
        }
    }

    /**
     * Switches focus to a specified frame.
     *
     * @param frameElement The web element representing the frame.
     */
    public static void switchToFrame(WebElement frameElement) {
        try {
            driver.switchTo().frame(frameElement);
        } catch (Exception e) {
            LOGGER.severe("Failed to switch to frame: " + frameElement);
            e.printStackTrace();
        }
    }

    /**
     * Switches focus to the default content of the page (outside of any frames).
     */
    public static void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            LOGGER.severe("Failed to switch to default content.");
            e.printStackTrace();
        }
    }

    /**
     * Switches focus to a specified frame by index.
     *
     * @param frameIndex The index of the frame to switch to.
     */
    public static void switchToFrameByIndex(int frameIndex) {
        try {
            driver.switchTo().frame(frameIndex);
        } catch (Exception e) {
            LOGGER.severe("Failed to switch to frame by index: " + frameIndex);
            e.printStackTrace();
        }
    }

    /**
     * Switches focus to a specified frame by its name or ID.
     *
     * @param frameNameOrId The name or ID of the frame to switch to.
     */
    public static void switchToFrameByNameOrId(String frameNameOrId) {
        try {
            driver.switchTo().frame(frameNameOrId);
        } catch (Exception e) {
            LOGGER.severe("Failed to switch to frame by name or ID: " + frameNameOrId);
            e.printStackTrace();
        }
    }

    /**
     * Returns the handle of the current active window.
     *
     * @return The current window handle.
     */
    public static String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }

    /**
     * Returns a set of all window handles.
     *
     * @return A set of all window handles.
     */
    public static Set<String> getAllWindowHandles() {
        return driver.getWindowHandles();
    }
}
