package Pages.ProfilePage;

import Utils.UI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutTab {
    public WebDriver driver;

    public AboutTab(WebDriver driver) {
        this.driver = driver;
    }

    public By profileDropDown = By.cssSelector("span[class='oxd-userdropdown-tab']");

    public By aboutDropDownText = By.xpath("//ul[@role=\"menu\"]/li/a[text()=\"About\"]");
    public By aboutTab = By.cssSelector("div[role='document']");

    public boolean navigatingToAboutPage() throws InterruptedException {
        boolean valueToReturn = false;

        driver.findElement(profileDropDown).click();
        driver.findElement(aboutDropDownText).click();
        UI.waitForElement(aboutTab);

        WebElement aboutTabVisibility = driver.findElement(aboutTab);
        if (aboutTabVisibility.isDisplayed()) {
            valueToReturn = true;
        }
        return valueToReturn;
    }
}
