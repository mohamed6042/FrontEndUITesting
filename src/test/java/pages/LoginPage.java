package pages;

import org.openqa.selenium.By;
import stepDefinitions.Hooks;

public class LoginPage {

    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.className("login-button");
    public String expectedErrorMessage = "Login was unsuccessful";
    private By actualErrorMessage = By.xpath("//div[contains(@class,'message-error')]");
    public String expectedMessageColor = "#e4434b";



    public void enterEmail(String email){
        Hooks.driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password){
        Hooks.driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin(){
        Hooks.driver.findElement(loginButton).click();
    }

    public String getActualErrorMessage(){
        return Hooks.driver.findElement(actualErrorMessage).getText();
    }

    public String errorMessageColor(){
        return Hooks.driver.findElement(actualErrorMessage).getCssValue("color");
    }


}
