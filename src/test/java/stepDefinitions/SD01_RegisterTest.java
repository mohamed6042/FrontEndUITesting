package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.RegisterPage;

public class SD01_RegisterTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();



    @Given("user navigate to registration page")
    public void goToRegisterPage(){
       homePage.goToRegisterPage();
    }

    @When("user select gender type")
    public void gender(){
        registerPage.selectGender();
    }

    @And("enter firstname \"Mohamed\" and lastname \"Mahmod\"")
    public void enterName(){
        registerPage.enterFirstName();
        registerPage.enterLastName();
    }

    @And("user enter date of birth")
    public void selectDateOfBirth(){
        registerPage.selectDay("5");
        registerPage.selectMonnth("10");
        registerPage.selectYear("2000");
    }

    @And("user enter email \"test@gmail.com\" field")
    public void enterEmail(){
        registerPage.enterEmail();
    }

    @And("user enter companyname")
    public void userEnterCompanyname() {
        registerPage.enterCompany();
    }

    @And("user enter password")
    public void userEnterPassword() {
        registerPage.enterPassword();
        registerPage.reEnterPassword();
    }

    @And("click \"register\" button")
    public void clickRegister(){
        registerPage.clickRegister();
    }

    @Then("success message is displayed")
    public void showConfirmMessage(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(registerPage.getMessage(),"Your registration completed","Wrong message");
        softAssert.assertTrue(registerPage.getColor().contains("rgba(76, 177, 124, 1)"));
        softAssert.assertAll();


    }


}
