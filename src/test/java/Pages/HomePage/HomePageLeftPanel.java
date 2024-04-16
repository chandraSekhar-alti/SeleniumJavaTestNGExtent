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

    public  By leftPanelItems = By.cssSelector("a[class='oxd-main-menu-item']");

    public void validatingSideBarPanel(){
        List<WebElement> elements = driver.findElements(leftPanelItems);

        System.out.println("elements :-----" + elements);

        for (WebElement element : elements) {
            UI.isElementDisplayed(element);
            UI.highlightElementByGreen(element);
            UI.sleep(500);
        }


    }

}
