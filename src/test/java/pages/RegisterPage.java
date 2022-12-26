package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import stepDefinitions.Hooks;

public class RegisterPage {

    private By firstNameField = By.id("FirstName");
    private By lastNameField = By.id("LastName");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By retypePassword =By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    private By gender = By.id("gender-male");
    private By dayOfBirth = By.name("DateOfBirthDay");
    private By monthOfBirth = By.name("DateOfBirthMonth");
    private By yearOfBirth = By.name("DateOfBirthYear");
    private By company = By.id("Company");
    private By successMessage = By.className("result");

    public void selectGender(){
        Hooks.driver.findElement(gender).click();
    }
    public void enterFirstName(){
        Hooks.driver.findElement(firstNameField).sendKeys("mohamed");
    }

    public void enterLastName(){
        Hooks.driver.findElement(lastNameField).sendKeys("mahmod");
    }

    private Select chooseDate(By element){
        return  new Select(Hooks.driver.findElement(element));
    }

    public void selectDay(String day){
        chooseDate(dayOfBirth).selectByValue(day);
    }

    public void selectMonnth(String month){
        chooseDate(monthOfBirth).selectByValue(month);
    }

    public void selectYear(String year){
        chooseDate(yearOfBirth).selectByValue(year);
    }

    public void enterEmail(){
        Hooks.driver.findElement(emailField).sendKeys("test@gmail.com");
    }

    public void enterCompany(){
        Hooks.driver.findElement(company).sendKeys("TestAutomation");
    }

    public void enterPassword(){
        Hooks.driver.findElement(passwordField).sendKeys("123456789");
    }

    public void reEnterPassword(){
        Hooks.driver.findElement(retypePassword).sendKeys("123456789");
    }

    public void clickRegister(){
        Hooks.driver.findElement(registerButton).click();
    }

    public String getMessage(){
        return Hooks.driver.findElement(successMessage).getText();
    }

    public String getColor(){
        return Hooks.driver.findElement(successMessage).getCssValue("color");
    }





}
