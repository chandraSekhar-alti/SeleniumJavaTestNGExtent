package Pages.HomePage;

import Tests.BaseTest;
import Utils.UI;
import org.bouncycastle.pqc.crypto.newhope.NHSecretKeyProcessor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import static Tests.BaseTest.properties;

public class MyInfoPage {
    public static WebDriver driver;

    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public By myInfoSideBarButton = By.xpath("//li[@class='oxd-main-menu-item-wrapper']/a/span[text()='My Info']");

    public By infoFields = By.cssSelector("div[class='oxd-input-group oxd-input-field-bottom-space']");


    public void navigatingToMyInfoTab() {
        UI.waitForElement(myInfoSideBarButton);
        UI.isElementDisplayed(myInfoSideBarButton);
        UI.highlightElementByGreen(myInfoSideBarButton);
        UI.clickElement(myInfoSideBarButton);
        UI.sleep(3000);
    }


    public boolean verifyingMyInfoPageURL() {
        boolean valueToReturn = false;
        BaseTest.loadProperties();
        String MYINFO_URL = properties.getProperty("MyInfoPageURL");

        if (UI.isPageURL(MYINFO_URL)) {
            valueToReturn = true;
        }
        return valueToReturn;
    }

    public void inputFieldsVisibilityValidation() {
        List<WebElement> elements = driver.findElements(infoFields);

        for (WebElement element : elements) {
            UI.waitForElement(element);
            UI.isElementDisplayed(element);
            UI.highlightElementByGreen(element);
            UI.scrollIntoViewCenter(element);
            UI.sleep(500);
        }
    }
}
