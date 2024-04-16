package Pages.ProfilePage;

import Utils.UI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AboutTab {
    public WebDriver driver;

    public AboutTab(WebDriver driver) {
        this.driver = driver;
    }

    public By profileDropDown = By.cssSelector("span[class='oxd-userdropdown-tab']");

    public By aboutDropDownText = By.xpath("//ul[@role='menu']/li/a[text()='About']");
    public By aboutTab = By.cssSelector("div[role='document']");

    public By popUpHeaderText = By.cssSelector("div[class='orangehrm-modal-header'] > h6");

    public By popUpInText = By.cssSelector("div[class='oxd-grid-item oxd-grid-item--gutters'] > p");

    public boolean navigatingToAboutPage(String[] expectedTexts) throws InterruptedException {
        boolean valueToReturn = false;

        UI.clickElement(profileDropDown);
        UI.clickElement(aboutDropDownText);
        UI.waitForElement(aboutTab);

        WebElement aboutTabVisibility = driver.findElement(aboutTab);
        if (UI.isElementDisplayed(aboutTabVisibility)) {
            valueToReturn = true;
        }
        UI.highlightElementByGreen(driver.findElement(aboutTab));
        UI.sleep(2, TimeUnit.SECONDS);
        aboutPopUpTextValidation(expectedTexts);
        return valueToReturn;
    }

    List<WebElement> elements = new ArrayList<>();

    public void aboutPopUpTextValidation(String[] ExpectedTexts) {

        List<WebElement> elements = driver.findElements(popUpInText);

        List<String> elementTexts = new ArrayList<>();

        for (WebElement element : elements) {
            String text = element.getText();
            elementTexts.add(text);
        }

        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            String text = element.getText().trim();

            if (text.equals(ExpectedTexts[i].trim())) {
                UI.highlightElementByGreen(element);
                UI.sleep(500, TimeUnit.MILLISECONDS);

            } else {
                UI.highlightElementByRed(element);
            }
        }
    }
}
