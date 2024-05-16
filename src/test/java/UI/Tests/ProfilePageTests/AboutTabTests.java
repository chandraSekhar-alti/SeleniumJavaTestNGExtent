package UI.Tests.ProfilePageTests;

import UI.Pages.ProfilePage.AboutTab;
import UI.Tests.UiBaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;


public class AboutTabTests extends UiBaseTest {

    @Test(priority = 1, groups = {"regression"},description = "This test navigates to the 'About' page, verifies the visibility and header of the 'About' pop-up, and checks the texts within the pop-up against expected values.")
    @Description("This test navigates to the 'About' page, verifies the visibility and header of the 'About' pop-up, and checks the texts within the pop-up against expected values.")
    @Epic("UI Testing")
    @Story("https://www.example.com")
    @Parameters({"expectedText1", "expectedText2","expectedText3","expectedText4","expectedText5","expectedText6","expectedText7","expectedText8"})
    public void testAboutTabValidation(String expectedText1,String expectedText2,String expectedText3,String expectedText4,String expectedText5,String expectedText6,String expectedText7,String expectedText8) throws InterruptedException {
        AboutTab aboutTab = new AboutTab(driver);
        aboutTab.navigateToAboutPage();
        Assert.assertTrue(aboutTab.validatingAboutPopUpVisibility(), "Pop-up is not visible");
        Assert.assertTrue(aboutTab.validatingAboutPopUpHeader(), "Pop-up Header text title is not visible");

        String [] expectedTexts = {expectedText1,expectedText2,expectedText3,expectedText4,expectedText5,expectedText6,expectedText7,expectedText8};
        // Validate the texts in the About pop-up
        List<String> mismatches = aboutTab.validateAboutPopupTexts(expectedTexts);
        Assert.assertTrue(mismatches.isEmpty(), "Mismatch found: " + mismatches);
    }


    @Test(priority = 2, groups = {"regression"}, description = "This test verifies the visibility of the 'About' pop-up.")
    @Epic("UI Testing")
    @Story("https://www.example.com")
    public void testAboutTabValidationPart2() throws InterruptedException {
        AboutTab aboutTab = new AboutTab(driver);
        aboutTab.navigateToAboutPage();
        Assert.assertTrue(aboutTab.validatingAboutPopUpVisibility(), "Pop-up is not visible");
    }
}