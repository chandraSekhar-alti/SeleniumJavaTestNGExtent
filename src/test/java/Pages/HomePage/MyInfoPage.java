package Pages.HomePage;

import Tests.BaseTest;
import Utils.BrowserActions;
import Utils.UI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

import static Tests.BaseTest.properties;

public class MyInfoPage {
    public static WebDriver driver;

    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public By myInfoSideBarButton = By.xpath("//li[@class='oxd-main-menu-item-wrapper']/a/span[text()='My Info']");

    public By infoFields = By.cssSelector("div[class='oxd-input-group oxd-input-field-bottom-space']");

    public By firstName = By.cssSelector("input[name='firstName']");

    public By lastName = By.cssSelector("input[name='lastName']");

    public By middleName = By.cssSelector("input[name='middleName']");

    public By employeeID = By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input");

    public By otherID = By.xpath("//label[text()='Other Id']/parent::div/following-sibling::div/input");

    public By driverLicenceNumber = By.xpath("//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div/input");

    public By saveButton = By.xpath("(//button[text()=' Save '])[1]");

    public By employeeProfilePhoto = By.cssSelector("img[class='employee-image']");

    public By uploadButton = By.xpath("//i[@class='oxd-icon bi-plus']/parent::button");

    public void navigatingToMyInfoTab() {
        UI.waitForElement(myInfoSideBarButton);
        UI.isElementDisplayed(myInfoSideBarButton);
        UI.highlightElementByGreen(myInfoSideBarButton);
        UI.clickElement(myInfoSideBarButton);
        UI.sleep(3000);
    }


    public boolean verifyingMyInfoPageURL() {
        boolean valueToReturn = false;
        BaseTest.loadProperties();
        String MYINFO_URL = properties.getProperty("MyInfoPageURL");

        if (BrowserActions.isPageURL(MYINFO_URL)) {
            valueToReturn = true;
        }
        return valueToReturn;
    }

    public void inputFieldsVisibilityValidation() {
        List<WebElement> elements = driver.findElements(infoFields);

        for (WebElement element : elements) {
            UI.waitForElement(element);
            UI.isElementDisplayed(element);
            UI.highlightElementByGreen(element);
            UI.scrollIntoViewCenter(element);
            UI.sleep(500);
        }
    }

    public void enterPersonalDetailsForm() {
        implicitClearField(firstName);
        UI.sendKeys(firstName, "Demo");
        implicitClearField(middleName);
        UI.sendKeys(middleName, "sample");
        implicitClearField(lastName);
        UI.sendKeys(lastName, "User");
        implicitClearField(employeeID);
        UI.sendKeys(employeeID, "FS-200");
        implicitClearField(otherID);
        UI.sendKeys(otherID, "RS-952");
        implicitClearField(driverLicenceNumber);
        UI.sendKeys(driverLicenceNumber, "AP-7653");
    }

    public void implicitClearField(By inputField) {
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(inputField)).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
    }

    public void clickOnSaveButton() {
        UI.isElementDisplayed(saveButton);
        UI.clickElement(saveButton);
        UI.sleep(3000);
    }

    //I have used implicit waits in this function because the application behaviour changes for one run to another
    public void updatingProfilePhoto() {
        if (UI.isElementClickable(employeeProfilePhoto)){
            UI.scrollIntoViewCenter(employeeProfilePhoto);
            UI.sleep(3000);
            UI.clickElement(employeeProfilePhoto);
            UI.sleep(3000);
            WebElement fileInputField = driver.findElement(By.xpath("//input[@type='file']"));
            String imagePath = System.getProperty("user.dir")+"\\src\\test\\resources\\bird-thumbnail.jpg";
            fileInputField.sendKeys(imagePath);
            UI.sleep(3000);
            clickOnSaveButton();
        }else {
            System.out.println("Profile Photo button is not clickable");
            Assert.fail();
        }


    }

}
