package Tests.ProfilePageTests;

import Pages.ProfilePage.AboutTab;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;


public class AboutTabTests extends BaseTest {
    private final String[] expectedTexts = {
            "Company Name: ", "OrangeHRM", "Version:", "OrangeHRM OS 5.6.1 ",
            "Active Employees: ", "90", "Employees Terminated: ", "0"
    };

    @Test

    public void testAboutTabValidation() throws InterruptedException {
        AboutTab aboutTab = new AboutTab(driver);
        aboutTab.navigateToAboutPage();
        Assert.assertTrue(aboutTab.validatingAboutPopUpVisibility(), "Pop-up is not visible");
        Assert.assertTrue(aboutTab.validatingAboutPopUpHeader(), "Pop-up Header text title is not visible");

        // Validate the texts in the About pop-up
        List<String> mismatches = aboutTab.validateAboutPopupTexts(expectedTexts);
        Assert.assertTrue(mismatches.isEmpty(), "Mismatch found: " + mismatches);
    }

    @Test
    public void testAboutTabValidationPart2() {
        AboutTab aboutTab = new AboutTab(driver);
        Assert.assertTrue(aboutTab.validatingAboutPopUpVisibility(), "Pop-up is not visible");
    }


}