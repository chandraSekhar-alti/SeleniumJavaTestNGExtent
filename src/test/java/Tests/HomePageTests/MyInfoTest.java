package Tests.HomePageTests;

import Pages.HomePage.MyInfoPage;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Tests.BaseTest.driver;

public class MyInfoTest extends BaseTest {

    @Test
    public void testNavigatingToMyinfoPageAndValidatingPage(){
        MyInfoPage myInfoPage = new MyInfoPage(driver);

        myInfoPage.navigatingToMyInfoTab();
        Assert.assertTrue(myInfoPage.verifyingMyInfoPageURL(),"URL validation fail");
        myInfoPage.inputFieldsVisibilityValidation();
    }
}
