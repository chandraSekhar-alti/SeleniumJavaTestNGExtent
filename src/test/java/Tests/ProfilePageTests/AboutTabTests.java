package Tests.ProfilePageTests;

import Pages.ProfilePage.AboutTab;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutTabTests extends BaseTest {

    @Test
    public void testAboutTabValidation() throws InterruptedException {
        AboutTab aboutTab = new AboutTab(driver);

        Assert.assertTrue(aboutTab.navigatingToAboutPage(), "Pop-up is not visible");
    }
}
