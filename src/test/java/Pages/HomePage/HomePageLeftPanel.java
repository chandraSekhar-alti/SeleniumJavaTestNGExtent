package Pages.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageLeftPanel {
    public WebDriver driver;

    public HomePageLeftPanel(WebDriver driver) {
        this.driver = driver;
    }

    public By homePageLogoImage = By.cssSelector("div[class='oxd-brand-banner'] > img");


}
