package Tests.HomePageTests;

import Pages.HomePage.HomePageLeftPanel;
import Tests.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageLeftPanelTest extends BaseTest {

    @Test
    public void testHomepageLogoVisibility() {
        HomePageLeftPanel homePage = new HomePageLeftPanel(driver);

        WebElement imageElement = driver.findElement(homePage.homePageLogoImage);

        boolean isImageDisplayed = imageElement.isDisplayed();

        Assert.assertTrue(isImageDisplayed, "Image is not visible");
        homePage.validatingSideBarPanel();
        homePage.validatingDashBoardCards();
    }


}
