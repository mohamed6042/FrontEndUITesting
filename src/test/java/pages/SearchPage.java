package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.Hooks;

import java.util.List;

public class SearchPage {

    private By productTitle = By.className("product-title");
    private By productSKU = By.className("sku");



    public List<WebElement> getProductTitles(){
        return Hooks.driver.findElements(productTitle);
    }

    public void clickOnProductInSearchPage(){
        Hooks.driver.findElement(productTitle).click();
    }

    public String getActualSKU(){
        return Hooks.driver.findElement(productSKU).getText();
    }
}
