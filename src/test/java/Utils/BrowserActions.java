package Utils;

import java.util.logging.Logger;
import static Tests.BaseTest.driver;
public class BrowserActions {


    private static final Logger LOGGER = Logger.getLogger(BrowserActions.class.getName());


    /**
     * Navigates the browser to the specified URL.
     *
     * @param url The URL to navigate to.
     */
    public static void navigateToUrl(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            LOGGER.severe("Failed to navigate to URL: " + url);
            e.printStackTrace();
        }
    }

    /**
     * Navigates the browser back one page in its history.
     */
    public static void navigateBack() {
        try {
            driver.navigate().back();
        } catch (Exception e) {
            LOGGER.severe("Failed to navigate back.");
            e.printStackTrace();
        }
    }

    /**
     * Navigates the browser forward one page in its history.
     */
    public static void navigateForward() {
        try {
            driver.navigate().forward();
        } catch (Exception e) {
            LOGGER.severe("Failed to navigate forward.");
            e.printStackTrace();
        }
    }

    /**
     * Refreshes the current page.
     */
    public static void refreshPage() {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            LOGGER.severe("Failed to refresh the page.");
            e.printStackTrace();
        }
    }

    /**
     * Closes the current browser window.
     */
    public static void closeWindow() {
        try {
            driver.close();
        } catch (Exception e) {
            LOGGER.severe("Failed to close the current window.");
            e.printStackTrace();
        }
    }

    /**
     * Quits the browser session and closes all browser windows.
     */
    public static void quitBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            LOGGER.severe("Failed to quit the browser session.");
            e.printStackTrace();
        }
    }

    /**
     * Checks if the current page URL matches the expected URL.
     *
     * @param expectedURL The expected URL to compare with the current URL.
     * @return True if the current URL matches the expected URL, otherwise False.
     */
    public static boolean isPageURL(String expectedURL) {
        String currentURL = driver.getCurrentUrl();
        return currentURL.equals(expectedURL);
    }
}
