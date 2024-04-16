package Pages.ProfilePage;

import Utils.UI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AboutTab {
    private final WebDriver driver;

    private final By userDropdown = By.cssSelector("span[class='oxd-userdropdown-tab']");
    private final By aboutMenuOption = By.xpath("//ul[@role='menu']/li/a[text()='About']");
    private final By aboutPopup = By.cssSelector("div[role='document']");
    private final By aboutPopupHeader = By.cssSelector("div[class='orangehrm-modal-header'] > h6");
    private final By aboutPopupContent = By.cssSelector("div[class='oxd-grid-item oxd-grid-item--gutters'] > p");

    public AboutTab(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAboutPage() throws InterruptedException {
        UI.waitForElement(userDropdown);
        UI.clickElement(userDropdown);
        UI.waitForElement(aboutMenuOption);
        UI.clickElement(aboutMenuOption);
    }

    public boolean validatingAboutPopUpVisibility(){
        UI.waitForElement(aboutPopup);
        return UI.isElementDisplayed(aboutPopup);
    }

    public boolean validatingAboutPopUpHeader(){
        UI.waitForElement(aboutPopupHeader);
        return  UI.isElementDisplayed(aboutPopupHeader);
    }
    public List<String> validateAboutPopupTexts(String[] expectedTexts) {
        List<String> mismatches = new ArrayList<>();
        List<WebElement> elements = driver.findElements(aboutPopupContent);

        for (int i = 0; i < elements.size(); i++) {
            String actualText = elements.get(i).getText().trim();
            String expectedText = expectedTexts[i].trim();

            if (!actualText.equals(expectedText)) {
                mismatches.add("Expected: " + expectedText + ", but got: " + actualText);
                UI.highlightElementByRed(elements.get(i));
            } else {
                UI.highlightElementByGreen(elements.get(i));
                UI.sleep(500);
            }
        }
        System.out.println("mismatches -------------------"+mismatches);
        return mismatches;
    }
}
