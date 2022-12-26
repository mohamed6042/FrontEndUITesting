package pages;

import org.openqa.selenium.By;
import stepDefinitions.Hooks;

public class WishlistPage {

    private By quantityNumber = By.className("qty-input");

    public int getQuantity(){
        String actualQuantity =Hooks.driver.findElement(quantityNumber).getAttribute("value");
        int currentQuantityCount = Integer.parseInt(actualQuantity);
        return currentQuantityCount;
    }
}
