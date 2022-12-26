package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.Hooks;

import java.time.Duration;

public class MyProfilePage {

    private By myAccount = By.xpath("//div[@class='header-links']//a[contains(text(),'My account')]");
    public String expectedUrl = "https://demo.nopcommerce.com/";

    public Boolean confirmMyProfile(){
        WebDriverWait wait = new WebDriverWait(Hooks.driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(Hooks.driver.findElement(myAccount)));
        return Hooks.driver.findElement(myAccount).isDisplayed();
    }

    public String getActualUrl(){
        return Hooks.driver.getCurrentUrl();
    }
}
