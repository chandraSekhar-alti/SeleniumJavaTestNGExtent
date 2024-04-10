package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public By username = By.xpath("//input[@placeholder=\"Username\"]");

    public void setUsername() {
        driver.findElement(username).sendKeys("hello world");
    }





}
