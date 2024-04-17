package Pages.HomePage;


import Utils.UI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageLeftPanel {
    public WebDriver driver;

    public HomePageLeftPanel(WebDriver driver) {
        this.driver = driver;
    }

    public By homePageLogoImage = By.cssSelector("div[class='oxd-brand-banner'] > img");

    public By leftPanelItems = By.cssSelector("a[class='oxd-main-menu-item']");

    public By dashBoardCards = By.cssSelector("div[class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget'] > div ");

    public void validatingSideBarPanel() {
        List<WebElement> elements = driver.findElements(leftPanelItems);

        for (WebElement element : elements) {
            UI.isElementDisplayed(element);
            UI.highlightElementByGreen(element);
            UI.sleep(500);
        }
    }

    public void validatingDashBoardCards() {
        List<WebElement> elements = driver.findElements(dashBoardCards);
        for (int i = 0; i < 7; i++) {
            WebElement cardDiv = elements.get(i);
            UI.isElementDisplayed(cardDiv);
            UI.scrollIntoView(cardDiv);
            UI.highlightElementByGreen(cardDiv);
            UI.sleep(500);
        }
    }

}
