package UI.Tests.ProfilePageTests;

import UI.Pages.ProfilePage.AboutTab;
import UI.Tests.UiBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class AboutTabTests extends UiBaseTest {
    private final String[] expectedTexts = {
            "Company Name: ", "OrangeHRM", "Version:", "OrangeHRM OS 5.6.1 ",
            "Active Employees: ", "90", "Employees Terminated: ", "0"
    };


    @Test(priority = 1,description = "This test navigates to the 'About' page, verifies the visibility and header of the 'About' pop-up, and checks the texts within the pop-up against expected values.")
    public void testAboutTabValidation() throws InterruptedException {
        AboutTab aboutTab = new AboutTab(driver);
        aboutTab.navigateToAboutPage();
        Assert.assertTrue(aboutTab.validatingAboutPopUpVisibility(), "Pop-up is not visible");
        Assert.assertTrue(aboutTab.validatingAboutPopUpHeader(), "Pop-up Header text title is not visible");

        // Validate the texts in the About pop-up
        List<String> mismatches = aboutTab.validateAboutPopupTexts(expectedTexts);
        Assert.assertTrue(mismatches.isEmpty(), "Mismatch found: " + mismatches);
    }

    @Test(priority = 2,description = "This test verifies the visibility of the 'About' pop-up.")
    public void testAboutTabValidationPart2() throws InterruptedException {
        AboutTab aboutTab = new AboutTab(driver);
        aboutTab.navigateToAboutPage();
        Assert.assertTrue(aboutTab.validatingAboutPopUpVisibility(), "Pop-up is not visible");
    }


}