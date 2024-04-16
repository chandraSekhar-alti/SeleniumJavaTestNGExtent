package Tests.ProfilePageTests;

import Pages.ProfilePage.AboutTab;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutTabTests extends BaseTest {

    String[] expectedTexts = {"Company Name: ", "OrangeHRM", "Version:", "OrangeHRM OS 5.6.1 ", "Active Employees: ", "92", "Employees Terminated: ", "0"};

    @Test
    public void testAboutTabValidation() throws InterruptedException {
        AboutTab aboutTab = new AboutTab(driver);

        Assert.assertTrue(aboutTab.navigatingToAboutPage(expectedTexts), "Pop-up is not visible");
    }

    @Test
    public void testAboutTabValidationPart2() throws InterruptedException {
        AboutTab aboutTab = new AboutTab(driver);

        Assert.assertTrue(aboutTab.navigatingToAboutPage(expectedTexts), "Pop-up is not visible");
    }
}
