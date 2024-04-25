package UI.Tests.HomePageTests;

import UI.Pages.HomePage.MyInfoPage;
import UI.Tests.BaseTest;
import net.bytebuddy.build.Plugin;
import org.apache.hc.core5.reactor.Command;
import org.testng.Assert;
import org.testng.annotations.Test;

import static UI.Tests.BaseTest.driver;

public class MyInfoTest extends BaseTest {

    @Test(priority = 1, description = "This test navigates to the 'My Info' page and validates the page's contents and functionality.")
    public void testNavigatingToMyinfoPageAndValidatingPage() {
        MyInfoPage myInfoPage = new MyInfoPage(driver);
        myInfoPage.navigatingToMyInfoTab();
        Assert.assertTrue(myInfoPage.verifyingMyInfoPageURL(), "URL validation fail");
        myInfoPage.inputFieldsVisibilityValidation();
    }

    @Test(priority = 2, description = "This test verifies the submission of the personal details form and checks that the form data is submitted successfully.")
    public void testPersonalDetailsFormSubmission() {
        MyInfoPage myInfoPage = new MyInfoPage(driver);
        myInfoPage.navigatingToMyInfoTab();
        myInfoPage.enterPersonalDetailsForm();
        myInfoPage.clickOnSaveButton();
        myInfoPage.updatingProfilePhoto();
    }
}
