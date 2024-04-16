package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static Tests.BaseTest.driver;

public class UI {
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    /**
     * Sets a custom timeout duration for wait operations.
     *
     * @param duration The timeout duration.
     */
    public static void setTimeout(Duration duration) {
        // You can implement custom logic for timeout settings here
    }

    /**
     * Waits for a single element located by the specified locator to be visible.
     *
     * @param locator The locator of the element.
     */
    public static void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for a single web element to be visible.
     *
     * @param element The web element to wait for.
     */
    public static void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for a list of web elements to be visible.
     *
     * @param elements The list of web elements to wait for.
     */
    public static void waitForElements(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    /**
     * Clicks on a web element located by the specified locator.
     *
     * @param locator The locator of the element to click.
     */
    public static void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    /**
     * Clicks on the specified web element.
     *
     * @param element The web element to click.
     */
    public static void clickElement(WebElement element) {
        element.click();
    }

    /**
     * Sends text to a web element located by the specified locator.
     *
     * @param locator The locator of the element to send text to.
     * @param text    The text to send.
     */
    public static void sendText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    /**
     * Sends text to the specified web element.
     *
     * @param element The web element to send text to.
     * @param text    The text to send.
     */
    public static void sendText(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * Selects an option in a dropdown by value.
     *
     * @param element The dropdown web element.
     * @param value   The value of the option to select.
     */
    public static void selectDropdownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    /**
     * Selects an option in a dropdown by visible text.
     *
     * @param element     The dropdown web element.
     * @param visibleText The visible text of the option to select.
     */
    public static void selectDropdownByVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    /**
     * Selects an option in a dropdown by index.
     *
     * @param element The dropdown web element.
     * @param index   The index of the option to select.
     */
    public static void selectDropdownByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    /**
     * Checks if a web element is displayed.
     *
     * @param element The web element to check.
     * @return True if the element is displayed, false otherwise.
     */
    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if a web element located by the specified locator is displayed.
     *
     * @param locator The locator of the element to check.
     * @return True if the element is displayed, false otherwise.
     */
    public static boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if a web element is enabled.
     *
     * @param element The web element to check.
     * @return True if the element is enabled, false otherwise.
     */
    public static boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }

    /**
     * Gets the text of a web element.
     *
     * @param element The web element to get text from.
     * @return The text of the element.
     */
    public static String getElementText(WebElement element) {
        return element.getText();
    }

    /**
     * Gets the text of a web element located by the specified locator.
     *
     * @param locator The locator of the element to get text from.
     * @return The text of the element.
     */
    public static String getElementText(By locator) {
        return driver.findElement(locator).getText();
    }

    /**
     * Retrieves a specified attribute value of a web element.
     *
     * @param element   The web element to get the attribute from.
     * @param attribute The attribute name to retrieve the value for.
     * @return The attribute value.
     */
    public static String getElementAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    /**
     * Gets the current URL of the web driver.
     *
     * @return The current URL as a string.
     */
    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Switches the context to an iframe by its index.
     *
     * @param index The index of the iframe to switch to.
     */
    public static void switchToFrame(int index) {
        driver.switchTo().frame(index);
    }

    /**
     * Switches the context to an iframe by its name or ID.
     *
     * @param nameOrId The name or ID of the iframe to switch to.
     */
    public static void switchToFrame(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    /**
     * Switches the context to an iframe using a web element.
     *
     * @param element The web element representing the iframe.
     */
    public static void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    /**
     * Switches the context back to the main content.
     */
    public static void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    /**
     * Puts the current thread to sleep for the specified number of seconds.
     *
     * @param time The number of seconds to sleep.
     * @param timeUnit specific time units either in seconds or milliseconds
     */
    public static void sleep(long time, TimeUnit timeUnit) {
        try {
            if (timeUnit == TimeUnit.SECONDS) {

                Thread.sleep(time * 1000);
            } else if (timeUnit == TimeUnit.MILLISECONDS) {

                Thread.sleep(time);
            } else {
                throw new IllegalArgumentException("Invalid TimeUnit. Use SECONDS or MILLISECONDS.");
            }
        } catch (InterruptedException e) {
            System.out.println("Sleep was interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

//  -------------------------------------------------------------------------------------------

    /**
     * Highlights a single web element by adding a green border.
     *
     * @param element The web element to highlight.
     */
    public static void highlightElementByGreen(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border = '3px solid green';", element);
    }

    /**
     * Highlights a web element located by the specified locator by adding a green border.
     *
     * @param locator The locator of the web element to highlight.
     */
    public static void highlightElementByGreen(By locator) {
        WebElement element = driver.findElement(locator);
        highlightElementByGreen(element);
    }

    /**
     * Highlights a list of web elements by adding a green border to each.
     *
     * @param elements The list of web elements to highlight.
     */
    public static void highlightElements(List<WebElement> elements) {
        for (WebElement element : elements) {
            highlightElementByGreen(element);
        }
    }

    //---------------------------------------------------------------------

    /**
     * Highlights a single web element by adding a green border.
     *
     * @param element The web element to highlight.
     */
    public static void highlightElementByRed(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border = '3px solid red';", element);
    }

    /**
     * Highlights a web element located by the specified locator by adding a green border.
     *
     * @param locator The locator of the web element to highlight.
     */
    public static void highlightElementByRed(By locator) {
        WebElement element = driver.findElement(locator);
        highlightElementByRed(element);
    }

    /**
     * Highlights a list of web elements by adding a green border to each.
     *
     * @param elements The list of web elements to highlight.
     */
    public static void highlightElementByRed(List<WebElement> elements) {
        for (WebElement element : elements) {
            highlightElementByRed(element);
        }
    }

}
